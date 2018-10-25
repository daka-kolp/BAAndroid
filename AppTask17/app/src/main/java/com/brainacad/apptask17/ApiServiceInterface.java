package com.brainacad.apptask17;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceInterface {
    @GET("users/{userId}")
    Call<User> getUser(@Path("userId") int userId);


}
