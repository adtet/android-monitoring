package com.example.monitoring;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface jsonplaceholder {
    @POST("monitor/login/user")
    Call<postLogin>postlogin(@Body postLogin postLogin);
    @POST("monitor/register/user")
    Call<postLogin>postregister(@Body postLogin postLogin);
    @GET("monitor/node1")
    Call<getNode1>getnode1();
    @GET("monitor/node2")
    Call<getNode1>getnode2();
}
