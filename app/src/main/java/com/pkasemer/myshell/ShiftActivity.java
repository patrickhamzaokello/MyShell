package com.pkasemer.myshell;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ShiftActivity extends AppCompatActivity {
    ActionBar actionBar;
    MaterialCardView petrol_card,vpower_card,diesel_card;
    String shift_lable,shift_type_id;
    TextView shift_id,shift_day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);
        actionBar = getSupportActionBar(); // or getActionBar();
        Bundle extras = getIntent().getExtras();
        shift_day = findViewById(R.id.shift_day);
        shift_id = findViewById(R.id.shift_id);

        if (extras != null) {
            shift_lable = extras.getString(getString(R.string.shift_lable));
            shift_type_id = extras.getString(getString(R.string.shift_type_id));
            // and get whatever type user account id is
            actionBar.setTitle(shift_lable);
            shift_day.setText(shift_lable);
            shift_id.setText(shift_type_id);

        }
        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            // Define ColorDrawable object and parse color
            // using parseColor method
            // with color hash code as its parameter
            ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.in_app_main_color));

            // Set BackgroundDrawable
            actionBar.setBackgroundDrawable(colorDrawable);
        }
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.user_bg));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.in_app_main_color));

        petrol_card = findViewById(R.id.petrol_card);
        vpower_card = findViewById(R.id.vpower_card);
        diesel_card = findViewById(R.id.diesel_card);

        petrol_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShiftActivity.this, MeterReading.class);
                intent.putExtra(getString(R.string.meter_lable), "Petrol");
                intent.putExtra(getString(R.string.meter_type_id), "shell_201");
                intent.putExtra(getString(R.string.shift_lable), shift_lable);
                intent.putExtra(getString(R.string.shift_type_id), shift_type_id);
                startActivity(intent);
            }
        });

        vpower_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShiftActivity.this, MeterReading.class);
                intent.putExtra(getString(R.string.meter_lable), "V-Power");
                intent.putExtra(getString(R.string.meter_type_id), "shell_202");
                intent.putExtra(getString(R.string.shift_lable), shift_lable);
                intent.putExtra(getString(R.string.shift_type_id), shift_type_id);
                startActivity(intent);
            }
        });

        diesel_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShiftActivity.this, MeterReading.class);
                intent.putExtra(getString(R.string.meter_lable), "Diesel");
                intent.putExtra(getString(R.string.meter_type_id), "shell_203");
                intent.putExtra(getString(R.string.shift_lable), shift_lable);
                intent.putExtra(getString(R.string.shift_type_id), shift_type_id);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}