package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReflectActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView moodify,moodtrack,daynote,therapists,maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);

        moodify=(CardView) findViewById(R.id.moodify);
        moodtrack=(CardView) findViewById(R.id.moodtrack);
        therapists=(CardView) findViewById(R.id.therapists);
        maps=(CardView) findViewById(R.id.maps);


        moodtrack.setOnClickListener(this);
        therapists.setOnClickListener(this);
        moodify.setOnClickListener(this);
        maps.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.moodify:
                i=new Intent(this, MoodActivity.class);
                startActivity(i);
                break;
            case R.id.moodtrack:
                i= new Intent(this,MoodTrackActivity.class);
                startActivity(i);
                break;
            case R.id.therapists:
                i= new Intent(this,TherapistsActivity.class);
                startActivity(i);
                break;
            case R.id.maps:
                i= new Intent(this,MapsActivity.class);
                startActivity(i);
                break;
        }
    }
}