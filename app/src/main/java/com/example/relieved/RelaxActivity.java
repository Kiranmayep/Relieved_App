package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RelaxActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView meditation,nutrition,yoga,sleep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax);

        meditation=(CardView) findViewById(R.id.meditation);
        yoga=(CardView) findViewById(R.id.yoga);
        nutrition=(CardView) findViewById(R.id.nutrition);
        sleep=(CardView) findViewById(R.id.sleep);


        meditation.setOnClickListener(this);
        yoga.setOnClickListener(this);
        nutrition.setOnClickListener(this);
        sleep.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.meditation:
                i=new Intent(this, MeditationActivity.class);
                startActivity(i);
                break;
            case R.id.yoga:
                i= new Intent(this,YogaActivity.class);
                startActivity(i);
                break;
            case R.id.nutrition:
                i=new Intent(this,NutritionActivity.class);
                startActivity(i);
                break;
            case R.id.sleep:
                i= new Intent(this,SleepActivity.class);
                startActivity(i);
                break;
        }
    }
}