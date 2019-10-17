package com.example.reglogimginfirebasewithimg;

public class user {
    String name;
    String email;
    String pass;
    String phone;
    String image;



    public user(){

    }

    public user(String name, String email, String pass, String phone, String image) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
