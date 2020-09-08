package com.example.practiceproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSkillScores {

    @GET("/api/skilliq")
    Call<List<SkillScores>> getSkillScores();
}
