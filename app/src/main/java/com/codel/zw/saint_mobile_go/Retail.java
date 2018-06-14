package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.O;

public class Retail extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText etprojectname,etfullname,etphonenumber,etemailentry,etclient,etba,etwbrand,etwpacksize,etwquantitycounted,
            etwbreakages_brand,etwquantity_breakages,etbrand,etpacksize,etquantitycounted,etbreakages_brand,
            etquantity_breakages,etcbrand,etcpacksize,etcquantitycounted,etsales,etcswarehouse,etshelfpercentages,
            etcompetitorprice,etownskuprice,etcompetitorposm,etownposm,etcompetitorspecials,etsampling,etgiveaways,
            ettillpoints,ettrolleys,etbaskets,etfullname2,etphonenumber2,etemail,etfacebook,ettwitter,etrfullname2,etrphonenumber2,
            etreceiptnumber,etaddress;

    Spinner splocations,spoutlet,spbranchmanagement,spestshoppers,sppeakperiod,spcarparksize;

    ImageView ivshelfimage,ivplanogrampic,ivimagecounter;
    ArrayAdapter<CharSequence> adapter1, adapter2, adapter3, adapter4,adapter6,adapter7;

    Button picbtn,planogrambtn,imgcounterbtn,retailbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retail);
        picbtn = (Button)findViewById(R.id.picbtn);
        planogrambtn = (Button)findViewById(R.id.planogrambtn);
        imgcounterbtn = (Button)findViewById(R.id.imgcounterbtn);
        retailbtn = (Button)findViewById(R.id.retailbtn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Initiate EditText variables
        etprojectname = (EditText)findViewById(R.id.projectname);
        etfullname = (EditText)findViewById(R.id.fullname);
        etphonenumber = (EditText)findViewById(R.id.phonenumber);
        etemailentry = (EditText)findViewById(R.id.emailentry);
        etclient = (EditText)findViewById(R.id.client);
        etba = (EditText)findViewById(R.id.ba);
        etwbrand = (EditText)findViewById(R.id.wbrand);
        etwpacksize = (EditText)findViewById(R.id.wpacksize);
        etwquantitycounted = (EditText)findViewById(R.id.wquantitycounted);
        etwbreakages_brand = (EditText)findViewById(R.id.wbreakages_brand);
        etwquantity_breakages = (EditText)findViewById(R.id.wquantity_breakages);
        etbrand = (EditText)findViewById(R.id.brand);
        etpacksize = (EditText)findViewById(R.id.packsize);
        etquantitycounted = (EditText)findViewById(R.id.quantitycounted);
        etbreakages_brand = (EditText)findViewById(R.id.breakages_brand);
        etquantity_breakages = (EditText)findViewById(R.id.quantity_breakages);
        etcbrand = (EditText)findViewById(R.id.cbrand);
        etcpacksize = (EditText)findViewById(R.id.cpacksize);
        etcquantitycounted = (EditText)findViewById(R.id.cquantitycounted);
        etsales = (EditText)findViewById(R.id.sales);
        etcswarehouse = (EditText)findViewById(R.id.cswarehouse);
        etshelfpercentages = (EditText)findViewById(R.id.shelfpercentages);
        etcompetitorprice = (EditText)findViewById(R.id.competitorprice);
        etownskuprice = (EditText)findViewById(R.id.ownskuprice);
        etcompetitorposm = (EditText)findViewById(R.id.competitorposm);
        etownposm = (EditText)findViewById(R.id.ownposm);
        etcompetitorspecials = (EditText)findViewById(R.id.competitorspecials);
        etsampling = (EditText)findViewById(R.id.sampling);
        etgiveaways = (EditText)findViewById(R.id.giveaways);
        ettillpoints = (EditText)findViewById(R.id.tillpoints);
        ettrolleys = (EditText)findViewById(R.id.trolleys);
        etbaskets = (EditText)findViewById(R.id.baskets);
        etfullname2 = (EditText)findViewById(R.id.fullname2);
        etphonenumber2 = (EditText)findViewById(R.id.phonenumber2);
        etemail = (EditText)findViewById(R.id.email);
        etfacebook = (EditText)findViewById(R.id.facebook);
        ettwitter = (EditText)findViewById(R.id.twitter);
        etrphonenumber2 = (EditText)findViewById(R.id.rphonenumber2);
        etreceiptnumber = (EditText)findViewById(R.id.receiptnumber);
        etaddress = (EditText)findViewById(R.id.address);

        //Spinners
        splocations = (Spinner)findViewById(R.id.locations);
        spoutlet = (Spinner)findViewById(R.id.outlet);
        spbranchmanagement = (Spinner)findViewById(R.id.branchmanagement);
        spestshoppers = (Spinner)findViewById(R.id.estshoppers);
        sppeakperiod = (Spinner)findViewById(R.id.peakperiod);
        spcarparksize = (Spinner)findViewById(R.id.carparksize);

        //ImageView
        ivshelfimage = (ImageView)findViewById(R.id.shelfimage);
        ivplanogrampic = (ImageView)findViewById(R.id.planogrampic);
        ivimagecounter = (ImageView)findViewById(R.id.imagecounter);


        //Initializing locations
        adapter1 = ArrayAdapter.createFromResource(this, R.array.geolocations, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        splocations.setAdapter(adapter1);

        //Initialing outlet spinner
        adapter2 = ArrayAdapter.createFromResource(this, R.array.outlet_name, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spoutlet.setAdapter(adapter2);

        //Initializing management spinner
        adapter3 = ArrayAdapter.createFromResource(this, R.array.management, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spbranchmanagement.setAdapter(adapter3);

        //Initializing management spinner
        adapter4 = ArrayAdapter.createFromResource(this, R.array.shoppers, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spestshoppers.setAdapter(adapter4);

        //Initializing management spinner
        adapter6 = ArrayAdapter.createFromResource(this, R.array.peaktimezone, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sppeakperiod.setAdapter(adapter6);

        //Initializing management spinner
        adapter7 = ArrayAdapter.createFromResource(this, R.array.carpark, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spcarparksize.setAdapter(adapter7);


        picbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnkyc = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnkyc,O);
            }
        });

        planogrambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnkyc = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnkyc,O);
            }
        });

        imgcounterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnkyc = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnkyc,O);
            }
        });

        retailbtn = (Button)findViewById(R.id.retailbtn);

        retailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retailq = new Intent(getApplicationContext(), Retailquestionnaire.class);
                startActivity(retailq);
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

    // -----------OnClick SaveRetail button------------//
    public void saveRetaildata(View view){
        Toast.makeText(getApplicationContext(), "Saving data...", Toast.LENGTH_LONG).show();

        String str_etprojectname = etprojectname.getText().toString();
        String str_etfullname = etfullname.getText().toString();
        String str_etphonenumber = etphonenumber.getText().toString();
        String str_etemailentry = etemailentry.getText().toString();
        String str_etclient = etclient.getText().toString();
        String str_etba = etba.getText().toString();
        String str_etwbrand = etwbrand.getText().toString();
        String str_etwpacksize = etwpacksize.getText().toString();
        String str_etwquantitycounted = etwquantitycounted.getText().toString();
        String str_etwbreakages_brand = etwbreakages_brand.getText().toString();
        String str_etwquantity_breakages = etwquantity_breakages.getText().toString();
        String str_etbrand = etbrand.getText().toString();
        String str_etpacksize = etpacksize.getText().toString();
        String str_etquantitycounted = etquantitycounted.getText().toString();
        String str_etbreakages_brand = etbreakages_brand.getText().toString();
        String str_etquantity_breakages = etquantity_breakages.getText().toString();
        String str_etcbrand = etcbrand.getText().toString();
        String str_etcpacksize = etcpacksize.getText().toString();
        String str_etcquantitycounted = etcquantitycounted.getText().toString();
        String str_etsales = etsales.getText().toString();
        String str_etcswarehouse = etcswarehouse.getText().toString();
        String str_etshelfpercentages = etshelfpercentages.getText().toString();
        String str_etcompetitorprice = etcompetitorprice.getText().toString();
        String str_etownskuprice = etownskuprice.getText().toString();
        String str_etcompetitorposm = etcompetitorposm.getText().toString();
        String str_etownposm = etownposm.getText().toString();
        String str_etcompetorspecials = etcompetitorspecials.getText().toString();
        String str_etsampling = etsampling.getText().toString();
        String str_etgiveaways = etgiveaways.getText().toString();
        String str_ettillpoints = ettillpoints.getText().toString();
        String str_ettrolleys = ettrolleys.getText().toString();
        String str_etbaskets = etbaskets.getText().toString();
        String str_etfullname2 = etfullname2.getText().toString();
        String str_etphonenumber2 = etphonenumber2.getText().toString();
        String str_etemail = etemail.getText().toString();
        String str_etfacebook = etfacebook.getText().toString();
        String str_ettwitter = ettwitter.getText().toString();
        String str_etreceiptnumber = etreceiptnumber.getText().toString();
        String str_etaddress = etaddress.getText().toString();


        String type = "retaildata";

        RetailBackend retailBackend = new RetailBackend(this);
        retailBackend.execute(type, str_etprojectname, str_etfullname, str_etphonenumber, str_etemailentry,
                str_etclient,str_etba,str_etwbrand,str_etwpacksize,str_etwquantitycounted,str_etwbreakages_brand,
                str_etwquantity_breakages,str_etbrand,str_etpacksize,str_etquantitycounted,str_etbreakages_brand,
                str_etquantity_breakages,str_etcbrand,str_etcpacksize,str_etcquantitycounted,str_etsales,str_etcswarehouse,
                str_etshelfpercentages,str_etcompetitorprice,str_etownskuprice,str_etcompetitorposm,str_etownposm,
                str_etcompetorspecials,str_etsampling,str_etgiveaways,str_ettillpoints,str_ettrolleys,str_etbaskets,
                str_etfullname2,str_etphonenumber2,str_etemail,str_etfacebook,str_ettwitter,str_etreceiptnumber,str_etaddress);
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
        getMenuInflater().inflate(R.menu.retail, menu);
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
