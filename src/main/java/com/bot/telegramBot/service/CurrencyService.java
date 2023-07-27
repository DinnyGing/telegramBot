package com.bot.telegramBot.service;

import com.bot.telegramBot.model.City;
import com.bot.telegramBot.model.Connection;
import com.bot.telegramBot.model.CurrencyModel;
import com.bot.telegramBot.model.Weather;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    public static String getCurrencyWeather(String nameCity, CurrencyModel model){
        City city = new City(nameCity);
        if(city.getLat() != null) {
            StringBuilder builder = new StringBuilder("https://api.openweathermap.org/data/2.5/onecall?lat=")
                    .append(city.getLat()).append("&lon=").append(city.getLon()).append("&appid=e7704bc895b4a8d2dfd4a29d404285b6");
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(Connection.getJson(builder.toString())).getAsJsonObject().getAsJsonObject("current");
            model.setDt(jsonObject.get("dt").getAsInt());
            model.setSunrise(jsonObject.get("sunrise").getAsInt());
            model.setSunset(jsonObject.get("sunset").getAsInt());
            model.setTemp(jsonObject.get("temp").getAsDouble());
            model.setFeels_like(jsonObject.get("feels_like").getAsDouble());
            model.setPressure(jsonObject.get("pressure").getAsInt());
            model.setHumidity(jsonObject.get("humidity").getAsInt());
            model.setClouds(jsonObject.get("clouds").getAsInt());
            model.setVisibility(jsonObject.get("visibility").getAsInt());
            model.setWind_speed(jsonObject.get("wind_speed").getAsDouble());
            JsonArray array = jsonObject.getAsJsonArray("weather");
            List<Weather> weathers = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                Weather weather = new Weather();
                JsonObject object = array.get(i).getAsJsonObject();
                weather.setId(object.get("id").getAsInt());
                weather.setMain(object.get("main").getAsString());
                weather.setDescription(object.get("description").getAsString());
                weathers.add(weather);
            }
            model.setWeathers(weathers);
            return model.toString();
        }
        return null;
    }
}
