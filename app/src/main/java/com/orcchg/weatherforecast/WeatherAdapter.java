package com.orcchg.weatherforecast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<Weather> mWeatherArray;

    public WeatherAdapter() {
        mWeatherArray = new ArrayList<Weather>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_adapter_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherArray.get(position).getForecast());
    }

    @Override
    public int getItemCount() {
        return mWeatherArray.size();
    }

    public Weather getItem(int position) { return mWeatherArray.get(position); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mWeatherTextView;

        ViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.weather_adapter_row_weather_textview);
        }
    }

    public void add(Weather item) {
        mWeatherArray.add(item);
    }

    public void add(Weather[] items) {
        mWeatherArray.addAll(Arrays.asList(items));
    }
}
