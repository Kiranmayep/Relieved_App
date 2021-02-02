package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class BirdGame1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_birdgame);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BirdGame1.this, BirdGame2.class));
            }
        });
    }
        
        @Override
public void onBackPressed() {
   Intent intent = new Intent(Intent.ACTION_MAIN);
   intent.addCategory(Intent.CATEGORY_HOME);
   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
   startActivity(intent);
 }
    }
    



