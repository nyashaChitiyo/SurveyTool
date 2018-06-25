package com.codel.zw.saint_mobile_go;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.codel.zw.saint_mobile_go.pojo.KycQuestionairePojo;
import com.codel.zw.saint_mobile_go.pojo.KycRegistrationPojo;
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

public class Questionaire extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Iterator iteratorAns,iteratorQue;
    private FirebaseUser user;
    EditText q1,q2,q3;
    List<String> ans = new ArrayList<String>();
    List<String> que = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        user = FirebaseAuth.getInstance().getCurrentUser();
        setSupportActionBar(toolbar);

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);

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
        getMenuInflater().inflate(R.menu.questionaire, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Intent helpintent = new Intent(getApplicationContext(), Help.class);
            startActivity(helpintent);
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
            // navigation to home
            Intent myhomeintent = new Intent(getApplicationContext(), Surveymodules.class);
            startActivity(myhomeintent);
        } else if (id == R.id.options) {
            Intent optionsintent = new Intent(getApplicationContext(), Options.class);
            startActivity(optionsintent);

        } else if (id == R.id.settings) {
            Intent settingsintent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(settingsintent);
        } else if (id == R.id.account) {
            Intent accountintent = new Intent(getApplicationContext(), account.class);
            startActivity(accountintent);
        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
                                    KycQuestionairePojo pojo = new KycQuestionairePojo(iteratorAns.next().toString());

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference ref = database.getReference("Brand Ambassador");


                                    ref.child(user.getDisplayName()).child("Know Your Customer").child(KycRegistration.qname).child("Questionaire").child(iteratorQue.next().toString()).setValue(pojo);
                 Toast.makeText(getApplicationContext(), "Saving data...", Toast.LENGTH_LONG).show();
                                }
            }
}
