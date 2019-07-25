package com.example.handaejeon.data;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    public static final String API_URI = "http://49.236.136.175/";

    @FormUrlEncoded
    @POST("/rest-auth/registration/")
    Call<JsonObject> Singup (@Field("username") String username,
                             @Field("email") String email,
                             @Field("password1") String password1,
                             @Field("password2") String password2);
}
