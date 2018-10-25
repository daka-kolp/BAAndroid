package com.brainacad.hometask17;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
/*    @GET("users")
    Call<ResponseBody> getUsers();
    */
    @GET("users")
    Call<List<User>> getUsers();

    @POST("posts")
    Call<Post> makePost(@Body Post post);

}
