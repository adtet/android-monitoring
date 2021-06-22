package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class grafik extends AppCompatActivity {
    BarChart barChart;
    public String url  = login.url;
    ArrayList timelist = new ArrayList<>();
    ArrayList datalist = new ArrayList<>();
    ArrayList<BarEntry> data_plot = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);

        barChart = findViewById(R.id.barchart_grafik);
        String code = getIntent().getStringExtra("code");
        String code1 = getIntent().getStringExtra("code1");
        if (code.equals("1")&&code1.equals("1")){
            get_list_data_suhu_node1();
        }
        else if(code.equals("2")&&code1.equals("1")){
            get_list_suhu_node2();
        }
        else if(code.equals("1")&&code1.equals("2")){
            get_list_kelembapan_udara_node1();
        }
        else if(code.equals("1")&&code1.equals("3")){
            get_list_kelembapan_tanah_node1();
        }
        else if(code.equals("1")&&code1.equals("4")){
            get_list_cahaya_node1();
        }
        else if(code.equals("1")&&code1.equals("5")){
            get_list_hujan_node1();
        }
        else if(code.equals("2")&&code1.equals("2")){
            get_list_kelembapan_udara_node2();
        }
        else if(code.equals("2")&&code1.equals("3")){
            get_list_kelembapan_tanah_node2();
        }
        else if(code.equals("2")&&code1.equals("4")){
            get_list_cahaya_node2();
        }
        else if(code.equals("2")&&code1.equals("5")){
            get_list_hujan_node2();
        }








    }

    void get_list_data_suhu_node1(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlistsuhunode1();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Suhu (Celsius)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 1");
                        barChart.animateY(2000);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void get_list_kelembapan_udara_node1(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlistudaranode1();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Kelembaban Udara (%)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 1");
                        barChart.animateY(2000);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection",Toast.LENGTH_SHORT).show();
            }
        });

    }

    void get_list_kelembapan_tanah_node1(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlisttanahnode1();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Kelembaban Tanah(%)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 1");
                        barChart.animateY(2000);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void get_list_cahaya_node1(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlistcahayanode1();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Intensitas cahaya(LUX)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 1");
                        barChart.animateY(2000);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void get_list_hujan_node1(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlisthujannode1();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Curah Hujan > 500 (tidak Hujan),Curah Hujan<500(hujan)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 1");
                        barChart.animateY(2000);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void get_list_suhu_node2(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlistsuhunode2();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Suhu (Celsius)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 2");
                        barChart.animateY(2000);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {

            }
        });
    }

    void get_list_kelembapan_udara_node2(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlistudaranode2();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Kelembaban Udara (%)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 2");
                        barChart.animateY(2000);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {

            }
        });
    }

    void get_list_kelembapan_tanah_node2(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlisttanahnode2();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Kelambaban Tanah(%)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 2");
                        barChart.animateY(2000);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {

            }
        });
    }

    void get_list_cahaya_node2(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlistcahayanode2();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Intensitas Cahaya(LUX)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 2");
                        barChart.animateY(2000);
                    }
                }


            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {

            }
        });
    }

    void get_list_hujan_node2(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<List<get_data_for_chart>> call = jsonplaceholder.getlisthujannode2();
        call.enqueue(new Callback<List<get_data_for_chart>>() {
            @Override
            public void onResponse(Call<List<get_data_for_chart>> call, Response<List<get_data_for_chart>> response) {
                if(response.code()==200){
                    List<get_data_for_chart> get_data_for_chart = response.body();
                    if(get_data_for_chart.isEmpty()){

                    }
                    else{
                        for(get_data_for_chart get_data_for_chart1:get_data_for_chart){
                            data_plot.add(new BarEntry(toMins(get_data_for_chart1.getTime()),Float.parseFloat(get_data_for_chart1.getData())));
                        }
                        BarDataSet barDataSet = new BarDataSet(data_plot,"Curah Hujan > 500 (tidak Hujan),Curah Hujan<500(hujan)");
                        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(16f);

                        BarData barData = new BarData(barDataSet);

                        barChart.setFitBars(true);
                        barChart.setData(barData);
                        barChart.getDescription().setText("Node 2");
                        barChart.animateY(2000);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<get_data_for_chart>> call, Throwable t) {

            }
        });

    }




    private static int toMins(String s) {
        String[] hourMin = s.split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        int hoursInMins = hour * 60;
        return hoursInMins + mins;
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        finish();
//    }
//
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        finish();
//    }
}