package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Reports extends AppCompatActivity {

    Button stocks, onshelf, order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        stocks = (Button)findViewById(R.id.stocks);
        stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stocksactivity = new Intent(getApplicationContext(), Stocks.class);
                startActivity(stocksactivity);
            }
        });

        onshelf = (Button)findViewById(R.id.onshelf);
        onshelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onshelfactivity = new Intent(getApplicationContext(), Onshelf.class);
                startActivity(onshelfactivity);
            }
        });

        order = (Button)findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderactivity = new Intent(getApplicationContext(), Orderplacement.class);
                startActivity(orderactivity);
            }
        });

    }

}
