package com.example.practiceproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmission extends AppCompatActivity {

    EditText etFirstName;
    EditText etLastName;
    EditText etEmailAddress;
    EditText etGitLink;
    Button btnSubmit;
    ImageView imgArrowBack;
    ImageView imgCancel;
    TextView txtYes;
    Dialog submitDialog;

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

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewSubmitDialog();
            }
        });
    }

    public void viewSubmitDialog(){

        submitDialog = new Dialog(this);
        submitDialog.setContentView(R.layout.submit_dialog);
        imgCancel = submitDialog.findViewById(R.id.img_cancel);
        txtYes = submitDialog.findViewById(R.id.txt_yes);

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitDialog.dismiss();
            }
        });

        txtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postResponse(createSubmission());
                submitDialog.dismiss();

            }
        });
        WindowManager.LayoutParams lp = submitDialog.getWindow().getAttributes();
        lp.dimAmount=0.0f;
        submitDialog.getWindow().setAttributes(lp);
        submitDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        submitDialog.show();

    }

    public void submissionSuccessful(){

        submitDialog =new Dialog(this, R.style.DialogTheme);
        submitDialog.setContentView(R.layout.successful_submission);
        submitDialog.show();

    }

    public void submissionFailed(){

        submitDialog =new Dialog(this, R.style.DialogTheme);
        submitDialog.setContentView(R.layout.failed_submission);
        submitDialog.show();

    }

    public UserSubmission createSubmission(){
        UserSubmission userSubmission = new UserSubmission();
        userSubmission.setEmailAddress(etEmailAddress.getText().toString());
        userSubmission.setFirstName(etFirstName.getText().toString());
        userSubmission.setLastName(etLastName.getText().toString());
        userSubmission.setLinkToProject(etGitLink.getText().toString());

        return userSubmission;

    }

    public void postResponse(UserSubmission userSubmission){
        Call<UserSubmissionResponse> userSubmissionResponseCall = RetrofitClientInstance.
                getRetrofitPostInstance().create(SubmissionService.class).postResponse(userSubmission);

        userSubmissionResponseCall.enqueue(new Callback<UserSubmissionResponse>() {
            @Override
            public void onResponse(Call<UserSubmissionResponse> call, Response<UserSubmissionResponse> response) {

                clearField();
                submissionSuccessful();
            }

            @Override
            public void onFailure(Call<UserSubmissionResponse> call, Throwable t) {

                submissionFailed();

            }
        });
    }

    public void clearField(){
        etFirstName.setText("");
        etLastName.setText("");
        etEmailAddress.setText("");
        etGitLink.setText("");
    }
}