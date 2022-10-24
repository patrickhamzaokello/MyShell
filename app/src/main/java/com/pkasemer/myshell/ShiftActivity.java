package com.pkasemer.myshell;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class ShiftActivity extends AppCompatActivity {
    ActionBar actionBar;
    MaterialCardView petrol_card,vpower_card,diesel_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);
        actionBar = getSupportActionBar(); // or getActionBar();
        actionBar.setTitle("Day Shift");
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
                intent.putExtra("Petrol", "Petrol");
                startActivity(intent);
            }
        });

        vpower_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShiftActivity.this, MeterReading.class);
                intent.putExtra("Petrol", "V-Power");
                startActivity(intent);
            }
        });

        diesel_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShiftActivity.this, MeterReading.class);
                intent.putExtra("Petrol", "Diesel");
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