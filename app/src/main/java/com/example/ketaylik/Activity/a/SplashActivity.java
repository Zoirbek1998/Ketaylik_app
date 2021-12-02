package com.example.ketaylik.Activity.a;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.ketaylik.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class
SplashActivity extends AppCompatActivity {
    public static String TOKEN;
    private FusedLocationProviderClient fusedLoctionProviderClient;
    public static double LATITUDE = 40.757575;
    public static double LONGITUDE = 71.757575;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initstatusBar();
        initVars();
        TOKEN = getToken();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TOKEN.equals("")) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                } else {
                    getLastKnownLocation();
                }
            }
        }, 3000);
    }

    private void getLastKnownLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SplashActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
            return;
        }
        fusedLoctionProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    LONGITUDE = location.getLongitude();
                    LATITUDE = location.getLatitude();

                }
                startActivity(new Intent(SplashActivity.this, ServicesActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastKnownLocation();
            } else {
                Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void initVars() {

        fusedLoctionProviderClient = LocationServices.getFusedLocationProviderClient(this);

    }

    private String getToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        String token = sharedPreferences.getString("Token", "");
        return token;

    }

    private void initstatusBar() {

        if (Build.VERSION.SDK_INT > 23) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }
}