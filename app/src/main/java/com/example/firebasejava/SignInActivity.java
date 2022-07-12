package com.example.firebasejava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasejava.manager.AuthHandler;
import com.example.firebasejava.manager.AuthManager;

import java.util.regex.Pattern;

public class SignInActivity extends BaseActivity {
    Button bt_up;
    TextView tv_signUp, validate;
    EditText et_email;
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        bt_up = findViewById(R.id.bt_up);
        tv_signUp = findViewById(R.id.tv_signUp);
        et_email = findViewById(R.id.et_email);
        validate = findViewById(R.id.validate);
        validate.setVisibility(View.GONE);
        et_password = findViewById(R.id.et_password);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        validate.startAnimation(anim);

        bt_up.setOnClickListener(view -> {
            String email = et_email.getText().toString().trim();
            if (!et_email.getText().toString().isEmpty() && !et_password.getText().toString().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                String password = et_password.getText().toString().trim();
                firebaseSignIn(email, password);
            } else {
                validate.setText("Email or Password invalid");
                validate.setVisibility(View.VISIBLE);
            }
        });
        tv_signUp.setOnClickListener(view -> openSignUp());
    }

    private void firebaseSignIn(String email, String password) {
        showLoading(this);
        AuthManager.signIn(email, password, new AuthHandler() {
            @Override
            public void onSuccess() {
                dismissDialog();
                Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();
                callMainActivity(context);
            }

            @Override
            public void onError(Exception exception) {
                dismissDialog();
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


    void openSignUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
}