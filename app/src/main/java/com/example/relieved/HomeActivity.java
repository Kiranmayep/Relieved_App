package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView relax,relive,refresh,reveal,redefine,reflect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        relax=(CardView) findViewById(R.id.relax);
        relive=(CardView) findViewById(R.id.relive);
        reveal=(CardView) findViewById(R.id.reveal);
        reflect=(CardView) findViewById(R.id.reflect);
        refresh=(CardView) findViewById(R.id.refresh);
        redefine=(CardView) findViewById(R.id.redefine);

        relax.setOnClickListener(this);
        relive.setOnClickListener(this);
        reveal.setOnClickListener(this);
        reflect.setOnClickListener(this);
        refresh.setOnClickListener(this);
        redefine.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.relax:
                i=new Intent(this, RelaxActivity.class);
                startActivity(i);
                break;
            case R.id.relive:
                i= new Intent(this,NatureActivity.class);
                startActivity(i);
                break;
            case R.id.reveal:
                i=new Intent(this,RevealActivity.class);
                startActivity(i);
                break;
            case R.id.reflect:
                i= new Intent(this,ReflectActivity.class);
                startActivity(i);
                break;
            case R.id.refresh:
                i=new Intent(this,RefreshActivity.class);
                startActivity(i);
                break;
            case R.id.redefine:
                i= new Intent(this,RedefineActivity.class);
                startActivity(i);
                break;
        }
    }
}