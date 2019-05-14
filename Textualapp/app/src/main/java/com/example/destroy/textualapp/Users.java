package com.example.destroy.textualapp;

/**
 * Created by Destroy on 11-Jan-18.
 */

public class Users {
    public String name;
    public String status;
    public String thumb_image;
    public String image;

    public Users(){

    }

    public Users(String name, String status, String thumb_image, String image) {
        this.name = name;
        this.status = status;
        this.thumb_image = thumb_image;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumb_image() {
        return thumb_image;
    }

    public void setThumb_image(String thumb_image) {
        this.thumb_image = thumb_image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
