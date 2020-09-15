package com.example.practiceproject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;

    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    private static final String BASE_URL_FORM = "https://docs.google.com/forms/d/e/";

    public static Retrofit getRetrofitInstance(){

//        if (retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
//        }

        return retrofit;
    }

    public static Retrofit getRetrofitPostInstance(){

//        if (retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging).build();
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL_FORM)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
//        }

        return retrofit;
    }

}
