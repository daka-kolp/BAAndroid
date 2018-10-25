package com.brainacad.hometask17;


import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {

    public interface OnServerResponse {
        void onServerUsersResponse(List<User> users);
    }


    public void makePost(final Post post){
        Call<Post> call = HomeTask17App.getAppInstance().getService().makePost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                if (post != null) {
                    Log.i("TAG", "onResponse: " + post.getId());

                    if(post.getBody() != null){

                    }
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void getUsers(final OnServerResponse onServerResponse) {

        Call<List<User>> call = HomeTask17App.getAppInstance().getService().getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                List<User> users = response.body();
                onServerResponse.onServerUsersResponse(users);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}


/*    public void getUsers(final OnServerResponse onServerResponse) {

        Call<ResponseBody> call = HomeTask17App.getAppInstance().getService().getUsers();
        call.enqueue(new Callback<ResponseBody>() {
            @SuppressLint("NewApi")
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


            }
                JSONArray array = null;
                try {
                    List<User> userList = new ArrayList<User>();
                    array = new JSONArray(response.body().string());

                    Log.d("TAG", "onResponse: " + array.length());

                    for (int i = 0; i < array.length(); i++) {
                        User user = new User();
                        User.Address address = user.new Address();
                        User.Address.Geo geo = address.new Geo();
                        User.Company company = user.new Company();

                        int id = array.getJSONObject(i).getInt("id");
                        String name = array.getJSONObject(i).getString("name");
                        String username = array.getJSONObject(i).getString("username");
                        String email = array.getJSONObject(i).getString("email");

                        JSONObject objAddress = array.getJSONObject(i).getJSONObject("address");
                        String street = objAddress.getString("street");
                        String suite = objAddress.getString("suite");
                        String city = objAddress.getString("city");
                        String zipcode = objAddress.getString("zipcode");

                        JSONObject objGeo = objAddress.getJSONObject("geo");
                        String lat = objGeo.getString("lat");
                        String lng = objGeo.getString("lng");

                        String phone = array.getJSONObject(i).getString("phone");
                        String website = array.getJSONObject(i).getString("website");

                        JSONObject objComp = array.getJSONObject(i).getJSONObject("company");
                        String nameComp = objComp.getString("name");
                        String catchPhrase = objComp.getString("catchPhrase");
                        String bs = objComp.getString("bs");


                        user.setIdStr(id);
                        user.setNameStr(name);
                        user.setUsernameStr(username);
                        user.setEmailStr(email);

                        geo.setGeoLatStr(lat);
                        geo.setGeoLngStr(lng);

                        address.setAddressStreetStr(street);
                        address.setAddressSuiteStr(suite);
                        address.setAddressCityStr(city);
                        address.setAddressZipcodeStr(zipcode);
                        address.setGeo(geo);
                        user.setAddress(address);

                        user.setPhoneStr(phone);
                        user.setWebsiteStr(website);

                        company.setCompanyNameStr(nameComp);
                        company.setCompanyCatchPhraseStr(catchPhrase);
                        company.setCompanyBsStr(bs);
                        user.setCompany(company);

                        userList.add(user);
                    }
                    onServerResponse.onServerUsersResponse(userList);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }*/

            /*@Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onServerResponse.onServerUsersResponse(null);
                Log.d("TAG", "onResponse: -----------");
            }
        });*/

