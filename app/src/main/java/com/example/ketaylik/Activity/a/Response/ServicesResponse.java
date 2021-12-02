package com.example.ketaylik.Activity.a.Response;



import com.example.ketaylik.Activity.a.model.Services;
import com.google.gson.annotations.SerializedName;

import java.security.Provider;
import java.util.List;

public class ServicesResponse {
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("error_code")
    int error_code;
    @SerializedName("data")
    List<Services> data;

    public ServicesResponse(boolean success, String message, int error_code, List<Services> data) {
        this.success = success;
        this.message = message;
        this.error_code = error_code;
        this.data = data;
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

    public List<Services> getData() {
        return data;
    }

    public void setData(List<Services> data) {
        this.data = data;
    }
}
