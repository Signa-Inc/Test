package com.example.mymassager;

public class User
{
    private String uId;
    private String name;
    private String email;
    private String imageUrl;
    private String Status; //Онлайн или нет

    public User() {}

    public User(String uId, String name, String email, String imageUrl, String status) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        Status = status;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
