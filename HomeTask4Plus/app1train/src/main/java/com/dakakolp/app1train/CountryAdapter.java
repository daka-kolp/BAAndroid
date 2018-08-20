package com.dakakolp.app1train;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.dakakolp.app1train.addedclass.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countries;

    public CountryAdapter(List<Country> countries) {
        this.countries = countries;
    }


    public CountryAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.outline_country, null);
        return new CountryViewHolder(view);
    }

    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.flagImage.setImageResource(country.getFlag());
        holder.nameTxt.setText(country.getName());
        holder.capitalTxt.setText(country.getCapital());
        holder.populationTxt.setText(String.format("%.2f", country.getPopulation()));
    }

    public int getItemCount() {
        return countries.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {

        private CardView cv;
        private ImageView flagImage;
        private TextView nameTxt;
        private TextView capitalTxt;
        private TextView populationTxt;

        CountryViewHolder(View v) {
            super(v);
            cv = v.findViewById(R.id.country_card_view);
            flagImage = v.findViewById(R.id.country_flag);
            nameTxt = v.findViewById(R.id.country_name);
            capitalTxt = v.findViewById(R.id.country_capital);
            populationTxt = v.findViewById(R.id.country_population);
        }
    }

}
