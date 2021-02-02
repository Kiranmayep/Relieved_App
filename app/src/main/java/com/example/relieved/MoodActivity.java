package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MoodActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private int newProgressValue1, currentProgress1;
    private int newProgressValue2, currentProgress2;
    private int newProgressValue3, currentProgress3;
    private int newProgressValue4, currentProgress4;
    private int newProgressValue5, currentProgress5;
    private SharedPreferences preferences1, preferences2, preferences3, preferences4, preferences5;
    private String Key_PROGRESS1 = "Key_progress1";
    private String key1 = "key_value1";
    private String PREFERENCE_PROGRESS1 = "preference_progress1";
    private String Key_PROGRESS2 = "Key_progress2";
    private String key2 = "key_value2";
    private String PREFERENCE_PROGRESS2 = "preference_progress2";
    private String Key_PROGRESS3 = "Key_progress3";
    private String key3 = "key_value3";
    private String PREFERENCE_PROGRESS3 = "preference_progress3";
    private String Key_PROGRESS4 = "Key_progress4";
    private String key4 = "key_value4";
    private String PREFERENCE_PROGRESS4 = "preference_progress4";
    private String Key_PROGRESS5 = "Key_progress5";
    private String key5 = "key_value5";
    private String PREFERENCE_PROGRESS5 = "preference_progress5";
    private int seekBarProgress1,seekBarProgress2,seekBarProgress3,seekBarProgress4,seekBarProgress5;


    TextView rate1, rate2, rate3, rate4, rate5,textview1,textview2;

    ImageView bad, angry, toohappy, happy, neutral;
    SeekBar seekBar1, seekBar2, seekBar3, seekBar4, seekBar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        preferences1 = getSharedPreferences(PREFERENCE_PROGRESS1, MODE_PRIVATE);
        currentProgress1 = preferences1.getInt(Key_PROGRESS1, 0);

        preferences2 = getSharedPreferences(PREFERENCE_PROGRESS1, MODE_PRIVATE);
        currentProgress2 = preferences2.getInt(Key_PROGRESS2, 0);

        preferences3 = getSharedPreferences(PREFERENCE_PROGRESS3, MODE_PRIVATE);
        currentProgress3 = preferences3.getInt(Key_PROGRESS3, 0);

        preferences4 = getSharedPreferences(PREFERENCE_PROGRESS4, MODE_PRIVATE);
        currentProgress4 = preferences4.getInt(Key_PROGRESS4, 0);

        preferences5 = getSharedPreferences(PREFERENCE_PROGRESS5, MODE_PRIVATE);
        currentProgress5 = preferences5.getInt(Key_PROGRESS5, 0);

        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
        seekBar4 = findViewById(R.id.seekBar4);
        seekBar5 = findViewById(R.id.seekBar5);
        bad = findViewById(R.id.bad);
        angry = findViewById(R.id.angry);
        toohappy = findViewById(R.id.toohappy);
        happy = findViewById(R.id.happy);
        neutral = findViewById(R.id.neutral);
        rate1 = findViewById(R.id.rate1);
        rate2 = findViewById(R.id.rate2);
        rate3 = findViewById(R.id.rate3);
        rate4 = findViewById(R.id.rate4);
        rate5 = findViewById(R.id.rate5);
        textview1=findViewById(R.id.textview1);
        textview2=findViewById(R.id.textview2);


        seekBar1.setProgress(currentProgress1);
        seekBar2.setProgress(currentProgress2);
        seekBar3.setProgress(currentProgress3);
        seekBar4.setProgress(currentProgress4);
        seekBar5.setProgress(currentProgress5);

        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar4.setOnSeekBarChangeListener(this);
        seekBar5.setOnSeekBarChangeListener(this);
        loadData();
        updateViews();

        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar1.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
                seekBar4.setProgress(0);
                seekBar5.setProgress(0);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId()==R.id.seekBar1){
            rate1.setText("Sad moods:" + progress + "%");
            saveData();
        }else if(seekBar.getId()==R.id.seekBar2){
            rate2.setText("Annoyed moods:" + progress + "%");
            saveData();
        }else if(seekBar.getId()==R.id.seekBar3){
            rate3.setText("Neutral moods:" + progress + "%");
            saveData();
        }else if(seekBar.getId()==R.id.seekBar4){
            rate4.setText("Happy moods:" + progress + "%");
            saveData();
        }else if(seekBar.getId()==R.id.seekBar5){
            rate5.setText("Joyous moods:" + progress + "%");
            saveData();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekBar1) {
            newProgressValue1 = seekBar.getProgress();
            currentProgress1 = newProgressValue1;
            SharedPreferences.Editor editor = preferences1.edit();
            editor.putInt(Key_PROGRESS1, newProgressValue1);
            editor.apply();
        }else if(seekBar.getId() == R.id.seekBar2){
            newProgressValue2 = seekBar.getProgress();
            currentProgress2 = newProgressValue2;
            SharedPreferences.Editor editor = preferences2.edit();
            editor.putInt(Key_PROGRESS2, newProgressValue2);
            editor.apply();
        }else if(seekBar.getId() == R.id.seekBar3) {
            newProgressValue3 = seekBar.getProgress();
            currentProgress3 = newProgressValue3;
            SharedPreferences.Editor editor = preferences3.edit();
            editor.putInt(Key_PROGRESS3, newProgressValue3);
            editor.apply();
        }else if(seekBar.getId() == R.id.seekBar4) {
            newProgressValue4 = seekBar.getProgress();
            currentProgress4 = newProgressValue4;
            SharedPreferences.Editor editor = preferences4.edit();
            editor.putInt(Key_PROGRESS4, newProgressValue4);
            editor.apply();
        }else if(seekBar.getId() == R.id.seekBar5){
            newProgressValue5 = seekBar.getProgress();
            currentProgress5 = newProgressValue5;
            SharedPreferences.Editor editor = preferences5.edit();
            editor.putInt(Key_PROGRESS5, newProgressValue5);
            editor.apply();
        }

    }public void saveData() {
        SharedPreferences sharedPreferences1 = getSharedPreferences("my_preference1", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putInt("my_seekBar1", seekBar1.getProgress());
        editor1.apply();

        SharedPreferences sharedPreferences2 = getSharedPreferences("my_preference2", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        editor2.putInt("my_seekBar2", seekBar2.getProgress());
        editor2.apply();

        SharedPreferences sharedPreferences3 = getSharedPreferences("my_preference3", MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
        editor3.putInt("my_seekBar3", seekBar3.getProgress());
        editor3.apply();

        SharedPreferences sharedPreferences4 = getSharedPreferences("my_preference4", MODE_PRIVATE);
        SharedPreferences.Editor editor4 = sharedPreferences4.edit();
        editor4.putInt("my_seekBar4", seekBar4.getProgress());
        editor4.apply();

        SharedPreferences sharedPreferences5 = getSharedPreferences("my_preference5", MODE_PRIVATE);
        SharedPreferences.Editor editor5 = sharedPreferences5.edit();
        editor5.putInt("my_seekBar5", seekBar5.getProgress());
        editor5.apply();
    }
    public void loadData() {
        SharedPreferences sharedPreferences1 = getSharedPreferences("my_preference1", MODE_PRIVATE);
        seekBarProgress1 = sharedPreferences1.getInt("my_seekBar1",0);

        SharedPreferences sharedPreferences2 = getSharedPreferences("my_preference2", MODE_PRIVATE);
        seekBarProgress2 = sharedPreferences2.getInt("my_seekBar2",0);

        SharedPreferences sharedPreferences3 = getSharedPreferences("my_preference3", MODE_PRIVATE);
        seekBarProgress3 = sharedPreferences3.getInt("my_seekBar3",0);

        SharedPreferences sharedPreferences4 = getSharedPreferences("my_preference4", MODE_PRIVATE);
        seekBarProgress4 = sharedPreferences4.getInt("my_seekBar4",0);

        SharedPreferences sharedPreferences5 = getSharedPreferences("my_preference5", MODE_PRIVATE);
        seekBarProgress5 = sharedPreferences5.getInt("my_seekBar5",0);
    }
    @SuppressLint("SetTextI18n")
    public void updateViews() {
        seekBar1.setProgress(seekBarProgress1);
        rate1.setText("Sad Moods:"+seekBarProgress1+"%");
        seekBar2.setProgress(seekBarProgress2);
        rate2.setText("Annoyed Moods:"+seekBarProgress2+"%");
        seekBar3.setProgress(seekBarProgress3);
        rate3.setText("Neutral Moods:"+seekBarProgress3+"%");
        seekBar4.setProgress(seekBarProgress4);
        rate4.setText("Happy Moods:"+seekBarProgress4+"%");
        seekBar5.setProgress(seekBarProgress5);
        rate5.setText("Joyous Moods:"+seekBarProgress5+"%");
    }
}


