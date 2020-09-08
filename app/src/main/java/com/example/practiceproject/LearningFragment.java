package com.example.practiceproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningFragment extends Fragment {

    LearningHoursAdapter adapter;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    private String TAG = LearningFragment.class.getSimpleName();

    public static LearningFragment getInstance(){
        LearningFragment learningFragment = new LearningFragment();
        return learningFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learning_leader, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new LearningHoursAdapter(getContext());

        recyclerView = view.findViewById(R.id.rv_learning_leader);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getLearningHours();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();
    }

    private void getLearningHours(){

        GetLearningHours apiLearning = RetrofitClientInstance.getRetrofitInstance().create(GetLearningHours.class);
        Call<List<LearningHours>> call = apiLearning.getLearningHours();
        call.enqueue(new Callback<List<LearningHours>>() {
            @Override
            public void onResponse(Call<List<LearningHours>> call, Response<List<LearningHours>> response) {
                dataBinding(response.body());

                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<LearningHours>> call, Throwable t) {
                Log.v(TAG, "Error fetching learning hours "+t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void dataBinding(List<LearningHours> learningHours) {
        adapter.addLearningHour(learningHours);
    }
}
