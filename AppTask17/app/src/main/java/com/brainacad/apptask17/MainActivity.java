package com.brainacad.apptask17;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements UserFragment.OnFragmentInteractionListener{

    private UserFragment userFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiManager apiManager = new ApiManager();

        apiManager.getUser(5, new ApiManager.OnServerResponse() {
            @Override
            public void onServerUserResponse(User user) {

            }
        });

        userFragment = new UserFragment();
        userFragment.setListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, userFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
