package com.example.onekkosteachi.All_ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class BuyLink {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public BuyLink() {
    }

    /**
     *
     * @param name
     * @param url
     */
    public BuyLink(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BuyLink{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}