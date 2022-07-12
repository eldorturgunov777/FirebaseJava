package com.example.firebasejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasejava.manager.AuthHandler;
import com.example.firebasejava.manager.AuthManager;

public class SignUpActivity extends BaseActivity {
    Button bt_up;
    TextView tv_signIn;
    EditText et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bt_up = findViewById(R.id.bt_up);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        bt_up.setOnClickListener(view -> {
            if (!et_email.getText().toString().isEmpty() && !et_password.getText().toString().isEmpty()) {
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                firebaseSignUp(email, password);
            }
        });
        tv_signIn = findViewById(R.id.tv_signIn);
        tv_signIn.setOnClickListener(view -> callSignInActivity(this));


    }

    private void firebaseSignUp(String email, String password) {
        showLoading(this);
        AuthManager.signUp(email, password, new AuthHandler() {
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
}