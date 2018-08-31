package com.dakakolp.apptask7;

import java.util.ArrayList;
import java.util.List;

public class ColorRes {

    private int resourceColor;
    private String resourceName;


    public static List<ColorRes> createList(){

        List<ColorRes> list = new ArrayList<ColorRes>();
        list.add(new ColorRes(R.color.Red, "Red"));
        list.add(new ColorRes(R.color.Pink, "Pink"));
        list.add(new ColorRes(R.color.Orange, "Orange"));
        list.add(new ColorRes(R.color.Yellow, "Yellow"));
        list.add(new ColorRes(R.color.DarkGreen, "DarkGreen"));
        list.add(new ColorRes(R.color.LightGreen, "LightGreen"));
        list.add(new ColorRes(R.color.LightBlue, "LightBlue"));
        list.add(new ColorRes(R.color.DarkBlue, "DarkBlue"));
        list.add(new ColorRes(R.color.Purple, "Purple"));
        list.add(new ColorRes(R.color.Grey, "Grey"));
        list.add(new ColorRes(R.color.Black, "Black"));

        return list;
    }

    public ColorRes(int resourceColor, String resourceName) {
        this.resourceColor = resourceColor;
        this.resourceName = resourceName;
    }

    public int getResourceColor() {
        return resourceColor;
    }

    public void setResourceColor(int resourceColor) {
        this.resourceColor = resourceColor;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
