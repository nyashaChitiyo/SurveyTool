package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;

public class SaintsLogin extends AppCompatActivity {

    EditText email, password;
    private FirebaseAuth mAuth;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saints_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
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
        myRef.setValue("Hello, World");
*/
        Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();

        String str_email = email.getText().toString();
        String str_password = password.getText().toString();


        mAuth.signInWithEmailAndPassword(str_email, str_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SaintsLogin.this, "Attempting to login",
                                Toast.LENGTH_SHORT).show();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(SaintsLogin.this, "Login Successful",
                                    Toast.LENGTH_SHORT).show();
                            Intent module = new Intent(getApplicationContext(), Surveymodules.class);
                            module.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(module);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SaintsLogin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
        /*String type = "login";

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
        }*/


    }

}
