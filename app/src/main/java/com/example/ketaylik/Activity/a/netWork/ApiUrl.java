package com.example.ketaylik.Activity.a.netWork;

public class ApiUrl {

    public static final String BASE_URL = "http://admin.ketaylik.uz";

    public static final String LOGIN_URL = BASE_URL + "/api/customer/auth/register";
    public static final String CONFIRM_URL = BASE_URL + "/api/customer/auth/confirm";
    public static final String SET_CUSTOMER_ADDRESS_URL = BASE_URL + "/api/customer/auth/set_customer_address";
    public static final String SEND_FCM = BASE_URL + "/api/customer/auth/set_customer_fcm";
    public static final String GET_SERVICES_URL = BASE_URL + "/api/customer/services/get";
    public static final String GET_PRICES_URL = BASE_URL + "/api/customer/auth/get_prices";
    public static final String OFFER_URL = BASE_URL + "/api/customer/offers/get";
    public static final String CATEGORE_URL = BASE_URL + "/api/customer/categories/";
    public static final String CITY_URL = BASE_URL + "/api/customer/cities/get";
    public static final String RESTAURANTS_URL = BASE_URL + "/api/customer/restaurants/";
    public static final String ADD_TO_CART_URL = BASE_URL + "/api/customer/praduct/";
    public static final String RESTAURANTS_DETAILS_URL = BASE_URL + "/api/customer/restaurants/";
    public static final String FAVORITE_URL = BASE_URL + "/api/customer/restaurant/";
    public static final String GET_FAVORITE_URL = BASE_URL + "/api/customer/restaurants/";
    public static final String GET_CART_LIST_URL = BASE_URL + "/api/customer/product/get_cart_list";
    public static final String DECREMENT_URL = BASE_URL + "/api/custome/product/";
    public static final String REMOVE_URL = BASE_URL + "/api/custome/product/";
    public static final String CLEAR_CART_URL = BASE_URL + "/api/custome/product/clear_cart";
    public static final String CREATE_ORDER = BASE_URL + "/api/custome/order/create";
    public static final String ORDER_URL = BASE_URL + "/api/custome/order/get";
    public static final String GET_SINGLE_ORDER_URL = BASE_URL + "/api/custome/orders/";
    public static final String DELETE_ORDER_URL = BASE_URL + "/api/custome/orders/";
    public static final String GET_CURRENT_TIME_URL = BASE_URL + "/api/custome/restaurants/get_current_time";
    public static final String SEARCH_RESTAURANT_URL = BASE_URL + "/api/custome/restauranrs/";


}
