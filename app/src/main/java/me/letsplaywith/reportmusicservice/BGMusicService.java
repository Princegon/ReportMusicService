package me.letsplaywith.reportmusicservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jinyong on 4/25/15.
 */
public class BGMusicService extends IntentService {

    private static final String TAG = "BGMusicService";
    private MyMusicPlayer mPlayer = MyMusicPlayer.get();
    private Handler mHandler;

    public BGMusicService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /* Obtain a handler to display Toast popup */
        mHandler = new Handler();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "Received an intent: " + intent);

        int btnMode = intent.getIntExtra(MusicService.EXTRA_BUTTON_MODE, -1);

        switch (btnMode) {
            case MusicService.START_MUSIC:
                mPlayer.play(getApplicationContext());
                Log.d(TAG, "onHandleIntent : START_MUSIC - Normal");
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "startService()", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case MusicService.STOP_MUSIC:
                Log.d(TAG, "onHandleIntent : STOP_MUSIC");
                mPlayer.stop();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "stopService()", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                return;
        }
    }

}
