package com.brainacad.hometask18.classes;

import retrofit2.http.Url;

public class Comment {
    private int id;
    private double rate;
    private int id_user;
    private int id_entry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_entry() {
        return id_entry;
    }

    public void setId_entry(int id_entry) {
        this.id_entry = id_entry;
    }
}
