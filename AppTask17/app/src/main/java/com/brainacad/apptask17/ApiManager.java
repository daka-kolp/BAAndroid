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

        Call<ResponseBody> call = AppTask16App.getAppInstance().getApiService().getUser(userId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                JSONObject object = null;
                ///вытащить и положить в юзера
                try {
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

                    onServerResponse.onServerUserResponse(user);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("tag", "onResponse: " + object);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {

            }
        });
    }


}
