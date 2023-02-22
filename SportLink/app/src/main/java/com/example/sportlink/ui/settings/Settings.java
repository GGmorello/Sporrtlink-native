package com.example.sportlink.ui.settings;

public class Settings {
    private int sport;
    private String customSport;
    private String gender;
    private int minAge;
    private int maxAge;
    private int distance;

    public static final int MATCHING_SPORTS = -1;
    public static final int ALL_SPORTS = -2;
    public static final int CUSTOM_SPORT = -3;
    public Settings(int sport, String customSport, String gender, int minAge, int maxAge, int distance) {
        this.sport = sport;
        this.customSport = customSport;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.distance = distance;
    }

    public String getGender() {
        return gender;
    }

    public int getMinAge() {
        return minAge;
    }
    public int getMaxAge(){
        return maxAge;
    }
    public int getDistance() {
        return distance;
    }
}