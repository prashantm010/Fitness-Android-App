package com.example.prashantmaheshwari.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DietPlan extends AppCompatActivity {

    TextView tv1,tv2;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);
        setTitle("Diet Plan");
        tv1=(TextView)findViewById(R.id.textView14);
        tv2=(TextView)findViewById(R.id.textView15);
        lv=(ListView)findViewById(R.id.listview);
        String s=getIntent().getStringExtra("bmi");
        String s1=getIntent().getStringExtra("req");
        tv1.setText("Your BMI = "+s);
        tv2.setText("Required Calories/day = "+s1);
        ArrayList<String> a=new ArrayList<>();
        double bmi=Double.parseDouble(s);
        if(bmi<18.5)
        {
            a.add("Full cream milk : 750 - 1000ml");
            a.add("Meat, fish, eggs : 3-5 servings");
            a.add("Bread and cereals: 8-12 servings ");
            a.add("Fruit and vegetables: 3-5 servings");
            a.add("Fats and oils: 90 g");
            a.add("Healthy desserts: 1-2 servings");
        }
        else if(bmi>=18.5 && bmi<25)
        {
            a.add("One smoothie : 400 calories");
            a.add("Phulkas – 2");
            a.add("½ cup cooked sabji");
            a.add("Dal – ½ cup moong, toor");
            a.add("Low-fat paneer – 50 grams");
            a.add("Moong sprouts - 1 serving");
        }
        else if(bmi>=25 && bmi<30)
        {
            a.add("2 large egg whites");
            a.add("Phulkas – 2");
            a.add("113 grams grilled chicken breast");
            a.add("170 grams non fat fruit yogurt ");
            a.add("1 cup cooked penne pasta ");
            a.add("1 medium banana");
        }
        else
        {
            a.add("multigrain toast with low-fat cheese and black coffee");
            a.add("a handful of almonds or walnuts");
            a.add("2 rotis (without oil or ghee), 1 plate rice");
            a.add("1 cup moong bean sprouts");
            a.add("1 roti(without oil or ghee), ½ cup vegetable curry");
            a.add("Lime juice");
        }
        ArrayAdapter adapter=new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,a);
        lv.setAdapter(adapter);
    }
}
