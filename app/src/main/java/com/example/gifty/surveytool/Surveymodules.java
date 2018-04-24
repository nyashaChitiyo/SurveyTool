package com.example.gifty.surveytool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Surveymodules extends AppCompatActivity {

    Button kycbtn, merchbtn, instorebtn, trademarketinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveymodules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        kycbtn = (Button)findViewById(R.id.kycbtn);
        kycbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MobileGo.class);
                startActivity(intent);
            }
        });

        merchbtn = (Button)findViewById(R.id.merchbtn);
        merchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent merch = new Intent(getApplicationContext(), Merchandising.class);
                startActivity(merch);
            }
        });

        //initiating retail activity
        instorebtn = (Button)findViewById(R.id.instorebtn);
        instorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instore = new Intent(getApplicationContext(), Retail.class);
                startActivity(instore);
            }
        });

        //Declare the sales + distribution
        trademarketinbtn = (Button)findViewById(R.id.trademarketingbtn);
        trademarketinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sales = new Intent(getApplicationContext(), Sales.class);
                startActivity(sales);
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Initializing Geo-Locating ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
