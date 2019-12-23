package com.example.biodatanabi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;

public class splash_screen extends AppCompatActivity {

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            Intent i = new Intent(splash_screen.this, MainActivity.class);
            splash_screen.this.startActivity(i);
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("first_time", true))
        {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("first_time", true);
            editor.commit();
            Intent i = new Intent(splash_screen.this, MainActivity.class);
            this.startActivity(i);
            this.finish();
        }
        else
        {
            this.setContentView(R.layout.activity_splash_screen);
            handler.sendEmptyMessageDelayed(0, 2000);
        }

    }
}
