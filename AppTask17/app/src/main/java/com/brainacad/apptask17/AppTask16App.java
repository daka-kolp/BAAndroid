package com.brainacad.apptask17;

import android.app.Application;

import retrofit2.Retrofit;

public class AppTask16App extends Application {
    private static AppTask16App appInstance;
    private ApiServiceInterface apiService;

    @Override
    public void onCreate() {
        appInstance = this;
        Retrofit retrofit = new Retrofit.Builder()
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
