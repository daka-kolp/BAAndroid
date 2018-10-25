package com.brainacad.hometask18.classes;

import com.squareup.picasso.Picasso;

import retrofit2.http.Url;

public class Product {


    private int id;
    private String title;
    private String image;
    private String text;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
