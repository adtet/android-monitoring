package com.example.monitoring;

import java.util.List;

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
    @GET("monitor/suhu")
    Call<List<get_data_for_chart>>getlistsuhunode1();
    @GET("monitor/udara")
    Call<List<get_data_for_chart>>getlistudaranode1();
    @GET("monitor/tanah")
    Call<List<get_data_for_chart>>getlisttanahnode1();
    @GET("monitor/cahaya")
    Call<List<get_data_for_chart>>getlistcahayanode1();
    @GET("monitor/hujan")
    Call<List<get_data_for_chart>>getlisthujannode1();
    @GET("monitor/suhu2")
    Call<List<get_data_for_chart>>getlistsuhunode2();
    @GET("monitor/udara2")
    Call<List<get_data_for_chart>>getlistudaranode2();
    @GET("monitor/tanah2")
    Call<List<get_data_for_chart>>getlisttanahnode2();
    @GET("monitor/cahaya2")
    Call<List<get_data_for_chart>>getlistcahayanode2();
    @GET("monitor/hujan2")
    Call<List<get_data_for_chart>>getlisthujannode2();
}
