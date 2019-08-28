package com.example.prashantmaheshwari.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Home extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    DatabaseReference rootRef;
    private TextView tv1,tv2,tv3,tv4;
    private ProgressBar progressBar;

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                String a = String.valueOf(map.get("Steps"));
                String b = String.valueOf(map.get("Calories"));
                String c = String.valueOf(map.get("BMI"));
                String d = String.valueOf(map.get("CalorieBurnt"));
                progressBar.setVisibility(View.INVISIBLE);
                tv1.setText(a);
                tv2.setText(b+" Cal.");
                tv3.setText(c);
                tv4.setText(d+" Cal.");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressBar.setVisibility(View.INVISIBLE);

            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(Home.this,Dashboard.class));
                    return true;
                case R.id.navigation_music:
                    startActivity(new Intent(Home.this,Music.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.data, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv1 = (TextView)findViewById(R.id.textView17);
        tv2 = (TextView)findViewById(R.id.textView19);
        tv3 = (TextView)findViewById(R.id.textView21);
        tv4 = (TextView)findViewById(R.id.textView23);
        progressBar = (ProgressBar)findViewById(R.id.progressBar2);
        user = FirebaseAuth.getInstance().getCurrentUser();

        rootRef = FirebaseDatabase.getInstance().getReference(user.getUid());

        mAuth = FirebaseAuth.getInstance();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
               mAuth.signOut();
               startActivity(new Intent(Home.this,Login1.class));
               finish();
                break;
            default:
                break;
        }

        return true;
    }

}
