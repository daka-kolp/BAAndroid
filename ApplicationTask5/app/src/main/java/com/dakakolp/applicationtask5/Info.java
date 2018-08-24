package com.dakakolp.applicationtask5;

public class Info {
    private int newImage;
    private String newText;

    public Info(int newImage, String newText) {
        this.newImage = newImage;
        this.newText = newText;
    }

    public int getNewImage() {
        return newImage;
    }

    public void setNewImage(int newImage) {
        this.newImage = newImage;
    }

    public String getNewText() {
        return newText;
    }

    public void setNewText(String newText) {
        this.newText = newText;
    }
}
