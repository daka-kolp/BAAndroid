package com.brainacad.apptask17;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceInterface {
    @GET("users/{userId}")
    Call<ResponseBody> getUser(@Path("userId") int userId);
}
