package com.example.prashantmaheshwari.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BmiCalc extends AppCompatActivity {

    EditText et1,et2,et3;
    double bmi,wt,ht,req,age;
    Button b1;
    private DatabaseReference database;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calc);
        et1=(EditText)findViewById(R.id.editText9);
        et2=(EditText)findViewById(R.id.editText15);
        et3=(EditText)findViewById(R.id.editText16);
        b1=(Button)findViewById(R.id.button10);


        user = FirebaseAuth.getInstance().getCurrentUser();
        String text = user.getUid();
        database = FirebaseDatabase.getInstance().getReference(text);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1!=null && et2!=null && et3!=null) {
                    wt = Double.parseDouble(et1.getText().toString());
                    ht = Double.parseDouble(et2.getText().toString());
                    age = Double.parseDouble(et3.getText().toString());
                    bmi = wt / (ht * ht);
                    req = 66.67 + (13.75 * wt) + (5 * ht) - 6.67 * age;
                    double l = (double) Math.round(bmi * 100) / 100;
                    double m = (double) Math.round(req * 100) / 100;
                    String pqp = String.valueOf(l);
                    String pwp = String.valueOf(m);
                    Intent i = new Intent(getBaseContext(), DietPlan.class);
                    i.putExtra("bmi", bmi + "");
                    i.putExtra("req", req + "");
                    database.child("BMI").setValue(pqp);
                    database.child("Calories").setValue(pwp);
                    startActivity(i);
                }else{
                    Toast.makeText(BmiCalc.this,"Plz Enter Data to get BMI",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

