package com.iitbbs.esummit;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FullscreenActivity extends AppCompatActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fullscreen);

        String string = null;
        string = "Version : "+BuildConfig.VERSION_NAME;
        TextView textView = findViewById(R.id.version);
        textView.setText(string);
        final RelativeLayout screen = (RelativeLayout) findViewById(R.id.linearl);


        (new Thread(){
            @Override
            public void run(){
                for( int i = 0; i<=255; i++){
                    final int finalI = i;
                    handler.post(new Runnable(){
                        public void run(){
                            screen.setBackgroundColor(Color.argb(finalI, 0, 153, 204));
                        }
                    });
                    // next will pause the thread for some time
                    try{ sleep(10); } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                Intent i = new Intent(FullscreenActivity.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, 2000);



    }


}