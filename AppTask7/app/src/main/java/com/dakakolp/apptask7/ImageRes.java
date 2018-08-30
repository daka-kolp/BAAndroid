package com.dakakolp.apptask7;

public class ImageRes {

    private int resourceImage;
    private String resourceName;

    public ImageRes(int resourceImage, String resourceName) {
        this.resourceImage = resourceImage;
        this.resourceName = resourceName;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
