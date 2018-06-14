package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Spinner;
import android.widget.Toast;

public class Questionaire extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Spinner networks, questionnaire;
    ArrayAdapter<CharSequence> adapeter1, adapter2;

    Button load, saveq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        networks = (Spinner)findViewById(R.id.networks);
        questionnaire = (Spinner)findViewById(R.id.questionaire);
        load = (Button)findViewById(R.id.load);
        saveq = (Button)findViewById(R.id.saveq);

        //Initializing networks spinner
        adapeter1 = ArrayAdapter.createFromResource(this, R.array.networks_question, android.R.layout.simple_spinner_item);
        adapeter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        networks.setAdapter(adapeter1);

        //Loading questionnaires
        adapter2 = ArrayAdapter.createFromResource(this, R.array.load_question, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        questionnaire.setAdapter(adapter2);

        //loading
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Loading Questionnaire Survey...", Toast.LENGTH_LONG).show();
            }
        });

        //saving
        saveq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Saving data...", Toast.LENGTH_LONG).show();
            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "GPS continuous sampling ...", Snackbar.LENGTH_LONG)
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
        getMenuInflater().inflate(R.menu.questionaire, menu);
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
            // navigation to home
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
