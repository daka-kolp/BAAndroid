package com.brainacad.apptask17;

import android.support.annotation.NonNull;
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


    public void getUser(int userId, final OnServerResponse onServerResponse) {

        Call<User> call = AppTask16App.getAppInstance().getApiService().getUser(userId);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                User object = null;
                //вытащить и положить в юзера
//                try {
                    object = response.body();

                    /*
                    String strResponse = response.body().string();
                    object = new JSONObject(strResponse);

                    User user = new User();
                    User.Address address = user.new Address();
                    User.Address.Geo geo = address.new Geo();
                    User.Company company = user.new Company();

                    int id = object.getInt("id");
                    String name = object.getString("name");
                    String username = object.getString("username");
                    String email = object.getString("email");

                    JSONObject objAddress = object.getJSONObject("address");
                    String street = objAddress.getString("street");
                    String suite = objAddress.getString("suite");
                    String city = objAddress.getString("city");
                    String zipcode = objAddress.getString("zipcode");

                    JSONObject objGeo = objAddress.getJSONObject("geo");
                    String lat = objGeo.getString("lat");
                    String lng = objGeo.getString("lng");

                    String phone = object.getString("phone");
                    String website = object.getString("website");

                    JSONObject objComp = object.getJSONObject("company");
                    String nameComp = objComp.getString("name");
                    String catchPhrase = objComp.getString("catchPhrase");
                    String bs = objComp.getString("bs");


                    user.setIdStr(id);
                    user.setName(name);
                    user.setUsername(username);
                    user.setEmail(email);

                    geo.setLat(lat);
                    geo.setLng(lng);

                    address.setStreet(street);
                    address.setSuite(suite);
                    address.setCity(city);
                    address.setZipcode(zipcode);
                    address.setGeo(geo);
                    user.setAddress(address);

                    user.setPhone(phone);
                    user.setWebsite(website);

                    company.setCompanyName(nameComp);
                    company.setCatchPhrase(catchPhrase);
                    company.setBs(bs);
                    user.setCompany(company);
*/
                    onServerResponse.onServerUserResponse(object);


/*                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
                Log.i("tag", "onResponse: " + object);
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

            }
        });
    }


}
