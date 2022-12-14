package com.pkasemer.myshell;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.splashscreen.SplashScreen;

import com.pkasemer.myshell.HelperClasses.SharedPrefManager;


public class SplashActivity extends AppCompatActivity {


    Button login_screen,register_btn;
    private String[] PERMISSIONS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);


        //if the user is already logged in we will directly start the profile activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, RootActivity.class));
            finish();
            return;
        }


        setContentView(R.layout.activity_sign_up_options);
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("My Shell"); // set the top title
        String title = actionBar.getTitle().toString(); // get the title
        actionBar.hide();
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.user_bg));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.user_bg));

        login_screen = findViewById(R.id.login_screen);
        register_btn = findViewById(R.id.register_btn);



        login_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, LoginMaterial.class);
                startActivity(intent);
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, RegisterMaterial.class);
                startActivity(intent);
            }
        });



        AskPermissions();

    }

    private void AskPermissions() {

        PERMISSIONS = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };

        if(!hasPermissions(SplashActivity.this, PERMISSIONS)){
            ActivityCompat.requestPermissions(SplashActivity.this, PERMISSIONS, 1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){


            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "ACCESS_FINE_LOCATION granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "ACCESS_FINE_LOCATION denied", Toast.LENGTH_SHORT).show();
            }
            if(grantResults[1]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "ACCESS_COARSE_LOCATION granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "ACCESS_COARSE_LOCATION denied", Toast.LENGTH_SHORT).show();
            }
            if(grantResults[2]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "CAMERA granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "CAMERA denied", Toast.LENGTH_SHORT).show();
            }
            if(grantResults[3]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "READ_EXTERNAL_STORAGEgranted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "READ_EXTERNAL_STORAGE denied", Toast.LENGTH_SHORT).show();
            }
            if(grantResults[4]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "WRITE_EXTERNAL_STORAGE granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "WRITE_EXTERNAL_STORAGE denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean hasPermissions(Context context, String... PERMISSIONS){
        if(context != null && PERMISSIONS != null){
            for (String permission: PERMISSIONS){
                if(ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }

}