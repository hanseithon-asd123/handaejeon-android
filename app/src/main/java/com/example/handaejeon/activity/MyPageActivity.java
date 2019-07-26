package com.example.handaejeon.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handaejeon.R;
import com.example.handaejeon.data.ApiClient;
import com.example.handaejeon.data.ApiInterface;
import com.example.handaejeon.model.MypageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPageActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    TextView tv_ranking, tv_point, tv_name, tv_email;
    ProgressBar point_progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        tv_email = findViewById(R.id.tv_email);
        tv_name = findViewById(R.id.tv_name);
        tv_point = findViewById(R.id.tv_point);
        tv_ranking = findViewById(R.id.tv_rank);

        point_progressbar = findViewById(R.id.point_progress);

//        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<JsonObject> call = apiInterface.mypage("asd");
//        call.enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                Log.d("TEEET", "onResponse: " + response.code() + response.toString());
//                if (response.isSuccessful()) {
//
//                    JsonElement element = new JsonParser().parse(response.body().toString())
//                            .getAsJsonObject();
//
//                    MypageInfo info = new Gson().fromJson(element, MypageInfo.class);
//
//
//                    int rank = info.ranking;
//                    int point = info.point;
//                    point_progressbar.setProgress(point);
//                    tv_ranking.setText(rank);
//                    tv_email.setText("asd@asd.com");
//                    tv_name.setText("asd");
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                Log.e("onFailure", t.toString());
//            }
//        });


    }
}
