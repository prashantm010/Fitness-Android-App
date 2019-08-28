package com.example.prashantmaheshwari.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Caloriec extends AppCompatActivity {

    EditText et6,et7,et8,et10,et11,et12,et13,et14;
    Button b;
    String totalc="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriec);
        et6=(EditText)findViewById(R.id.editText6);
        et7=(EditText)findViewById(R.id.editText7);
        et8=(EditText)findViewById(R.id.editText8);
        et10=(EditText)findViewById(R.id.editText10);
        et11=(EditText)findViewById(R.id.editText11);
        et12=(EditText)findViewById(R.id.editText12);
        et13=(EditText)findViewById(R.id.editText13);
        b=(Button)findViewById(R.id.button9);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cal1=80*Integer.parseInt(et6.getText().toString());
                int cal2=60*Integer.parseInt(et7.getText().toString());
                int cal3=120*Integer.parseInt(et8.getText().toString());
                int cal4=150*Integer.parseInt(et10.getText().toString());
                int cal5=100*Integer.parseInt(et11.getText().toString());
                int cal6=150*Integer.parseInt(et12.getText().toString());
                int cal7=80*Integer.parseInt(et13.getText().toString());
                int cal=cal1+cal2+cal3+cal4+cal5+cal6+cal7;
                totalc=cal+"";
                Intent i=new Intent(getBaseContext(),CalorieCalculator.class);
                i.putExtra("takenc",totalc);
                startActivity(i);
                Toast.makeText(getBaseContext(),totalc+" CALORIES TODAY",Toast.LENGTH_LONG).show();
            }
        });

    }
}
