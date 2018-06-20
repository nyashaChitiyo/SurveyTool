package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.N;
import static android.os.Build.VERSION_CODES.O;

public class Onshelf extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button picbtn, planogrambtn, onshelfbtn;
    ImageView shelfimage, planogrampic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onshelf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        picbtn = (Button)findViewById(R.id.picbtn);
        planogrambtn = (Button)findViewById(R.id.planogrambtn);
        shelfimage = (ImageView)findViewById(R.id.shelfimage);
        planogrampic = (ImageView)findViewById(R.id.planogrampic);

        onshelfbtn = (Button)findViewById(R.id.onshelfbtn);

        onshelfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Saving data...", Toast.LENGTH_LONG).show();
            }
        });

        picbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnpic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnpic,O);
            }
        });

        planogrambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnplanogram = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(btnplanogram,N);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        shelfimage.setImageBitmap(bitmap);

        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap1 = (Bitmap)data.getExtras().get("data");
        planogrampic.setImageBitmap(bitmap1);
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
