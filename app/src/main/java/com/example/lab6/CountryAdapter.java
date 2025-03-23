package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImageView;
        TextView countryNameView;
        TextView populationView;

        public CountryViewHolder(View itemView) {
            super(itemView);
            flagImageView = itemView.findViewById(R.id.imageView_flag);
            countryNameView = itemView.findViewById(R.id.textView_countryName);
            populationView = itemView.findViewById(R.id.textView_population);
        }
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);

        holder.countryNameView.setText(country.getCountryName());
        holder.populationView.setText("Population: " + country.getPopulation());

        int imageResId = context.getResources().getIdentifier(
                country.getFlagName(),
                "drawable",
                context.getPackageName()
        );
        holder.flagImageView.setImageResource(imageResId);

        holder.itemView.setOnClickListener(v -> {
            String message = "Selected: " + country.getCountryName();
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
