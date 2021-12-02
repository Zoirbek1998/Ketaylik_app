package com.example.ketaylik.Activity.a.model;

import com.google.gson.annotations.SerializedName;

public class RegisterData {
    @SerializedName("phone")
    String phone;

    public RegisterData(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
