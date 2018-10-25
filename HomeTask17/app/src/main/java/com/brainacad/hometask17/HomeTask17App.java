package com.brainacad.hometask17;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeTask17App extends Application {

    private static HomeTask17App appInstance;
    private ApiService service;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }


    public static HomeTask17App getAppInstance() {
        return appInstance;
    }

    public ApiService getService() {
        return service;
    }
}
