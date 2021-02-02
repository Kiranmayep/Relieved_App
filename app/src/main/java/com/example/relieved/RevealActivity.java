package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RevealActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView shinebot,helpline;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);

        shinebot=(CardView) findViewById(R.id.shinebot);
        helpline=(CardView) findViewById(R.id.helpline);
        txt=findViewById(R.id.txt);



        shinebot.setOnClickListener(this);
        helpline.setOnClickListener(this);
        txt.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.shinebot:
                i=new Intent(this, ShineBotActivity.class);
                startActivity(i);
                break;
            case R.id.helpline:
                i= new Intent(this,HelpLineActivity.class);
                startActivity(i);
                break;
            case R.id.txt:
                i= new Intent(this,SmsButtonActivity.class);
                startActivity(i);
                break;


        }
    }



}