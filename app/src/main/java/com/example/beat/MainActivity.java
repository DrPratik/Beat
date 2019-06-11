package com.example.beat;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnLongClickListener {
    MediaPlayer mediaPlayer,player;
    SoundPool soundPool;
    Random crazy=new Random();
    int explode=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        View v=new View(this);
        v.setOnClickListener(this);
        v.setOnTouchListener(this);
        v.setOnLongClickListener(this);
        setContentView(v);
        v.setBackgroundColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265)));
        mediaPlayer= MediaPlayer.create(this,R.raw.backgroundmusic);
        mediaPlayer.start();
        player=MediaPlayer.create(this,R.raw.soundtrack);
        soundPool =new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        explode=soundPool.load(this,R.raw.explosion,1);
    }

    @Override
    public void onClick(View v) {
        if(explode!=0)
        {
            soundPool.play(explode,1,1,0,0,1);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        v.setBackgroundColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(264),crazy.nextInt(265)));

        return true;
    }

    @Override
    public boolean onLongClick(View v) {

        mediaPlayer.stop();
        return true;
    }
}
