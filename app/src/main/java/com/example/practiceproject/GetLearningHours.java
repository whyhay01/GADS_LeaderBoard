package com.example.practiceproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetLearningHours {

    @GET("/api/hours")
    Call<List<LearningHours>> getLearningHours();
}
