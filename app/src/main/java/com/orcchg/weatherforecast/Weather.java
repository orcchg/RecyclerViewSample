package com.orcchg.weatherforecast;

public class Weather {
    private String mForecast;

    public Weather(String forecast) {
        mForecast = forecast;
    }

    public String getForecast() {
        return mForecast;
    }
}
