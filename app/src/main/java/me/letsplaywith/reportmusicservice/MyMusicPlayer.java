package me.letsplaywith.reportmusicservice;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by jinyong on 4/25/15.
 */
public class MyMusicPlayer extends MediaPlayer {

    private static MyMusicPlayer sMusicPlayer;
    private int mSongResourceId = R.raw.song1;
    private MediaPlayer mPlayer;

    private MyMusicPlayer() {
        Log.d("MyMusicPlayer", "is created");
    }

    public static MyMusicPlayer get() {
        if (sMusicPlayer == null) {
            sMusicPlayer = new MyMusicPlayer();
        }
        return sMusicPlayer;
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context $Context) {
        if (mPlayer != null) {
            stop();
        }

        mPlayer = MediaPlayer.create($Context, mSongResourceId);
        mPlayer.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }
}
