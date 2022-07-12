package com.example.firebasejava;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

/**
 * Created by Eldor Turgunov on 12.07.2022.
 * Firebase Java
 * eldorturgunov777@gmail.com
 */
public class BaseActivity extends AppCompatActivity {
    AlertDialog dialog;
    Context context;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        context = this;
    }

    void showLoading(Activity activity) {
        if (activity == null) return;

        if (dialog != null && dialog.isShowing()) {

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);

            LayoutInflater inflater = activity.getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.loading, null));
            builder.setCancelable(false);

            dialog = builder.create();
            dialog.show();
        }

    }

    protected void dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    void callSignInActivity(Context context) {
        Intent intent = new Intent(context, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    void callMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
