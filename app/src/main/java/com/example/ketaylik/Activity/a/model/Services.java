package com.example.ketaylik.Activity.a.model;

import com.google.gson.annotations.SerializedName;

public class Services {
    @SerializedName("id")
    int id;
    @SerializedName("name_uz")
    String name;
    @SerializedName("image")
    String image;

    public Services(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
