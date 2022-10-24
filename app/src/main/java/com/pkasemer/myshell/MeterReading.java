package com.pkasemer.myshell;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class MeterReading extends AppCompatActivity {
    ActionBar actionBar;
    String meter_type_id;
    String meter_lable,time_lable;
    TextView title_label,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter_reading);
        actionBar = getSupportActionBar(); // or getActionBar();
        Bundle extras = getIntent().getExtras();

        title_label = findViewById(R.id.lablename);
        time = findViewById(R.id.time);

        if (extras != null) {
            meter_lable = extras.getString(getString(R.string.meter_lable));
            time_lable = extras.getString(getString(R.string.shift_lable));
            // and get whatever type user account id is
            actionBar.setTitle(meter_lable);
            title_label.setText(meter_lable);
            time.setText(time_lable);

        }
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