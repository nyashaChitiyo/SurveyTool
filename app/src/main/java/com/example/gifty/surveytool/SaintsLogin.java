package com.example.gifty.surveytool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class SaintsLogin extends AppCompatActivity {

    EditText email, password;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saints_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        email = (EditText)findViewById(R.id.etemail);
        password = (EditText)findViewById(R.id.etpassword);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void loginuser (View view){


        /*FirebaseDatabase databse = FirebaseDatabase.getInstance();
        DatabaseReference myRef = databse.getReference("message");
        myRef.setValue("Hello, World");*/

        Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();

        String str_email = email.getText().toString();
        String str_password = password.getText().toString();

        String type = "login";

        SaintsLoiginBackend saintsLoiginBackend = new SaintsLoiginBackend(this);
        saintsLoiginBackend.execute(type, str_email, str_password);

        if (!(str_email.isEmpty() && str_password.isEmpty())) {
            Intent module = new Intent(getApplicationContext(), Surveymodules.class);
            startActivity(module);
        }

        if (!(str_email.isEmpty() && str_password.isEmpty())){
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent module = new Intent(getApplicationContext(), Surveymodules.class);
                    startActivity(module);
                }
            }, 5000);
        }


    }

}
