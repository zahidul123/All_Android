package com.example.reglogimginfirebasewithimg;

public class profile
{

        private String name;
        private String email;
       private String phone;
       private String profilePic;


    public profile() {
    }

    public profile(String name, String email, String phone, String profilePic) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profilePic = profilePic;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


}
