package com.example.ketaylik.Activity.a.model;

import com.google.gson.annotations.SerializedName;

public class Offer {
    @SerializedName("id")
    int id;
    @SerializedName("link")
    String link;
    @SerializedName("type")
    String type;
    @SerializedName("image")
    String image;

    public Offer(int id, String link, String type, String image) {
        this.id = id;
        this.link = link;
        this.type = type;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
