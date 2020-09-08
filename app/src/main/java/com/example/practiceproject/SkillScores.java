package com.example.practiceproject;

import com.google.gson.annotations.SerializedName;

public class SkillScores {


    @SerializedName("score")
    private int score;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String badgeUrl;

    public SkillScores(int score, String name, String country, String badgeUrl) {
        this.score = score;
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
