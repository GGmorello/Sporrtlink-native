package com.example.sportlink.ui.dashboard;

import android.graphics.drawable.Drawable;

public class Person {
    private String name;
    private String age;
    private int[] images;
    private String distance;
    private String[] interests;
    private String biography;
    private String achievements;

    public Person(String name, String age, int[] images, String distance, String[] interests, String biography, String achievements) {
        this.name = name;
        this.age = age;
        this.images = images;
        this.distance = distance;
        this.interests = interests;
        this.biography = biography;
        this.achievements = achievements;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int[] getImages() {
        return images;
    }

    public String getDistance() {
        return distance;
    }

    public String[] getInterests() {
        return interests;
    }

    public String getBiography() {
        return biography;
    }

    public String getAchievements() {
        return achievements;
    }
}

