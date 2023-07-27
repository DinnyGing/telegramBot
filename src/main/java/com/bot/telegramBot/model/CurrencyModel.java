package com.bot.telegramBot.model;

import lombok.Data;

import java.util.List;

@Data
public class CurrencyModel {
    int dt;
    int sunrise;
    int sunset;
    double temp;
    double feels_like;
    int pressure;
    int humidity;
    int clouds;
    int visibility;
    double wind_speed;
    List<Weather> weathers;


    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public void setTemp(double temp) {
        this.temp = temp - 273.15;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like - 273.15;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    @Override
    public String toString() {
        StringBuilder weatherStr = new StringBuilder();
        for (Weather weather: weathers){
            weatherStr.append(weather.toString());
        }
        return "Current temperature is " + (int)temp +
                ", but feels like " + (int)feels_like +
                ". Pressure is " + pressure +
                " and humidity is " + humidity +
                ". Percent of clouds is " + clouds +
                " and visibility is " + visibility +
                ". In the end wind speed is " + wind_speed +
                ". " + weatherStr;
    }
}
