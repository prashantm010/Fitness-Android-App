package com.example.prashantmaheshwari.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Extras extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
        t=(TextView)findViewById(R.id.textView8);
        String s=getIntent().getStringExtra("burnt");
        t.setText("Burnt Calories = "+s);
    }
}
