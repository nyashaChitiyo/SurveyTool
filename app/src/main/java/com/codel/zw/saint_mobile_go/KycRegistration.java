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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.codel.zw.saint_mobile_go.pojo.KycRegistrationPojo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Timer;
import java.util.TimerTask;

import static android.os.Build.VERSION_CODES.O;

public class KycRegistration extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = "KycRegistration";
    String firebase_name;
    Button kycpicbtn, kycnxtbtn;
    ImageView kycpic;
    EditText firstname, lastname, dob, personalphone, homephone, workphone, email, facebook,
            twitter, whatsapp, instagram, homeaddress, workaddress, idnumber, passport, driverlicense,
            nationality, hobies, fhobies, fvisitedmalls, leisuretime, numberofchildren, males, females,
            childreninhouse, childrenunder18, rentcost, utilities, foodgrocery, educationcost, transport,
            savings, houses, furniture, vehicle, land;
    private StorageReference mstorage;
    private FirebaseUser user;
    Spinner religion, employmentstatus, geoclass, edulevel, householdownership;
    ArrayAdapter<CharSequence> adapter1, adapter2, adapter3,adapter4, adapter6;
    private FirebaseAnalytics firebaseAnalytics;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyc_registration);

        mstorage = FirebaseStorage.getInstance().getReference();
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = FirebaseAuth.getInstance().getCurrentUser();

        kycpicbtn = (Button)findViewById(R.id.kycpicbtn);
        kycnxtbtn = (Button)findViewById(R.id.kycnxtbtn);
        kycpic = (ImageView)findViewById(R.id.kycpic);
        religion = (Spinner)findViewById(R.id.religion);
        employmentstatus = (Spinner)findViewById(R.id.employmentstatus);
        geoclass = (Spinner)findViewById(R.id.geoclass);
        edulevel = (Spinner)findViewById(R.id.edulevel);
        householdownership = (Spinner)findViewById(R.id.householdownership);

        //EditText variables for Mobile Go data
        firstname = (EditText)findViewById(R.id.etfirstname);
        lastname = (EditText)findViewById(R.id.etlastname);
        dob = (EditText)findViewById(R.id.edob);
        personalphone = (EditText)findViewById(R.id.etpersonalphone);
        homephone = (EditText)findViewById(R.id.ethomephone);
        workphone = (EditText)findViewById(R.id.etworkphone);
        email = (EditText)findViewById(R.id.etemail);
        facebook = (EditText)findViewById(R.id.etfacebook);
        twitter = (EditText)findViewById(R.id.ettwitter);
        whatsapp = (EditText)findViewById(R.id.etwhatsapp);
        instagram = (EditText)findViewById(R.id.etinstagram);
        homeaddress = (EditText)findViewById(R.id.ethomeaddress);
        workaddress = (EditText)findViewById(R.id.etworkaddress);
        idnumber = (EditText)findViewById(R.id.etidnumber);
        passport = (EditText)findViewById(R.id.etpassport);
        driverlicense = (EditText)findViewById(R.id.etdriverlicense);
        nationality = (EditText)findViewById(R.id.etnationality);
        hobies = (EditText)findViewById(R.id.ethobies);
        fhobies = (EditText)findViewById(R.id.etfhobies);
        fvisitedmalls = (EditText)findViewById(R.id.etfvisitedmalls);
        leisuretime = (EditText)findViewById(R.id.etleisuretime);
        numberofchildren = (EditText)findViewById(R.id.etnumberofchildren);
        males = (EditText)findViewById(R.id.etmales);
        females = (EditText)findViewById(R.id.etfemales);
        childreninhouse = (EditText)findViewById(R.id.etchildreninhouse);
        childrenunder18 = (EditText)findViewById(R.id.etchildrenunder18);
        rentcost = (EditText)findViewById(R.id.etrentcost);
        utilities = (EditText)findViewById(R.id.etutilities);
        foodgrocery = (EditText)findViewById(R.id.etfoodgrocery);
        educationcost = (EditText)findViewById(R.id.eteducationcost);
        transport = (EditText)findViewById(R.id.ettransport);
        savings = (EditText)findViewById(R.id.etsavings);
        houses = (EditText)findViewById(R.id.ethouses);
        vehicle = (EditText)findViewById(R.id.etvehicle);
        furniture = (EditText)findViewById(R.id.etfurniture);
        land = (EditText)findViewById(R.id.etland);







        //Initialising the spinner
        adapter1 = ArrayAdapter.createFromResource(this, R.array.religionarray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        religion.setAdapter(adapter1);

        //Onselect listener
        religion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Initialising the employment status spinner
        adapter2 = ArrayAdapter.createFromResource(this, R.array.employment_status, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employmentstatus.setAdapter(adapter2);

        //initializing the geo-class spinner
        adapter3 = ArrayAdapter.createFromResource(this, R.array.geo_class, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        geoclass.setAdapter(adapter3);

        //initializing education level spinner
        adapter4 = ArrayAdapter.createFromResource(this, R.array.education, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edulevel.setAdapter(adapter4);

        //initializing household ownership
        adapter6 = ArrayAdapter.createFromResource(this, R.array.household, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        householdownership.setAdapter(adapter6);

        kycpicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnkyc = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnkyc,1);
            }
        });

        kycnxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent questionnaire = new Intent(getApplicationContext(), Questionaire.class);
                startActivity(questionnaire);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "GPS continuous sampling ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent mapintent = new Intent(getApplicationContext(), MapsActivity.class);
                        startActivity(mapintent);
                    }
                },600);
            }
        });





        //Navigation Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //onclick *savekyc* button
    public void savekyc (View view){

            Toast.makeText(getApplicationContext(), "Saving data...", Toast.LENGTH_LONG).show();

            final String str_firstname = firstname.getText().toString();
            final String str_lastname = lastname.getText().toString();
            final String str_dob = dob.getText().toString();
        final String str_personalphone = personalphone.getText().toString();
        final String str_homephone = homephone.getText().toString();
        final String str_workphone = workphone.getText().toString();
        final String str_email = email.getText().toString();
        final String str_facebook = facebook.getText().toString();
        final String str_twitter = twitter.getText().toString();
        final String str_whatsapp = whatsapp.getText().toString();
        final String str_instagram = instagram.getText().toString();
        final String str_homeaddress = homeaddress.getText().toString();
        final String str_workaddress = workaddress.getText().toString();
        final String str_idnumber = idnumber.getText().toString();
        final String str_passport = passport.getText().toString();
        final String str_driverlicense = driverlicense.getText().toString();
        final String str_nationality = nationality.getText().toString();
        final String str_hobies = hobies.getText().toString();
        final String str_fhobies = fhobies.getText().toString();
        final String str_fvisitedmalls = fvisitedmalls.getText().toString();
        final String str_leisuretime = leisuretime.getText().toString();
        final String str_numberofchildren = numberofchildren.getText().toString();
        final String str_males = males.getText().toString();
        final String str_females = females.getText().toString();
        final String str_childreninhouse = childreninhouse.getText().toString();
        final String str_childrenunder18 = childrenunder18.getText().toString();
        final String str_rentcost = rentcost.getText().toString();
        final String str_utilities = utilities.getText().toString();
        final String str_foodgrocery = foodgrocery.getText().toString();
        final String str_educationcost = educationcost.getText().toString();
        final String str_transport = transport.getText().toString();
        final String str_savings = savings.getText().toString();
        final String str_houses = houses.getText().toString();
        final String str_vehicle = vehicle.getText().toString();
        final String str_furniture = furniture.getText().toString();
        final String str_land = land.getText().toString();
        final String str_religion = religion.getSelectedItem().toString();
        final String str_employmentstatus = employmentstatus.getSelectedItem().toString();
        final String str_geoclass = geoclass.getSelectedItem().toString();
        final String str_edulevel = edulevel.getSelectedItem().toString();
        final String str_householdownership = householdownership.getSelectedItem().toString();
        final String email = user.getEmail();


            String type = "kycdata";


            if (firebase_name != null) {
                // Name, email address, and profile photo Url
                firebase_name = user.getDisplayName();
                KycRegistrationPojo pojo = new KycRegistrationPojo(str_firstname, str_lastname, str_dob, str_personalphone, str_homephone,
                        str_workphone, str_email, str_facebook, str_twitter, str_whatsapp,
                        str_instagram, str_homeaddress, str_workaddress, str_idnumber, str_passport, str_driverlicense,
                        str_nationality, str_hobies, str_fhobies, str_fvisitedmalls,
                        str_leisuretime, str_numberofchildren, str_males, str_females, str_childreninhouse,
                        str_childrenunder18, str_rentcost, str_utilities, str_foodgrocery, str_educationcost,
                        str_transport, str_savings, str_houses, str_vehicle, str_furniture, str_land, str_religion, str_employmentstatus, str_geoclass, str_edulevel, str_householdownership, email);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("Brand Ambassador");

                //Get online user

                //firebase_name = user.getDisplayName();
                ref.child(firebase_name).child("Know Your Customer").child(str_firstname+" "+str_lastname).setValue(pojo);
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

                                    KycRegistrationPojo pojo = new KycRegistrationPojo(str_firstname, str_lastname, str_dob, str_personalphone, str_homephone,
                                            str_workphone, str_email, str_facebook, str_twitter, str_whatsapp,
                                            str_instagram, str_homeaddress, str_workaddress, str_idnumber, str_passport, str_driverlicense,
                                            str_nationality, str_hobies, str_fhobies, str_fvisitedmalls,
                                            str_leisuretime, str_numberofchildren, str_males, str_females, str_childreninhouse,
                                            str_childrenunder18, str_rentcost, str_utilities, str_foodgrocery, str_educationcost,
                                            str_transport, str_savings, str_houses, str_vehicle, str_furniture, str_land, str_religion, str_employmentstatus, str_geoclass, str_edulevel, str_householdownership, email);

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference ref = database.getReference("Brand Ambassador");

                                    //Get online user

                                    //firebase_name = user.getDisplayName();
                                    ref.child(firebase_username[0]).child("Know Your Customer").child(str_firstname+" "+str_lastname).setValue(pojo);
                                }
                            }
                        });
            }

    }

    @Override
    protected void onActivityResult(final int requestCode,final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final String str_firstname = firstname.getText().toString();
        final String str_lastname = lastname.getText().toString();
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
                         StorageReference filepath = mstorage.child("photos").child("Brand Ambassador").child(firebase_username[0]).child("Know Your Customer").child(str_firstname+" "+str_lastname);
                     filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(KycRegistration.this,"Uploading Successful....",Toast.LENGTH_LONG).show();
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
        getMenuInflater().inflate(R.menu.kyc_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {

            Intent helpintent = new Intent(getApplicationContext(), Help.class);
            startActivity(helpintent);
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
            // Home page
            Intent myhomeintent = new Intent(getApplicationContext(), Surveymodules.class);
            startActivity(myhomeintent);
        } else if (id == R.id.options) {

            Intent optionsintent = new Intent(getApplicationContext(), Options.class);
            startActivity(optionsintent);

        } else if (id == R.id.settings) {

            Intent settingsintent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(settingsintent);

        } else if (id == R.id.account) {

            Intent accountintent = new Intent(getApplicationContext(), account.class);
            startActivity(accountintent);

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
