package com.pkasemer.myshell;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class MeterReading extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter_reading);
        actionBar = getSupportActionBar(); // or getActionBar();
        actionBar.setTitle("Day Shift");
        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            // Define ColorDrawable object and parse color
            // using parseColor method
            // with color hash code as its parameter
            ColorDrawable colorDrawable
                    = new ColorDrawable(ContextCompat.getColor(this, R.color.in_app_main_color));

            // Set BackgroundDrawable
            actionBar.setBackgroundDrawable(colorDrawable);
        }
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.user_bg));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.in_app_main_color));
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}