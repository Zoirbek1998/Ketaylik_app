package com.example.ketaylik.Activity.a.Response;

import com.example.ketaylik.Activity.a.model.Categories;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesReesponse {
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("error_code")
    int error_code;
    @SerializedName("data")
    List<Categories> categoriesList;

    public CategoriesReesponse(boolean success, String message, int error_code, List<Categories> categoriesList) {
        this.success = success;
        this.message = message;
        this.error_code = error_code;
        this.categoriesList = categoriesList;
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

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
