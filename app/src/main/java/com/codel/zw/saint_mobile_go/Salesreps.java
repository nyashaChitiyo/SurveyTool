package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Toast;

import com.codel.zw.saint_mobile_go.pojo.KycRegistrationPojo;
import com.codel.zw.saint_mobile_go.pojo.SalesOrderPojo;
import com.codel.zw.saint_mobile_go.pojo.SalesOrderTakingPojo;
import com.codel.zw.saint_mobile_go.pojo.SalesrepsPojo;
import com.codel.zw.saint_mobile_go.pojo.WarehouseStock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Salesreps extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseUser user;
    private EditText brand,packsize,quantity,price;
    private String str_brand,str_packsize,str_quantity,str_price,firebase_name;
    Button questionnairebtn;
    private EditText orderNumber,date,orderPacksize,orderQty;
    private String str_orderNumber,str_date,str_orderPackSize,str_orderQty;
    private EditText orderBrand,orderAmntRcvd,orderTpacksize,orderTquantity;
    private String str_orderBrand,str_orderAmntRcvd,str_orderTpacksize,str_orderTquantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salesreps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        user = FirebaseAuth.getInstance().getCurrentUser();
        brand = (EditText)findViewById(R.id.wbrand);
        packsize = (EditText)findViewById(R.id.wpacksize);
        quantity = (EditText)findViewById(R.id.wquantitycounted);
        price = (EditText)findViewById(R.id.wbreakages_brand);
        orderNumber = (EditText)findViewById(R.id.ordernumber);
        date = (EditText)findViewById(R.id.orderdate);
        orderPacksize = (EditText)findViewById(R.id.wpacksize7);
        orderQty = (EditText)findViewById(R.id.wquantitycounted7);
        orderBrand = (EditText)findViewById(R.id.sbrand);
        orderAmntRcvd = (EditText) findViewById(R.id.price);
        orderTpacksize = (EditText) findViewById(R.id.spacksize);
        orderTquantity = (EditText) findViewById(R.id.squantitycounted);
        questionnairebtn = (Button)findViewById(R.id.questionnairebtn);
        questionnairebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salesque = new Intent(getApplicationContext(), Salesquestionnaire.class);
                startActivity(salesque);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void btnTakeOrder(View view){
        str_orderBrand = orderBrand.getText().toString();
        str_orderAmntRcvd = orderAmntRcvd.getText().toString();
        str_orderTpacksize = orderTpacksize.getText().toString();
        str_orderTquantity = orderTquantity.getText().toString();
        if (firebase_name != null) {
            // Name, email address, and profile photo Url
            firebase_name = user.getDisplayName();
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
                                SalesOrderTakingPojo pojo = new SalesOrderTakingPojo(str_orderBrand,str_orderAmntRcvd,str_orderTpacksize,str_orderTquantity);

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference ref = database.getReference("Brand Ambassador");

                                ref.child(firebase_username[0]).child("Sales and Distribution").child(Sales.projectName).child(str_orderBrand).setValue(pojo);
                            }
                        }
                    });
        }
    }
    public void orderbtnClick(View view){

        str_orderNumber = orderNumber.getText().toString();
        str_date = date.getText().toString();
        str_orderPackSize = orderPacksize.getText().toString();
        str_orderQty = orderQty.getText().toString();
        Toast.makeText(this,str_orderNumber,Toast.LENGTH_LONG).show();
        if (firebase_name != null) {
            firebase_name = user.getDisplayName();
            SalesOrderPojo pojo = new SalesOrderPojo(str_orderNumber,str_date,str_orderPackSize,str_orderQty);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Brand Ambassador");
            ref.child(firebase_name).child("Sales and Distribution").child(Sales.projectName).child(str_orderNumber).setValue(pojo);
            Toast.makeText(this,"Saved price list",Toast.LENGTH_LONG).show();
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
                                SalesOrderPojo pojo = new SalesOrderPojo(str_orderNumber,str_date,str_orderPackSize,str_orderQty);
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference ref = database.getReference("Brand Ambassador");
                                ref.child(firebase_username[0]).child("Sales and Distribution").child(Sales.projectName).child(str_orderNumber).setValue(pojo);
                            }
                        }
                    });
        }
    }

    public void savePriceList(View view){
        str_brand = brand.getText().toString();
        str_packsize = packsize.getText().toString();
        str_price = price.getText().toString();
        str_quantity = quantity.getText().toString();
        if (firebase_name != null) {
            firebase_name = user.getDisplayName();
            SalesrepsPojo pojo = new SalesrepsPojo(str_brand,str_packsize,str_quantity,str_price);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Brand Ambassador");
            ref.child(firebase_name).child("Sales and Distribution").child(Sales.projectName).child(str_brand).setValue(pojo);
            //ref.child(firebase_name).child("Sales and Distribution").child(str_fname).setValue(salesPojo);
            Toast.makeText(this,"Saved price list",Toast.LENGTH_LONG).show();
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

                                SalesrepsPojo pojo = new SalesrepsPojo(str_brand,str_packsize,str_quantity,str_price);

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference ref = database.getReference("Brand Ambassador");
                                ref.child(firebase_username[0]).child("Sales and Distribution").child(Sales.projectName).child(str_brand).setValue(pojo);
                            }
                        }
                    });
        }
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
        getMenuInflater().inflate(R.menu.salesreps, menu);
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