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

import com.codel.zw.saint_mobile_go.pojo.KycQuestionairePojo;
import com.codel.zw.saint_mobile_go.pojo.RetailQuestionairePojo;
import com.codel.zw.saint_mobile_go.pojo.SalesQuestionairePojo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Salesquestionnaire extends AppCompatActivity {

    Iterator iteratorAns,iteratorQue;
    private FirebaseUser user;
    EditText q1,q2,q3;
    List<String> ans = new ArrayList<String>();
    List<String> que = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salesquestionnaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        user = FirebaseAuth.getInstance().getCurrentUser();
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
    }

    public void save(View view)
    {
        final String txtQ1 = q1.getText().toString();
        final String txtQ2 = q2.getText().toString();
        final String txtQ3 = q3.getText().toString();

        que.add(txtQ1);
        que.add(txtQ2);
        que.add(txtQ3);

        iteratorAns = ans.iterator();
        iteratorQue = que.iterator();

        while(iteratorAns.hasNext()&& iteratorQue.hasNext())
        {
            SalesQuestionairePojo pojo = new SalesQuestionairePojo(iteratorAns.next().toString());

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Brand Ambassador");


            ref.child(user.getDisplayName()).child(Sales.month1).child(Sales.day_date).child("Sales and Distribution").child(""+Sales.date1).child(Sales.projectName).child("Questionaire").child(iteratorQue.next().toString()).setValue(pojo);
            Toast.makeText(getApplicationContext(), "Saving data...", Toast.LENGTH_LONG).show();
        }
    }

    /*{
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
    }*/

    public void onRadioBtnClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q1yes:
                if (checked)
                    ans.add("YES");
                break;
            case R.id.q1no:
                if (checked)
                    ans.add("NO");
                break;
            case R.id.q2yes:
                if (checked)
                    ans.add("YES");
                break;
            case R.id.q2no:
                if (checked)
                    ans.add("NO");
                break;
            case R.id.q3yes:
                if (checked)
                    ans.add("YES");
                break;
            case R.id.q3no:
                if (checked)
                    ans.add("NO");
                break;

        }
    }
}
