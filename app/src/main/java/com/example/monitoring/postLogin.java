package com.example.monitoring;

public class postLogin {
    private String Username;
    private String Password;
    private String IP_Address;
    private String pesan;

    public postLogin(String username,String password,String ip_adress){
        this.Username = username;
        this.Password = password;
        this.IP_Address = ip_adress;
    }

    public String getPesan() {
        return pesan;
    }
}
