package com.codel.zw.saint_mobile_go;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codel.zw.saint_mobile_go.pojo.OrderPlacementPojo;

public class Orderplacement extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button orderbtn, scanbtn;
    private EditText orderNumber,dateOrder,PackSize,quantity;
    private String txtorderNumber,txtdateOrder,txtPackSize,txtquantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderplacement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        orderNumber = findViewById(R.id.ordernumber);
        dateOrder = findViewById(R.id.orderdate);
        PackSize = findViewById(R.id.wpacksize);
        quantity = findViewById(R.id.wquantitycounted);

        orderbtn = (Button)findViewById(R.id.orderbtn);
        scanbtn = (Button)findViewById(R.id.scanbtn);

        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdateOrder = dateOrder.getText().toString();
                txtorderNumber = orderNumber.getText().toString();
                txtPackSize = PackSize.getText().toString();
                txtquantity = quantity.getText().toString();
                OrderPlacementPojo pojo = new OrderPlacementPojo(txtorderNumber,txtdateOrder,txtPackSize,txtquantity);
                Toast.makeText(getApplicationContext(), "Processing Order ... "+txtdateOrder, Toast.LENGTH_LONG).show();
            }
        });

        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Scan unreachable", Toast.LENGTH_LONG).show();
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
        getMenuInflater().inflate(R.menu.orderplacement, menu);
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
