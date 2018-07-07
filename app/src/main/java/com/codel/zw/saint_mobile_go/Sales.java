package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.codel.zw.saint_mobile_go.pojo.SalesPojo;
import com.codel.zw.saint_mobile_go.pojo.ShopFloorStock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sales extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static Date date1;
    Date date;
    SimpleDateFormat simpleDateformat;
    SimpleDateFormat simpleDateformatYear;
    static String month1;
    String month;
    static String day_date;
    static String projectName;
    private FirebaseUser user;
    EditText firstName,lastName,dob,personalNumber,homeNumber,workNumber,email,workAddress,idNumber;
    String firebase_name;
    RadioButton male,female;
    Button nextsalesbtn;
    private StorageReference mstorage;

    public void attachPic(View view){
        Intent btnkyc = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(btnkyc,1);
    }
    @Override
    protected void onActivityResult(final int requestCode,final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s = user.getEmail();
        final String[] firebase_username = s.split("@");
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(firebase_username[0])
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            if(requestCode==1 && resultCode==RESULT_OK){
                                Uri uri = data.getData();
                                StorageReference filepath = mstorage.child("photos").child("Brand Ambassador").child(firebase_username[0]).child("Know Your Customer");
                                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        Toast.makeText(Sales.this,"Uploading Successful....",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                    }
                });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        mstorage = FirebaseStorage.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();
        firebase_name = user.getDisplayName();

        date = new Date();
        date1 = date;
        simpleDateformat = new SimpleDateFormat("MMMMyyyy");
        simpleDateformatYear = new SimpleDateFormat("ddMMMMyyyy");
        month = simpleDateformat.format(date);
        day_date = simpleDateformatYear.format(date);
        month1 =  month;

        firstName = (EditText)findViewById(R.id.firstname);
        lastName = (EditText)findViewById(R.id.lastname);
        dob = (EditText)findViewById(R.id.dob);
        email = (EditText) findViewById(R.id.email);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        personalNumber = (EditText)findViewById(R.id.personalphone);
        homeNumber = (EditText)findViewById(R.id.homephone);
        workNumber = (EditText)findViewById(R.id.workphone);
        workAddress =(EditText)findViewById(R.id.workaddress);
        idNumber = (EditText)findViewById(R.id.idnumber);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nextsalesbtn = (Button)findViewById(R.id.nextsalesbtn);
        nextsalesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str_fname = firstName.getText().toString();
                final String str_lastName = lastName.getText().toString();
                final String str_dob = dob.getText().toString();
                final String str_male = male.getText().toString();
                final String str_female = female.getText().toString();
                final String str_email = email.getText().toString();
                final String str_personalNumber = personalNumber.getText().toString();
                final String str_homeNumber = homeNumber.getText().toString();
                final String str_workNUmber = workNumber.getText().toString();
                final String str_workAddress = workAddress.getText().toString();
                final String str_idNumber = idNumber.getText().toString();

                projectName = str_fname;

                if (firebase_name != null) {
                    // Name, email address, and profile photo Url
                    SalesPojo salesPojo = new SalesPojo(str_fname,str_lastName,str_dob,str_male,str_personalNumber,str_homeNumber,str_workNUmber,str_email,str_workAddress,str_idNumber);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference ref = database.getReference("Brand Ambassador");
                    ref.child(firebase_name).child(month).child(day_date).child("Sales and Distribution").child(""+date).child(str_fname).setValue(salesPojo);
                    Intent nextsales = new Intent(getApplicationContext(), Salesreps.class);
                    startActivity(nextsales);
                    Toast.makeText(Sales.this,"Sales Saved",Toast.LENGTH_LONG).show();
                }
                else {
                    String s = user.getEmail();
                    final String[] firebase_username = s.split("@");
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(firebase_username[0])
                            .build();

                    user.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        SalesPojo salesPojo = new SalesPojo(str_fname,str_lastName,str_dob,str_male,str_personalNumber,str_homeNumber,str_workNUmber,str_email,str_workAddress,str_idNumber);
                                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        DatabaseReference ref = database.getReference("Brand Ambassador");
                                        ref.child(firebase_name).child(month).child(day_date).child("Sales and Distribution").child(""+date).child(str_fname).setValue(salesPojo);
                                        Intent nextsales = new Intent(getApplicationContext(), Salesreps.class);
                                        startActivity(nextsales);
                                        Toast.makeText(Sales.this,"Sales Saved",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sales, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.options) {

        } else if (id == R.id.settings) {

        } else if (id == R.id.account) {

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
