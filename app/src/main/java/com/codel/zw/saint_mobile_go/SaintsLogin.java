package com.codel.zw.saint_mobile_go;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.codel.zw.saint_mobile_go.pojo.GPSTracker;
import com.firebase.geofire.GeoFire;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.location.LocationManager;


import java.util.List;
import java.util.Locale;
import java.util.Timer;

public class SaintsLogin extends AppCompatActivity {

    EditText email, password;
    private FirebaseAuth mAuth;
    private SimpleLocation mLocation;

    Location location;
    double latitude,longitude;
    private FirebaseUser user;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saints_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLocation = new SimpleLocation(this);
        mLocation.setBlurRadius(5000);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpassword);

        }


    public void loginuser(View view) {

        if (!mLocation.hasLocationEnabled()) {
            SimpleLocation.openSettings(this);
        }
        final double latitude = mLocation.getLatitude();

        final double longitude = mLocation.getLongitude();
        LocationManager r = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        location = new Location(""+r);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText)findViewById(R.id.etemail);
        password = (EditText)findViewById(R.id.etpassword);
        user = FirebaseAuth.getInstance().getCurrentUser();


        Toast.makeText(SaintsLogin.this, "Latitude: "+latitude, Toast.LENGTH_SHORT).show();

        Toast.makeText(SaintsLogin.this, "Longitude: "+longitude, Toast.LENGTH_SHORT).show();

        getCompleteAddressString(latitude, longitude);





        /*Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();

        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        if(!str_email.isEmpty() && !str_password.isEmpty()){
        mAuth.signInWithEmailAndPassword(str_email, str_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SaintsLogin.this, "Login Successful",
                                    Toast.LENGTH_SHORT).show();
                            Intent module = new Intent(getApplicationContext(), Surveymodules.class);
                            module.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference ref = database.getReference("Brand Ambassador");



                            FirebaseUser user = mAuth.getCurrentUser();
                            ref.child(user.getDisplayName()).child("location").setValue("7 Mcmeekan road, Milton Park");

                            startActivity(module);
                        } else {

                            Toast.makeText(SaintsLogin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });}
                else
                    Toast.makeText(this,"Please Enter email and Password",Toast.LENGTH_LONG).show();*/
    }

    @Override

    protected void onResume() {

        super.onResume();


        // make the device update its location

        mLocation.beginUpdates();

    }

    @Override

    protected void onPause() {

        // stop location updates (saves battery)

        mLocation.endUpdates();


        super.onPause();

    }
    private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                Toast.makeText(SaintsLogin.this,"My Current loction address" +strReturnedAddress.toString(),Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(SaintsLogin.this,"My Current loction address No Address returned!",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(SaintsLogin.this,"My Current loction address Canont get Address!",Toast.LENGTH_LONG).show();
        }
        return strAdd;
    }
}