package com.example.practiceproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSkillScores {

    @GET("/api/skilliq")
    Call<SkillScores> getSkillScores();
}
