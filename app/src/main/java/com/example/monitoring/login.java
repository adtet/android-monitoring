package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {
    TextView txtregister;
    public static EditText txtip;
    EditText txtname,txtpassword;
    public static String url;
    LinearLayout wrapper;
    ImageButton btnlogin;
    private int tinggidesign = 812;
    private int lebardesign = 418;
    private int dptingggi;
    private int dplebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtregister = findViewById(R.id.txtregisterlogin);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dptingggi = (displayMetrics.heightPixels);
        dplebar = (displayMetrics.widthPixels);

        wrapper = findViewById(R.id.wrapperinputlogin);
        ViewGroup.LayoutParams wrapperparam = wrapper.getLayoutParams();
        wrapperparam.height = caltinggi(536,dptingggi);
        wrapperparam.width = callebar(375,dplebar);


        txtname = findViewById(R.id.txtusernamelogin);
        ViewGroup.LayoutParams txtnameparam = (ViewGroup.LayoutParams)txtname.getLayoutParams();
        txtnameparam.height = caltinggi(54,dptingggi);
        txtnameparam.width = callebar(314,dplebar);

        txtpassword = findViewById(R.id.txtpasswordlogin);
        ViewGroup.LayoutParams txtpasswordparam = txtpassword.getLayoutParams();
        txtpasswordparam.height = caltinggi(54,dptingggi);
        txtpasswordparam.width = callebar(314,dplebar);

        txtip = findViewById(R.id.txtiplogin);
        ViewGroup.LayoutParams txtipparam = txtip.getLayoutParams();
        txtipparam.height = caltinggi(54,dptingggi);
        txtipparam.width = callebar(314,dplebar);

        btnlogin = findViewById(R.id.btnloginlogin);
        ViewGroup.LayoutParams btnloginparam = btnlogin.getLayoutParams();
        btnloginparam.height = caltinggi(53,dptingggi);
        btnloginparam.width = callebar(314,dplebar);


        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,register.class));
            }
        });


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtname.getText().toString().equals("")||txtpassword.getText().toString().equals("")||txtip.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"lengkapi data",Toast.LENGTH_SHORT).show();

                }
                else{
                    url = "http://"+txtip.getText().toString()+":4001/";

                    masuk(txtname.getText().toString(),txtpassword.getText().toString(),txtip.getText().toString(),url);

                }
            }
        });

    }
    public int caltinggi(float value,int dp){
        return (int)(dp*(value/tinggidesign));
    }
    public int callebar(float value,int dp){
        return (int)(dp*(value/lebardesign));
    }

    public void masuk(String username,String password,String ip_adress,String url){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        postLogin postLogin = new postLogin(username, password, ip_adress);
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<postLogin>call = jsonplaceholder.postlogin(postLogin);
        call.enqueue(new Callback<com.example.monitoring.postLogin>() {
            @Override
            public void onResponse(Call<com.example.monitoring.postLogin> call, Response<com.example.monitoring.postLogin> response) {
                postLogin postLogin1 = response.body();
                String m = postLogin1.getPesan();
                Toast.makeText(getApplicationContext(),m,Toast.LENGTH_SHORT).show();
                if(response.code()==200){
                    startActivity(new Intent(login.this,data_info.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<com.example.monitoring.postLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Lost connection to raspberry",Toast.LENGTH_SHORT).show();
            }
        });
    }

}