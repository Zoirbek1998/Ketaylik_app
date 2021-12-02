package com.example.ketaylik.Activity.a.model;

import com.google.gson.annotations.SerializedName;

public class Section {
    @SerializedName("id")
    int id;
    @SerializedName("name_uz")
    String name;
    @SerializedName("image")
    String image;
    @SerializedName("working_hours_from")
    String working_hours_from;
    @SerializedName("working_hours_to")
    String working_hours_to;
    @SerializedName("delivery_time_min")
    String delivery_time_min;
    @SerializedName("delivery_time_max")
    String delivery_time_max;

    public Section(int id, String name, String image, String working_hours_from, String working_hours_to, String delivery_time_min, String delivery_time_max) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.working_hours_from = working_hours_from;
        this.working_hours_to = working_hours_to;
        this.delivery_time_min = delivery_time_min;
        this.delivery_time_max = delivery_time_max;
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

    public String getWorking_hours_from() {
        return working_hours_from;
    }

    public void setWorking_hours_from(String working_hours_from) {
        this.working_hours_from = working_hours_from;
    }

    public String getWorking_hours_to() {
        return working_hours_to;
    }

    public void setWorking_hours_to(String working_hours_to) {
        this.working_hours_to = working_hours_to;
    }

    public String getDelivery_time_min() {
        return delivery_time_min;
    }

    public void setDelivery_time_min(String delivery_time_min) {
        this.delivery_time_min = delivery_time_min;
    }

    public String getDelivery_time_max() {
        return delivery_time_max;
    }

    public void setDelivery_time_max(String delivery_time_max) {
        this.delivery_time_max = delivery_time_max;
    }
}
