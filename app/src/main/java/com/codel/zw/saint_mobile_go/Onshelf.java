package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.codel.zw.saint_mobile_go.pojo.OnShelfPojo;
import com.codel.zw.saint_mobile_go.pojo.OrderPlacementPojo;
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

import static android.os.Build.VERSION_CODES.N;
import static android.os.Build.VERSION_CODES.O;

public class Onshelf extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button picbtn, planogrambtn, onshelfbtn;
    EditText Shelf_Share_Percentages,Competitor_SKU_Selling_Price,Own_SKU_Selling_Price,Competitor_POSM,Own_POSM,Competitor_Specials;

    private StorageReference mstorage;
    ImageView shelfimage, planogrampic;
    private FirebaseUser user;
    private String firebase_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onshelf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mstorage = FirebaseStorage.getInstance().getReference();
        setSupportActionBar(toolbar);
        Shelf_Share_Percentages = findViewById(R.id.shelfpercentages);
        Competitor_SKU_Selling_Price = findViewById(R.id.competitorprice);
        Own_SKU_Selling_Price = findViewById(R.id.ownskuprice);
        Competitor_POSM = findViewById(R.id.competitorposm);
        Own_POSM = findViewById(R.id.ownposm);
        Competitor_Specials = findViewById(R.id.competitorspecials);

        user = FirebaseAuth.getInstance().getCurrentUser();
        picbtn = (Button)findViewById(R.id.picbtn);
        planogrambtn = (Button)findViewById(R.id.planogrambtn);
        shelfimage = (ImageView)findViewById(R.id.shelfimage);
        planogrampic = (ImageView)findViewById(R.id.planogrampic);

        onshelfbtn = (Button)findViewById(R.id.onshelfbtn);

        onshelfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Saving data...", Toast.LENGTH_LONG).show();
                String txtShelfShare = Shelf_Share_Percentages.getText().toString();
                String txtCompSKUprice = Competitor_SKU_Selling_Price.getText().toString();
                String txtOwnSku = Own_SKU_Selling_Price.getText().toString();
                String txtCompPosm = Competitor_POSM.getText().toString();
                String txtOwnPosm = Own_POSM.getText().toString();
                String txtCompSpecial = Competitor_Specials.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("Brand Ambassador");
                firebase_name = user.getDisplayName();

                OnShelfPojo pojo = new OnShelfPojo(txtShelfShare,txtCompSKUprice,txtOwnSku,txtCompPosm,txtOwnPosm,txtCompSpecial);
                ref.child(firebase_name).child(Merchandising.month1).child(Merchandising.day_date).child("Merchandising").child(""+Merchandising.date1).child(Merchandising.project_name).child("On Shelf Statistics").setValue(pojo);
                Toast.makeText(Onshelf.this,"Saved OnShelf",Toast.LENGTH_LONG).show();
            }
        });

        picbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnpic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnpic,1);
            }
        });

        planogrambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnplanogram = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnplanogram,2);
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
                                StorageReference filepath = mstorage.child("photos").child("Brand Ambassador").child(firebase_username[0]).child("Merchandising").child("OnShelf").child("Picture Of Shelf").child(Merchandising.userName);
                                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        Toast.makeText(Onshelf.this,"Uploading Successful....",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                            else if(requestCode==2 && resultCode==RESULT_OK){
                                Uri uri = data.getData();
                                StorageReference filepath = mstorage.child("photos").child("Brand Ambassador").child(firebase_username[0]).child("Merchandising").child("OnShelf").child("Attach Planogram").child(Merchandising.userName);
                                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        Toast.makeText(Onshelf.this,"Uploading Successful....",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                        else
                        {
                            if(requestCode==1 && resultCode==RESULT_OK){
                                Uri uri = data.getData();
                                StorageReference filepath = mstorage.child("photos").child("Brand Ambassador").child(firebase_username[0]).child("Merchandising").child("OnShelf").child("Picture Of Shelf").child(Merchandising.userName);
                                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        Toast.makeText(Onshelf.this,"Uploading Successful....",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                            else if(requestCode==2 && resultCode==RESULT_OK){
                                Uri uri = data.getData();
                                StorageReference filepath = mstorage.child("photos").child("Brand Ambassador").child(firebase_username[0]).child("Merchandising").child("OnShelf").child("Attach Planogram").child(Merchandising.userName);
                                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        Toast.makeText(Onshelf.this,"Uploading Successful....",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                    }
                });
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
        getMenuInflater().inflate(R.menu.onshelf, menu);
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
