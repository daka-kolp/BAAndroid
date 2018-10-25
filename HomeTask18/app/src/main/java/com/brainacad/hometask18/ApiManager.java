package com.brainacad.hometask18;

import com.brainacad.hometask18.classes.Comment;
import com.brainacad.hometask18.classes.Product;
import com.brainacad.hometask18.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class ApiManager {
    public interface OnServerResponse{
        void onRegisterUserResponse();
    }

    public void registerUser(final User user) {
        Call<User> callRegUser = HomeTask18App.getAppInstance().getService().registerUser(user);
        callRegUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User u = response.body();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }


    public void getTokenForLogin(User user){
        Call<>
    }


    public List<Product> getProductList(){

        return null;
    }


    public void postCommentAboutProduct(int product_id){

    }


    public Comment getCommetsAboutProduct(int product_id){


        return null;
    }
}
