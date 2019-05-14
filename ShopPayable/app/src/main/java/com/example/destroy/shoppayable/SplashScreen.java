package com.example.destroy.shoppayable;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class SplashScreen extends AppCompatActivity {
  private ProgressBar progressBar;
  private WaveLoadingView mWaveLoadingView;
  private AnimationDrawable animation;
  private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        progressBar=findViewById(R.id.progressBars);
        mWaveLoadingView = (WaveLoadingView) findViewById(R.id.wevloader);
        imageView=(ImageView)findViewById(R.id.images);
        animation=(AnimationDrawable)imageView.getDrawable();
        animation.start();

       mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);
      mWaveLoadingView.setAmplitudeRatio(60);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
      thread.start();
    }

    private void dowork() {
int progress;
for (progress=20;progress<=100;progress+=20) {
    try {
        Thread.sleep(2000);
        progressBar.setProgress(progress);

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    }
}
