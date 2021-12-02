package com.example.ketaylik.Activity.a.netWork;

import com.example.ketaylik.Activity.a.Response.CategoriesReesponse;
import com.example.ketaylik.Activity.a.Response.CityResponse;
import com.example.ketaylik.Activity.a.Response.ConfirmResponse;
import com.example.ketaylik.Activity.a.Response.OfferReesponse;
import com.example.ketaylik.Activity.a.Response.RegisterResponse;
import com.example.ketaylik.Activity.a.Response.SectionResponse;
import com.example.ketaylik.Activity.a.Response.ServicesResponse;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST(ApiUrl.LOGIN_URL)
    public Call<RegisterResponse> sendPhone(@Query("phone") String phone);

    @POST(ApiUrl.CONFIRM_URL)
    public Call<ConfirmResponse> sendSms(@Query("phone") String phone, @Query("code") String code);

    @POST(ApiUrl.CITY_URL)
    public Call<CityResponse> getCity(@Header("auth_token") String token);

    @POST(ApiUrl.GET_SERVICES_URL)
    public Call<ServicesResponse> getServices(@Header("auth_token") String token);

    @POST(ApiUrl.RESTAURANTS_URL + "{city_id}/{service_id}/get")
    Call<SectionResponse> loadSections(@Path(value = "city_id", encoded = true) String city_id,
                                       @Path(value = "service_id", encoded = true) String service_id,
                                       @Header("auth_token") String token);

    @POST(ApiUrl.OFFER_URL)
    Call<OfferReesponse> loadOffers(@Header("auth_token") String token,
                                    @Query("city_id") String city_id);

    @POST(ApiUrl.CATEGORE_URL + "{service_id}/get")
    Call<CategoriesReesponse> loadCategories(@Path(value = "service_id", encoded = true) String service_id,
                                             @Header("auth_token") String token);

}
