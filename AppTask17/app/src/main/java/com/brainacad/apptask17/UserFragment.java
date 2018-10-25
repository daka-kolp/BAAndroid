package com.brainacad.apptask17;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class UserFragment extends Fragment {

//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//
//    private String mParam1;
//    private String mParam2;

    private TextView id;
    private TextView name;
    private TextView username;
    private TextView email;
    private TextView addressStreet;
    private TextView addressSuite;
    private TextView addressCity;
    private TextView addressZipcode;
    private TextView geoLat;
    private TextView geoLng;
    private TextView phone;
    private TextView website;
    private TextView companyName;
    private TextView companyCatchPhrase;
    private TextView companyBs;



    private User user;
    private OnFragmentInteractionListener mListener;

    public static UserFragment newInstance(User user) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putSerializable("User", user);
        fragment.setArguments(args);
        return fragment;
    }

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (User)getArguments().getSerializable("User");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        id = view.findViewById(R.id.id);
        name = view.findViewById(R.id.name);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        addressStreet = view.findViewById(R.id.street);
        addressCity = view.findViewById(R.id.city);
        addressSuite = view.findViewById(R.id.suite);
        addressZipcode = view.findViewById(R.id.zipcode);
        geoLat = view.findViewById(R.id.lat);
        geoLng = view.findViewById(R.id.lng);
        phone = view.findViewById(R.id.phone);
        website = view.findViewById(R.id.website);
        companyName = view.findViewById(R.id.nameComp);
        companyCatchPhrase = view.findViewById(R.id.catchPhrase);
        companyBs = view.findViewById(R.id.bs);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        id.setText(String.valueOf(user.getIdStr()));
        name.setText(user.getName());
        username.setText(user.getUsername());
        email.setText(user.getEmail());
        addressStreet.setText(user.getAddress().getStreet());
        addressSuite.setText(user.getAddress().getSuite());
        addressZipcode.setText(user.getAddress().getZipcode());
        addressCity.setText(user.getAddress().getCity());
        geoLat.setText(user.getAddress().getGeo().getLat());
        geoLng.setText(user.getAddress().getGeo().getLng());
        phone.setText(user.getPhone());
        website.setText(user.getWebsite());
        companyName.setText(user.getCompany().getCompanyName());
        companyCatchPhrase.setText(user.getCompany().getCatchPhrase());
        companyBs.setText(user.getCompany().getBs());
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
