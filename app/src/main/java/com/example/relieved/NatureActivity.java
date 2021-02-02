package com.example.relieved;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class NatureActivity extends AppCompatActivity {
    ImageView play, prev, next, imageView;
    TextView songTitle;
    //private final int COUNT = 5;
    //private int Index = 1;
    private VideoView myVideo1;
    SeekBar mSeekBarTime, mSeekBarVol;
    static MediaPlayer mMediaPlayer;
    private Runnable runnable;
    private AudioManager mAudioManager;
    int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // initializing views

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        songTitle = findViewById(R.id.songTitle);
        myVideo1 = (VideoView) findViewById(R.id.myVideo1);
        mSeekBarTime = findViewById(R.id.seekBarTime);
        mSeekBarVol = findViewById(R.id.seekBarVol);

        /*myVideo1.requestFocus();
        myVideo1.setVideoURI(getPath(Index));
        Index++;*/

        myVideo1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        /*myVideo1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //videos count +1 since we started with 1
                if (currentIndex == COUNT + 1) currentIndex = 1;
                myVideo1.setVideoURI(getPath(Index));
                Index++;
            }
        });*/


        // creating an ArrayList to store our songs

        final ArrayList<Integer> songs = new ArrayList<>();

        songs.add(0, R.raw.birds_in_the_forest);
        songs.add(1, R.raw.songbirds);
        songs.add(2, R.raw.waterfallsaudio);
        songs.add(3, R.raw.mountain);
        songs.add(4, R.raw.riverflow);
        songs.add(5, R.raw.waves_audio);


        // intializing mediaplayer

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));


        // seekbar volume

        int maxV = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSeekBarVol.setMax(maxV);
        mSeekBarVol.setProgress(curV);

        mSeekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //above seekbar volume
        //

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.play);
                } else {
                    mMediaPlayer.start();
                    play.setImageResource(R.drawable.pause);
                }

                songNames();

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.pause);
                }

                if (currentIndex < songs.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

                mMediaPlayer.start();
                songNames();

            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.pause);
                }

                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = songs.size() - 1;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();

            }
        });

    }
    @Override
    protected void onResume(){
        myVideo1.resume();
        super.onResume();
    }
    @Override
    protected void onPause(){
        myVideo1.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        myVideo1.suspend();
        super.onDestroy();
    }

    /*private Uri getPath(int id) {
        return Uri.parse("android.resource://"+getPackageName()+" /raw/video" + id);
    }*/


    private void songNames() {
        if (currentIndex == 0) {
            songTitle.setText("Sea Rush");
            String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.sea_video;
            Uri uri = Uri.parse(uriPath);
            myVideo1.setVideoURI(uri);
            myVideo1.start();
        }
        if (currentIndex == 1) {
            songTitle.setText("Birds Chrip");
            String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.birds_forest;
            Uri uri = Uri.parse(uriPath);
            myVideo1.setVideoURI(uri);
            myVideo1.start();
        }
        if (currentIndex == 2) {
            songTitle.setText("Hit The Shore");
            String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.hit_the_shore;
            Uri uri = Uri.parse(uriPath);
            myVideo1.setVideoURI(uri);
            myVideo1.start();
        }
        if (currentIndex == 3) {
            songTitle.setText("River");
            String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.mountain_video;
            Uri uri = Uri.parse(uriPath);
            myVideo1.setVideoURI(uri);
            myVideo1.start();
        }
        if (currentIndex == 4) {
            songTitle.setText("Sun Over Rain");
            String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.wave_rush_video;
            Uri uri = Uri.parse(uriPath);
            myVideo1.setVideoURI(uri);
            myVideo1.start();
        }
        if (currentIndex == 5) {
            songTitle.setText("Song Birds");
            String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.trees_video;
            Uri uri = Uri.parse(uriPath);
            myVideo1.setVideoURI(uri);
            myVideo1.start();
        }


        // seekbar duration
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer != null) {
                    try {
                        if (mMediaPlayer.isPlaying()) {
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @SuppressLint("Handler Leak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
}



