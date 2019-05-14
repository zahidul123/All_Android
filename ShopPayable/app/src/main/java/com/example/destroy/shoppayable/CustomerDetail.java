package com.example.destroy.shoppayable;

public class CustomerDetail {
    int id;
    String cname;
    String cemail;
    String cphone;

    public CustomerDetail(int id, String name, String email, String phone) {
        this.id=id;
        this.cname=name;
        this.cphone=phone;
        this.cemail=email;
    }

    public CustomerDetail() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmail() {
        return cemail;
    }

    public void setEmail(String email) {
        this.cemail = email;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }
}
