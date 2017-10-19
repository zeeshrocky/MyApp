package training.zeex.com.newapp;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ImageView proceed;
    VideoView mVideoView;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        proceed = (ImageView) findViewById(R.id.proceed);
        mVideoView = (VideoView)findViewById(R.id.videoView);


        String uriPath = "android.resource://training.zeex.com.newapp/"+R.raw.video_bg2;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
             public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent req1int = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(req1int);
            }
        });
    }

    public class BootReciever extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            Intent myIntent = new Intent(context, Main2Activity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);
        }

    }
    @Override
    public void onBackPressed() {
        //Simply Do noting!
    }

    private final List<Integer> mBlockedKeys = new ArrayList<>(Arrays.asList(KeyEvent.KEYCODE_VOLUME_DOWN, KeyEvent.KEYCODE_VOLUME_UP));
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (mBlockedKeys.contains(event.getKeyCode())) {
            return true;
        } else {
            return super.dispatchKeyEvent(event);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.moveTaskToFront(getTaskId(), 0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Log.d("Test", "Back button pressed!");
        }
        else if(keyCode == KeyEvent.KEYCODE_HOME)
        {
            Log.d("Test", "Home button pressed!");

        }
        return super.onKeyDown(keyCode, event);
    }
}
