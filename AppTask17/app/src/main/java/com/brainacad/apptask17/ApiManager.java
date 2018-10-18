package com.brainacad.apptask17;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {

    public interface OnServerResponse {
        void onServerUserResponse(User user);
    }


    public void getUser(int userId, OnServerResponse onServerResponse) {

        Call<ResponseBody> call = AppTask16App.getAppInstance().getApiService().getUser(userId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                JSONObject object = null;
                try {
                    String strResponse = response.body().string();
                    object = new JSONObject(strResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("tag", "onResponse: " + object);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}
