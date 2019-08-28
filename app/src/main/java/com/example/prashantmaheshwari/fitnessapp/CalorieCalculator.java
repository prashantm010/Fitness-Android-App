package com.example.prashantmaheshwari.fitnessapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalorieCalculator extends AppCompatActivity {

    private TextView tv1 ,tv2 ,tv3, tv4;
    private ImageButton im1, im2, im3, im4;
    private DatabaseReference database;
    FirebaseUser user;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);

        tv1 = (TextView)findViewById(R.id.textView8);
        tv2 = (TextView)findViewById(R.id.textView10);
        tv3 = (TextView)findViewById(R.id.textView12);
        tv4 = (TextView)findViewById(R.id.textView6);

        im1 = (ImageButton) findViewById(R.id.id2);
        im2 = (ImageButton) findViewById(R.id.id3);
        im3 = (ImageButton) findViewById(R.id.id4);
        im4 = (ImageButton) findViewById(R.id.id1);

        user = FirebaseAuth.getInstance().getCurrentUser();

        String text = user.getUid();
        database = FirebaseDatabase.getInstance().getReference(text);

        String s1 = getIntent().getStringExtra("takenb");
        tv1.setText(s1+"Cal.");
        String s2 =getIntent().getStringExtra("takenl");
        tv2.setText(s2+"Cal.");
        String s3 = getIntent().getStringExtra("takenc");
        tv3.setText(s3+"Cal.");
        String s4 = getIntent().getStringExtra("taken");
        tv4.setText(s4+"Cal.");

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalorieCalculator.this,Calorieb.class));
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalorieCalculator.this,Caloriel.class));
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalorieCalculator.this,Caloriec.class));
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalorieCalculator.this,Calorie.class));
            }
        });
    }
}
