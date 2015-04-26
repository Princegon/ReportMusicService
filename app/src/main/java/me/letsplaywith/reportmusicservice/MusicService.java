package me.letsplaywith.reportmusicservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MusicService extends Activity {

    public static final String EXTRA_BUTTON_MODE = "me.letsplaywith.MusicService.button_mode";
    public static final int START_MUSIC = 0;
    public static final int STOP_MUSIC = 1;

    private Button mStartBtn, mStopBtn;
    private Intent mMusicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_service);
        mMusicIntent = new Intent(this, BGMusicService.class);

        mStartBtn = (Button) findViewById(R.id.btn_music_start);
        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excuteMusicIntentService(mMusicIntent, START_MUSIC);
            }
        });

        mStopBtn = (Button) findViewById(R.id.btn_music_stop);
        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excuteMusicIntentService(mMusicIntent, STOP_MUSIC);
            }
        });
    }

    private void excuteMusicIntentService(Intent i, int $Mode) {

        i.putExtra(EXTRA_BUTTON_MODE, $Mode);
        startService(i);
    }
}
