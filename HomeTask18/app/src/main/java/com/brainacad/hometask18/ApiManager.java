package com.brainacad.hometask18;

import com.brainacad.hometask18.classes.Comment;
import com.brainacad.hometask18.classes.Product;
import com.brainacad.hometask18.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Call<User> getToken = HomeTask18App.getAppInstance().getService().getTokenForLogin(user);
        getToken.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


    public void getProductList(){

        Call<List<Product>> callListProduct = HomeTask18App.getAppInstance().getService().getProductList();
        callListProduct.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }


    public void postCommentAboutProduct(int product_id){

        Call<Product> postComment = HomeTask18App.getAppInstance().getService().postCommentAboutProduct(product_id);
        postComment.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }


    public void getCommentsAboutProduct(int product_id){

        Call<List<Comment>> callListComment = HomeTask18App.getAppInstance().getService().getCommentsAboutProduct(product_id);
        callListComment.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });

    }
}
