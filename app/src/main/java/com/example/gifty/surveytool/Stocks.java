package com.example.gifty.surveytool;

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

import com.example.gifty.surveytool.pojo.ShopFloorClosingStock;
import com.example.gifty.surveytool.pojo.ShopFloorStock;
import com.example.gifty.surveytool.pojo.WarehouseStock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Stocks extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Button wosbtn, osbtn, csbtn;
    private FirebaseUser user;
    String firebase_name;
    EditText et_wbrand, et_wpacksize, et_wquantitycounted, et_wbreakages_brand, et_wquantity_breakages,
    et_brand, et_packsize, et_quantitycounted, et_breakages_brand, et_quantity_breakages, et_cbrand,
    et_cpacksize, et_cquantitycounted, et_sales, et_cswarehouse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        user = FirebaseAuth.getInstance().getCurrentUser();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        et_wbrand = (EditText)findViewById(R.id.wbrand);
        et_wpacksize = (EditText)findViewById(R.id.wpacksize);
        et_wquantitycounted = (EditText)findViewById(R.id.wquantitycounted);
        et_wbreakages_brand = (EditText)findViewById(R.id.wbreakages_brand);
        et_wquantity_breakages = (EditText)findViewById(R.id.wquantity_breakages);
        et_brand = (EditText)findViewById(R.id.brand);
        et_packsize = (EditText)findViewById(R.id.packsize);
        et_quantitycounted = (EditText)findViewById(R.id.quantitycounted);
        et_breakages_brand = (EditText)findViewById(R.id.breakages_brand);
        et_quantity_breakages = (EditText)findViewById(R.id.quantity_breakages);
        et_cbrand = (EditText)findViewById(R.id.cbrand);
        et_cpacksize = (EditText)findViewById(R.id.cpacksize);
        et_cquantitycounted = (EditText)findViewById(R.id.cquantitycounted);
        et_sales = (EditText)findViewById(R.id.sales);
        et_cswarehouse = (EditText)findViewById(R.id.cswarehouse);

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

    //Saving opening stock warehouse data
    public void save_warehouse(View view) {

        final String str_et_wbrand = et_wbrand.getText().toString();
        final String str_et_wpacksize = et_wpacksize.getText().toString();
        final String str_et_wquantitycounted = et_wquantitycounted.getText().toString();
        final String str_et_wbreakages_brand = et_wbreakages_brand.getText().toString();
        final String str_et_wquantity_breakages = et_wquantity_breakages.getText().toString();

        if (firebase_name != null) {
            // Name, email address, and profile photo Url
            firebase_name = user.getDisplayName();
            WarehouseStock warehouseStock = new WarehouseStock(str_et_wbrand,str_et_wpacksize,str_et_wquantitycounted,str_et_wbreakages_brand,str_et_wquantity_breakages);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Brand Ambassador");
            ref.child(firebase_name).child("Merchandising").child(Merchandising.project_name).child("Warehouse Opening stock").setValue(warehouseStock);
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

        WarehouseStock warehouseStock = new WarehouseStock(str_et_wbrand,str_et_wpacksize,str_et_wquantitycounted,str_et_wbreakages_brand,str_et_wquantity_breakages);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Brand Ambassador");
        ref.child(firebase_username[0]).child("Merchandising").child(Merchandising.project_name).child("Warehouse Opening stock").setValue(warehouseStock);

        Toast.makeText(getApplicationContext(), "Saving warehouse stocks ...", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

        /*MerchantBackend merchantBackend = new MerchantBackend(this);
        merchantBackend.execute(type, str_et_wbrand, str_et_wpacksize, str_et_wquantitycounted,
                str_et_wbreakages_brand, str_et_wquantity_breakages);*/

    }

    //Saving opening stock shop floor
    public void saveos(View view){

        Toast.makeText(getApplicationContext(), "Saving opening stocks ...", Toast.LENGTH_LONG).show();

        final String str_et_brand = et_brand.getText().toString();
        final String str_et_packsize = et_packsize.getText().toString();
        final String str_et_quantitycounted = et_quantitycounted.getText().toString();
        final String str_et_breakages_brand = et_breakages_brand.getText().toString();
        final String str_et_quantity_breakages = et_quantity_breakages.getText().toString();

        if (firebase_name != null) {
            // Name, email address, and profile photo Url
            firebase_name = user.getDisplayName();
            ShopFloorStock shopFloorStock = new ShopFloorStock(str_et_brand,str_et_packsize,str_et_quantitycounted,str_et_breakages_brand,str_et_quantity_breakages);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Brand Ambassador");
            ref.child(firebase_name).child("Merchandising").child(Merchandising.project_name).child("Shop Floor Opening Stock").setValue(shopFloorStock);
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
        ShopFloorStock shopFloorStock = new ShopFloorStock(str_et_brand,str_et_packsize,str_et_quantitycounted,str_et_breakages_brand,str_et_quantity_breakages);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Brand Ambassador");
        ref.child(firebase_username[0]).child("Merchandising").child(Merchandising.project_name).child("Shop Floor Opening Stock").setValue(shopFloorStock);

        Toast.makeText(getApplicationContext(), "Saving warehouse stocks ...", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    //Saving closing stock data
    public void savecs(View view){

        final String str_et_cbrand = et_cbrand.getText().toString();
        final String str_et_cpacksize = et_cpacksize.getText().toString();
        final String str_et_cquantitycounted = et_cquantitycounted.getText().toString();
        final String str_et_sales = et_sales.getText().toString();
        final String str_et_cswarehouse = et_cswarehouse.getText().toString();

        String type = "closingStock";

        if (firebase_name != null) {
            // Name, email address, and profile photo Url
            firebase_name = user.getDisplayName();
            ShopFloorClosingStock closingStock = new ShopFloorClosingStock(str_et_cbrand,str_et_cpacksize,str_et_cquantitycounted);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Brand Ambassador");
            ref.child(firebase_name).child("Merchandising").child(Merchandising.project_name).child("Shop Floor Closing Stock").setValue(closingStock);
        }
        else
        {
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
                                ShopFloorClosingStock closingStock = new ShopFloorClosingStock(str_et_cbrand,str_et_cpacksize,str_et_cquantitycounted);
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference ref = database.getReference("Brand Ambassador");
                                ref.child(firebase_username[0]).child("Merchandising").child(Merchandising.project_name).child("Shop Floor Closing Stock").setValue(closingStock);

                                Toast.makeText(getApplicationContext(), "Last Tab Saving warehouse stocks ...", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

        /*MerchantBackend merchantBackend = new MerchantBackend(this);
        merchantBackend.execute(type, str_et_cbrand, str_et_cpacksize, str_et_cquantitycounted,
                str_et_sales, str_et_cswarehouse);
        */

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
        getMenuInflater().inflate(R.menu.stocks, menu);
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
