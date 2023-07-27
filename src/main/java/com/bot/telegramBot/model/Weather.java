package com.bot.telegramBot.model;

public class Weather {
    int id;
    String main;
    String description;
    public void setId(int id) {
        this.id = id;
    }
    public void setMain(String main) {
        this.main = main;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Now weather is mainly " + main + ", it's specifically " + description + ". ";
    }
}
