package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MobileGo extends AppCompatActivity {

    Button kycbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_go);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        kycbtn = (Button)findViewById(R.id.kycbtn);

        kycbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kyc = new Intent(getApplicationContext(), KycRegistration.class);
                startActivity(kyc);
            }
        });

    }

}
