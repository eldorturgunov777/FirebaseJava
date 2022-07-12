package com.example.firebasejava;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import com.example.firebasejava.manager.AuthManager;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash);
        initViews();
    }

    private void initViews() {
        countDownTimer();
    }

    private void countDownTimer() {
        new CountDownTimer(2000, 1000) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if (AuthManager.isSignedIn()) {
                    callMainActivity(context);
                } else {
                    callSignInActivity(context);
                }
            }
        }.start();
    }


}