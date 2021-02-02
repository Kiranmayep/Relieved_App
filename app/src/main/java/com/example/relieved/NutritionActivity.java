package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class NutritionActivity extends AppCompatActivity {

    SeekBar seekBar;
    ImageView btRew,btPlay,btPause,btFf;

    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        //Assign variable
        seekBar=findViewById(R.id.seek_bar);
        btRew=findViewById(R.id.bt_rew);
        btPlay=findViewById(R.id.bt_play);
        btPause=findViewById(R.id.bt_pause);
        btFf=findViewById(R.id.bt_ff);

        //Initialize media player
        mediaPlayer=MediaPlayer.create(this,R.raw.foodaudio);

        runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,500);
            }
        };

        //get duration
        int duration = mediaPlayer.getDuration();
        //convert milli second to mnute and second
        String sDuration = convertFormat(duration);
        //set duration on text view


        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide play button
                btPlay.setVisibility(View.GONE);
                //show pause button
                btPause.setVisibility(View.VISIBLE);
                //Start media player
                mediaPlayer.start();
                //set max seek bar
                seekBar.setMax(mediaPlayer.getDuration());
                //start handler
                handler.postDelayed(runnable,0);
            }
        });
        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btPause.setVisibility(View.GONE);
                //show pause button
                btPlay.setVisibility(View.VISIBLE);
                //Start media player
                mediaPlayer.pause();

                //stop handler
                handler.removeCallbacks(runnable);
            }
        });
        btFf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current position of media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                //get duration of media player
                int duration = mediaPlayer.getDuration();
                //check condition
                if (mediaPlayer.isPlaying() && duration != currentPosition){
                    //fastforward for 5 seconds
                    currentPosition = currentPosition+5000;
                    //set current position on text view

                    //set progress on seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });
        btRew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current position of media player
                int currentPosition =mediaPlayer.getCurrentPosition();
                //check condition
                if(mediaPlayer.isPlaying()&&currentPosition>5000){
                    //rewind for 5seconds
                    currentPosition=currentPosition-5000;
                    //get current postion on text view

                    //set progress on seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
                //set current position on textview


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //hide pause
                btPause.setVisibility(View.GONE);
                //show play button
                btPlay.setVisibility(View.VISIBLE);
                //set media player to initial position
                mediaPlayer.seekTo(0);
            }
        });


    }
    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                ,TimeUnit.MILLISECONDS.toSeconds(duration)
                ,TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}

