package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RedefineActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView challenge1,challenge2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefine);


        challenge1=(CardView) findViewById(R.id.challenge1);
        challenge2=(CardView) findViewById(R.id.challenge2);


        challenge1.setOnClickListener(this);
        challenge2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()) {
            case R.id.challenge1:
                i = new Intent(this, StepCountActivity.class);
                startActivity(i);
                break;
            case R.id.challenge2:
                i = new Intent(this,YogaChallengeActivity.class);
                startActivity(i);
                break;
        }
    }
}