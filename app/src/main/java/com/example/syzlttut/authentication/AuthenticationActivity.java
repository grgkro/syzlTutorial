package com.example.syzlttut.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.syzlttut.R;

public class AuthenticationActivity extends AppCompatActivity {

    private static final String TAG = "AuthenticationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
    }
}