package com.example.ketaylik.Activity.a.Response;

import com.example.ketaylik.Activity.a.model.RegisterData;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("error_code")
    int error_code;
    @SerializedName("data")
    RegisterData data;

    public RegisterResponse(boolean success, String message, int error_code, RegisterData data) {
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

    public RegisterData getData() {
        return data;
    }

    public void setData(RegisterData data) {
        this.data = data;
    }
}
