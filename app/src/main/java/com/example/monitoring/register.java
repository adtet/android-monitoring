package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class register extends AppCompatActivity {
    public static EditText txtip;
    EditText txtname,txtpassword;
    public static String url;
    LinearLayout wrapper;
    ImageButton btnregister;
    private int tinggidesign = 812;
    private int lebardesign = 418;
    private int dptingggi;
    private int dplebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dptingggi = (displayMetrics.heightPixels);
        dplebar = (displayMetrics.widthPixels);

        wrapper = findViewById(R.id.wrapperformregister);
        ViewGroup.LayoutParams wrapperparam = wrapper.getLayoutParams();
        wrapperparam.height = caltinggi(536,dptingggi);
        wrapperparam.width = callebar(375,dplebar);

        txtname = findViewById(R.id.txtusernameregister);
        ViewGroup.LayoutParams txtnameparam = txtname.getLayoutParams();
        txtnameparam.height = caltinggi(54,dptingggi);
        txtnameparam.width = callebar(314,dplebar);

        txtpassword = findViewById(R.id.txtpasswordregister);
        ViewGroup.LayoutParams txtpasswordparam = txtpassword.getLayoutParams();
        txtpasswordparam.height = caltinggi(54,dptingggi);
        txtpasswordparam.width = callebar(314,dplebar);

        txtip = findViewById(R.id.txtipregister);
        ViewGroup.LayoutParams txtipparam = txtip.getLayoutParams();
        txtipparam.height = caltinggi(54,dptingggi);
        txtipparam.width = callebar(314,dplebar);

        btnregister = findViewById(R.id.btnregisterregister);
        ViewGroup.LayoutParams btnregisterparam = btnregister.getLayoutParams();
        btnregisterparam.height = caltinggi(53,dptingggi);
        btnregisterparam.width = callebar(314,dplebar);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtname.getText().toString().equals("")||txtpassword.getText().toString().equals("")||txtip.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"lengkapi data",Toast.LENGTH_SHORT).show();

                }
                else{
                    url = "http://"+txtip.getText().toString()+":4001/";

                    daftar(txtname.getText().toString(),txtpassword.getText().toString(),txtip.getText().toString(),url);

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

    public void daftar(String username,String password,String ip_adress,String ur){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        postLogin postLogin = new postLogin(username, password, ip_adress);
        jsonplaceholder jsonplaceholder = retrofit.create(com.example.monitoring.jsonplaceholder.class);
        Call<postLogin> call = jsonplaceholder.postregister(postLogin);
        call.enqueue(new Callback<com.example.monitoring.postLogin>() {
            @Override
            public void onResponse(Call<com.example.monitoring.postLogin> call, Response<com.example.monitoring.postLogin> response) {
                postLogin postLogin1 = response.body();
                String m = postLogin1.getPesan();
                Toast.makeText(getApplicationContext(),m,Toast.LENGTH_SHORT).show();
                if(response.code()==200){
                    startActivity(new Intent(register.this,login.class));
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