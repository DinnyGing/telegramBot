package com.bot.telegramBot.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class City {
    String name;
    Double lat;
    Double lon;

    public City(String name) {
        this.name = name;
        setLatLon();
    }
    private void setLatLon(){
        String apiUrl = "http://api.openweathermap.org/geo/1.0/direct?q=" + name + "&appid=e7704bc895b4a8d2dfd4a29d404285b6";
        JsonParser jsonParser = new JsonParser();
        JsonArray array = jsonParser.parse(Connection.getJson(apiUrl)).getAsJsonArray();
        if(!array.isEmpty()){
            JsonObject jsonObject = array.get(0).getAsJsonObject();
            this.lat = jsonObject.getAsJsonPrimitive("lat").getAsDouble();
            this.lon = jsonObject.getAsJsonPrimitive("lon").getAsDouble();
        }
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
