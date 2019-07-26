package com.example.handaejeon.data;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    public static final String API_URI = "https://fc549022.ngrok.io/";

    @FormUrlEncoded
    @POST("user/user/")
    Call<JsonObject> Singup (@Field("username") String username,
                             @Field("email") String email,
                             @Field("password") String password1,
                             @Field("ranking") int ranking,
                             @Field("point") int point);


    @FormUrlEncoded
    @POST("api-token-auth/")
    Call<JsonObject> login (@Field("email") String email,
                             @Field("password") String password);

    @POST("user/main")
    Call<JsonObject> mypage (@Query("username") String username);
}
