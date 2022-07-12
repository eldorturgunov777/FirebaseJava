package com.example.firebasejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firebasejava.manager.AuthManager;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button logOut = findViewById(R.id.logOut);
        logOut.setOnClickListener(view -> {
            AuthManager.signUot();
            callSignInActivity(context);
        });
    }
}