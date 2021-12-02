package com.example.ketaylik.Activity.a.Response;

import com.example.ketaylik.Activity.a.model.Offer;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OfferReesponse {
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("error_code")
    int error_code;
    @SerializedName("data")
    List<Offer> offerList;

    public OfferReesponse(boolean success, String message, int error_code, List<Offer> offerList) {
        this.success = success;
        this.message = message;
        this.error_code = error_code;
        this.offerList = offerList;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }
}
