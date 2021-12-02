package com.example.ketaylik.Activity.a;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ketaylik.Activity.a.Adapter.ServicesAdapter;
import com.example.ketaylik.Activity.a.Response.CityResponse;
import com.example.ketaylik.Activity.a.Response.ServicesResponse;
import com.example.ketaylik.Activity.a.model.City;
import com.example.ketaylik.Activity.a.model.Services;
import com.example.ketaylik.Activity.a.netWork.ApiClient;
import com.example.ketaylik.Activity.a.netWork.ApiInterface;
import com.example.ketaylik.R;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ServicesActivity extends AppCompatActivity {
    public static int CITY_ID = 0;
    public double distance = 999999999;
    public String name = "";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        loadCities();
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);


    }

    private void loadCities() {
        Call<CityResponse> call = ApiClient.getClient().create(ApiInterface.class).getCity(SplashActivity.TOKEN);
        call.enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                CityResponse cityResponse = response.body();
                if (cityResponse.isSuccess()) {
                    List<City> cityList = cityResponse.getData();
                    identifyCity(cityList);
                } else {
                    String message = cityResponse.getMessage();
                    Toast.makeText(ServicesActivity.this, "" + message, Toast.LENGTH_SHORT).show();

                    int code = cityResponse.getError_code();
                    if (code == 9 || code == 8) {
                        startActivity(new Intent(ServicesActivity.this, LoginActivity.class));
                        finish();
                    }
                }

            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {

            }
        });

    }

    private void identifyCity(List<City> cityList) {
        for (City city : cityList) {
            double cityLat = city.getLatitude();
            double cityLon = city.getLongitude();
            double dist = distance(SplashActivity.LATITUDE, SplashActivity.LONGITUDE, cityLat, cityLon);
            if (dist < distance) {
                distance = dist;
                name = city.getName();
                CITY_ID = city.getId();
            }
        }
        if (CITY_ID != 0) {
            loadServices();
        }


    }

    private void loadServices() {
        Call<ServicesResponse> call = ApiClient.getClient().create(ApiInterface.class).getServices(SplashActivity.TOKEN);
        call.enqueue(new Callback<ServicesResponse>() {
            @Override
            public void onResponse(Call<ServicesResponse> call, Response<ServicesResponse> response) {
                ServicesResponse servicesResponse = response.body();
                if (servicesResponse.isSuccess()) {
                    List<Services> servicesList = servicesResponse.getData();
                    ServicesAdapter servicesAdapter = new ServicesAdapter(ServicesActivity.this, servicesList);
                    recyclerView.setAdapter(servicesAdapter);
                } else {
                    String message = servicesResponse.getMessage();
                    Toast.makeText(ServicesActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServicesResponse> call, Throwable t) {

            }
        });
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60;// 60 nautical miles per degree of seperation
        dist = dist * 1852;
        return (dist);
    }

    private double deg2rad(double deg) {
        return deg * Math.PI / 180.0;
    }

    private double rad2deg(double red) {
        return red * 180.0 / Math.PI;
    }
}