package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class BirdSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent intent = new Intent(BirdSplashActivity.this, BirdGame1.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}