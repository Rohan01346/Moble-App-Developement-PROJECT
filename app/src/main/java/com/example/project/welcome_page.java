package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;

public class welcome_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
                String inside_check = sharedPreferences.getString("inside","");
                if(inside_check.equals("1"))
                {
                    Intent intent = new Intent(welcome_page.this , Banking.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(welcome_page.this , Login_page.class);
                    startActivity(intent);
                    finish();
                }

            }
        },1500);
    }
}

