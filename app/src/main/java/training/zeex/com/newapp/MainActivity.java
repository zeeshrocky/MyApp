package training.zeex.com.newapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ImageView req1, req2, req3, req4, req5, req6, req7, req8;
    ImageView login;
    VideoView mVideoView;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        req1 = (ImageView) findViewById(R.id.button1);
        req2 = (ImageView) findViewById(R.id.button2);
        req3 = (ImageView) findViewById(R.id.button3);
        req4 = (ImageView) findViewById(R.id.button4);
        req5 = (ImageView) findViewById(R.id.button5);
        req6 = (ImageView) findViewById(R.id.button6);
        req7 = (ImageView) findViewById(R.id.button7);
        req8 = (ImageView) findViewById(R.id.button8);
        login = (ImageView) findViewById(R.id.title);
        mVideoView = (VideoView)findViewById(R.id.videoView2);


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


                login.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Intent log = new Intent(MainActivity.this,Login.class);
                        // TODO Auto-generated method stub
                        startActivity(log);
                        return true;
                    }
                });





    }



    public void blink1(View view){
        ImageView image = (ImageView)findViewById(R.id.button1);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req1.class);
        startActivity(req1int);
    }

    public void blink2(View view){
        ImageView image = (ImageView)findViewById(R.id.button2);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req2.class);
        startActivity(req1int);
    }

    public void blink3(View view){
        ImageView image = (ImageView)findViewById(R.id.button3);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req3.class);
        startActivity(req1int);
    }

    public void blink4(View view){
        ImageView image = (ImageView)findViewById(R.id.button4);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req4.class);
        startActivity(req1int);
    }

    public void blink5(View view){
        ImageView image = (ImageView)findViewById(R.id.button5);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req5.class);
        startActivity(req1int);
    }

    public void blink6(View view){
        ImageView image = (ImageView)findViewById(R.id.button6);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req6.class);
        startActivity(req1int);
    }

    public void blink7(View view){
        ImageView image = (ImageView)findViewById(R.id.button7);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req7.class);
        startActivity(req1int);
    }

    public void blink8(View view){
        ImageView image = (ImageView)findViewById(R.id.button8);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
        Intent req1int = new Intent(MainActivity.this,req8.class);
        startActivity(req1int);
    }


    @Override
    public void onBackPressed() {
    Intent back=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(back);
    }

    private final List<Integer> mBlockedKeys = new ArrayList<>(Arrays.asList(KeyEvent.KEYCODE_VOLUME_DOWN,
            KeyEvent.KEYCODE_VOLUME_UP));

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
}


