package com.dakakolp.apptask7;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

public class ColorManager {

    private int colorResource;
    private Context context;

    public ColorManager(Context context) {
        this.context = context;
    }

    public int getColorRed() {

        Resources resources = context.getResources();
        colorResource = resources.getColor(R.color.Red);
        return colorResource;
        
    }

    public void getSomethingFromContext(){

    }

}
