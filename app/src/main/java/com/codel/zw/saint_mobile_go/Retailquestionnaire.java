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
import com.codel.zw.saint_mobile_go.pojo.SalesOrderTakingPojo;
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

public class Retailquestionnaire extends AppCompatActivity {
    private FirebaseUser user;
    Iterator iteratorAns,iteratorQue;
    EditText q1,q2,q3;
    List<String> ans = new ArrayList<String>();
    List<String> que = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailquestionnaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        user = FirebaseAuth.getInstance().getCurrentUser();
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
}
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
    public void save(View view){
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
            RetailQuestionairePojo pojo = new RetailQuestionairePojo(iteratorAns.next().toString());
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Brand Ambassador");

            ref.child(user.getDisplayName()).child(Retail.month1).child(Retail.day_date).child("Retail").child(""+Retail.date1).child(Retail.stfullname).child("Questionaire").child(iteratorQue.next().toString()).setValue(pojo);
            Toast.makeText(getApplicationContext(), "Saving data...", Toast.LENGTH_LONG).show();
        }
    }
}
