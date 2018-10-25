package com.brainacad.hometask18;

import com.brainacad.hometask18.classes.Comment;
import com.brainacad.hometask18.classes.Product;
import com.brainacad.hometask18.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("api/register")
    Call<User> registerUser(@Body User user);

    @POST("api/login")
    Call<User> getTokenForLogin(@Body User user);

    @GET("api/products")
    Call<List<Product>> getProductList();

    @POST("api/reviews/{product_id}")
    Call<Product> postCommentAboutProduct(@Path("product_id") int product_id);

    @GET("api/reviews/{product_id}")
    Call<List<Comment>> getCommentsAboutProduct(@Path("product_id") int product_id);

}

