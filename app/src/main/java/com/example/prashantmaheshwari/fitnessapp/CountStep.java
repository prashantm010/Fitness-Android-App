package com.example.prashantmaheshwari.fitnessapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CountStep extends AppCompatActivity implements SensorEventListener {
    SensorManager manager;
    Sensor stepCount;
    TextView tv;
    ListView lv;
    Button b;
    private DatabaseReference database;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_step);
        manager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        stepCount=manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        tv= (TextView) findViewById(R.id.textView9);
        setTitle("Step Counter");
        tv.setText("");

        user = FirebaseAuth.getInstance().getCurrentUser();
        String text = user.getUid();
        database = FirebaseDatabase.getInstance().getReference(text);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float steps[] = event.values;
        int myStep = (int) steps[0];
        Sensor mySensor = event.sensor;
        int mySensorType = mySensor.getType();
        if (mySensorType == Sensor.TYPE_STEP_COUNTER) {
            tv.setText("Steps = " + myStep);
            database.child("Steps").setValue(myStep);
        } else {
            tv.setText("No step sensor");
            database.child("Steps").setValue(myStep);
        }
        if (myStep >= 0) {
            tv.setText("Steps = " + myStep);
            database.child("Steps").setValue(myStep);
        } else {
            tv.setText("No step sensor");
            database.child("Steps").setValue(myStep);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onResume() {
        manager.registerListener(this,stepCount, SensorManager.SENSOR_DELAY_FASTEST);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this,stepCount);
    }
}
