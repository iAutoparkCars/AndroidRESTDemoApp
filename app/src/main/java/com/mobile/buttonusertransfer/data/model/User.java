package com.mobile.buttonusertransfer.data.model;

/**
 * Created by Steven on 3/13/2018.
 */

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mobile.buttonusertransfer.BR;

/*
    This User class is
        1. used to build the JSON request body for GET and POST
        2. parse the data from the JSON response body for GET
        3. data-bind (one-way) POJO  -> UI in the recycler view
        4. data-bind (two-way) POJO <-> UI when the user enters email/name, POJO is reactively updated
*/
public class User extends BaseObservable{

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("candidate")
    @Expose
    private String candidate;

    int balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public User(String name, String email, String candidate){
        this.name = name;
        this.email = email;
        this.candidate = candidate;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", candidate='" + candidate + '\'' +
                '}';
    }
}