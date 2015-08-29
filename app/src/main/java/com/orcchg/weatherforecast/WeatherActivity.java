package com.orcchg.weatherforecast;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class WeatherActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity_layout);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.weather_activity_list_container, ListFragment.newInstance()).commit();
    }
}
