package com.brainacad.apptask17;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppTask16App extends Application {
    private static AppTask16App appInstance;
    private ApiServiceInterface apiService;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        appInstance = this;
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
        apiService = retrofit.create(ApiServiceInterface.class);
        super.onCreate();
    }

    public static AppTask16App getAppInstance() {
        return appInstance;
    }

    public ApiServiceInterface getApiService() {
        return apiService;
    }
}
