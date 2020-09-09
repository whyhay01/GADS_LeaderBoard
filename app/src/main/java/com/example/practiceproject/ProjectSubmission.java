package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ProjectSubmission extends AppCompatActivity {

    EditText etFirstName;
    EditText etLastName;
    EditText etEmailAddress;
    EditText etGitLink;
    Button btnSubmit;
    ImageView imgArrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        etFirstName = findViewById(R.id.et_firstName);
        etEmailAddress = findViewById(R.id.et_emailAddress);
        etGitLink = findViewById(R.id.et_githubLink);
        etLastName = findViewById(R.id.et_lastName);
        btnSubmit = findViewById(R.id.btn_submit);
        imgArrowBack = findViewById(R.id.arrow_back);

        imgArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}