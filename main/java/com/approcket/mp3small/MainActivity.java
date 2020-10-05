package com.approcket.mp3small;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;
    private static final String Tag="MainActivity.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
        playing();
    }
    public void playing()
    {
        Log.d(Tag,"Starting");
        if(player==null)
        {
            player=MediaPlayer.create(this,R.raw.perfect);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag,"OnPause()");
        if(player!=null)
        {
            player.pause();
        }
    }

   

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag,"onResume()");
        if(player!=null) {
            playing();
        }
    }

    public void pause(View view) {
        Log.d(Tag,"Pausing video");

    }

    public void stop(View view) {
        Log.d(Tag,"Stopping");
        stopPlayer();
    }
    public void stopPlayer()
    {
        if(player!=null)
        {
            player.release();
            player=null;
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }
}