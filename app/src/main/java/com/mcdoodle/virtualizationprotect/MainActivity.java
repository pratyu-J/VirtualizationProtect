package com.mcdoodle.virtualizationprotect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mcdoodle.checkvirtualenv.CheckEnv;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String pkg = getPackageName();
        CheckEnv check = new CheckEnv(pkg, this);
        check.options();
    }
}