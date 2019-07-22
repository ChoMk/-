package com.mksoft.followlistpagesample;

import androidx.annotation.NonNull;

import java.util.Date;

public class UserData {


    private Integer id = 0;


    private String userId="";

    @NonNull
    private String username = "";





    private String email = "";


    private String userImageUrl="";


    private String website = "";

    private String phoneNumber = "";

    private String gender = "";



    private Date lastRefresh = null;

    public UserData(@NonNull Integer id, @NonNull String userId, @NonNull String username, String email, String userImageUrl, String website, String phoneNumber, String gender, Date lastRefresh) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.userImageUrl = userImageUrl;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.lastRefresh = lastRefresh;
    }

    public UserData() {
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userImageUrl='" + userImageUrl + '\'' +
                ", website='" + website + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", lastRefresh=" + lastRefresh +
                '}';
    }



}
