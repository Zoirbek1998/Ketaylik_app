package com.example.ketaylik.Activity.a.model;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("name")
    String name;
    @SerializedName("id")
    int id;
    @SerializedName("latitude")
    double latitude;
    @SerializedName("longitude")
    double longitude;

    public City(String name, int id, double latitude, double longitude) {
        this.name = name;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
