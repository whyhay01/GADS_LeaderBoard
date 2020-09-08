package com.example.practiceproject;

import com.google.gson.annotations.SerializedName;

public class LearningHours {

    @SerializedName("name")
    private String name;

    @SerializedName("hours")
    private int hours;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String learningBadge;

    public LearningHours(String name, int hours, String country, String learningBadge) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.learningBadge = learningBadge;
    }


    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getLearningBadge() {
        return learningBadge;
    }
}
