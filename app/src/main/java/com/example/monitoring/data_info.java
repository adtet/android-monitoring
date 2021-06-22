package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class data_info extends AppCompatActivity {
    TextView txtsuhu,txtkelembapanudara,txtcahaya,txthujan,txtkelembapantanah,node1,node2;
    public String url  = login.url;
    SharedPreferences sharedPreferences;
    Button graphsuhu,graphudara,graphtanah,graphcahaya,graphhujan;
    public int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_info);
        txtsuhu = findViewById(R.id.txtsuhuinfo);
        txtcahaya =  findViewById(R.id.txtcahayainfo);
        txtkelembapanudara = findViewById(R.id.txtkelembapanudarainfo);
        txtkelembapantanah = findViewById(R.id.txtkelembapantanahinfo);
        txthujan = findViewById(R.id.txthujaninfo);
        sharedPreferences = this.getSharedPreferences("code", Context.MODE_PRIVATE);
        node1 = findViewById(R.id.txtnode1);
        node2 = findViewById(R.id.txtnode2);
        graphsuhu = findViewById(R.id.btn_cek_detail_info_suhu);
        graphudara = findViewById(R.id.btn_cek_detail_udara_data_info);
        graphtanah = findViewById(R.id.btn_cek_detail_tanah_data_info);
        graphcahaya = findViewById(R.id.btn_cek_detail_cahaya_data_info);
        graphhujan = findViewById(R.id.btn_cek_detail_hujan_data_info);

        node1.setTextColor(Color.WHITE);
        node2.setTextColor(Color.RED);
        getnode1();
        code=1;
        graphsuhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(data_info.this,grafik.class);
                i.putExtra("code",String.valueOf(code));
                i.putExtra("code1","1");
                startActivity(i);

            }
        });
        graphudara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(data_info.this,grafik.class);
                i.putExtra("code",String.valueOf(code));
                i.putExtra("code1","2");
                startActivity(i);
            }
        });
        graphtanah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(data_info.this,grafik.class);
                i.putExtra("code",String.valueOf(code));
                i.putExtra("code1","3");
                startActivity(i);
            }
        });
        graphcahaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(data_info.this,grafik.class);
                i.putExtra("code",String.valueOf(code));
                i.putExtra("code1","4");
                startActivity(i);
            }
        });
        graphhujan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(data_info.this,grafik.class);
                i.putExtra("code",String.valueOf(code));
                i.putExtra("code1","5");
                startActivity(i);
            }
        });
        node1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node1.setTextColor(Color.WHITE);
                node2.setTextColor(Color.RED);
                code=1;
                getnode1();
            }
        });

        node2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node2.setTextColor(Color.WHITE);
                node1.setTextColor(Color.RED);
                code=2;
                getnode2();
            }
        });


    }

    private  void getnode1(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<getNode1> call = jsonplaceholder.getnode1();
        call.enqueue(new Callback<getNode1>() {
            @Override
            public void onResponse(Call<getNode1> call, Response<getNode1> response) {
                getNode1 getNode1 = response.body();
                txtsuhu.setText(getNode1.getSuhu());
                txtcahaya.setText(getNode1.getIntensitas_cahaya());
                txtkelembapantanah.setText(getNode1.getKelembapan_tanah());
                txtkelembapanudara.setText(getNode1.getKelembapan_udara());
                txthujan.setText(getNode1.getCurah_hujan());
                code = 1;
            }

            @Override
            public void onFailure(Call<getNode1> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection to raspberry",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getnode2(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<getNode1> call = jsonplaceholder.getnode2();
        call.enqueue(new Callback<getNode1>() {
            @Override
            public void onResponse(Call<getNode1> call, Response<getNode1> response) {
                getNode1 getNode1 = response.body();
                txtsuhu.setText(getNode1.getSuhu());
                txtcahaya.setText(getNode1.getIntensitas_cahaya());
                txtkelembapantanah.setText(getNode1.getKelembapan_tanah());
                txtkelembapanudara.setText(getNode1.getKelembapan_udara());
                txthujan.setText(getNode1.getCurah_hujan());
                code=2;
            }

            @Override
            public void onFailure(Call<getNode1> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection to raspberry",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}