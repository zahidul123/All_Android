package com.example.habib.infobook;

/**
 * Created by Habib on 7/31/17.
 */

public class Users {
    private String Id;
    private String Name;

    public Users(){
        //this constructor is required
    }

    public Users(String Name, String Id) {
        this.Id = Id;
        this.Name = Name;

    }

    public String getUserId() {
        return Id;
    }

    public String getUserName() {
        return Name;
    }


}
