package com.example.monitoring;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface jsonplaceholder {
    @POST("monitor/login/user")
    Call<postLogin>postlogin(@Body postLogin postLogin);
    @POST("monitor/register/user")
    Call<postLogin>postregister(@Body postLogin postLogin);
}
