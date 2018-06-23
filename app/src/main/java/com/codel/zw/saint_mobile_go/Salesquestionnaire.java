package com.codel.zw.saint_mobile_go;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.codel.zw.saint_mobile_go.pojo.RetailQuestionairePojo;
import com.codel.zw.saint_mobile_go.pojo.SalesQuestionairePojo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Salesquestionnaire extends AppCompatActivity {

    private String qxn,product,firebase_name,qxn2;
    private FirebaseUser user;
    private EditText favPrdct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salesquestionnaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        user = FirebaseAuth.getInstance().getCurrentUser();
        favPrdct = findViewById(R.id.favprdct);
    }

    public void save(View view){
        product = favPrdct.getText().toString();
        if (firebase_name != null) {
            // Name, email address, and profile photo Url
            firebase_name = user.getDisplayName();
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
                                SalesQuestionairePojo pojo = new SalesQuestionairePojo(qxn,product,qxn2);

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference ref = database.getReference("Brand Ambassador");

                                ref.child(firebase_username[0]).child("Sales and Distribution").child(Sales.projectName).child("Questionaire").setValue(pojo);
                            }
                        }
                    });
        }
    }
    public void onRadioBtnClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q1yes:
                if (checked)
                    qxn = "Yes";
                break;
            case R.id.q1no:
                if (checked)
                    qxn = "NO";
                break;
        }
    }
    public void haveUsed(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q2yes:
                if (checked)
                    qxn2 = "Yes";
                break;
            case R.id.q2no:
                if (checked)
                    qxn2 = "NO";
                break;
        }
    }
}
