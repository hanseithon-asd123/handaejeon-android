package com.example.handaejeon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handaejeon.R;
import com.example.handaejeon.data.ApiClient;
import com.example.handaejeon.data.ApiInterface;
import com.google.gson.JsonObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    @BindView(R.id.edit_id)
    EditText edit_id;
    @BindView(R.id.edit_email) EditText edit_email;
    @BindView(R.id.edit_password1) EditText edit_password1;
    @BindView(R.id.edit_password2) EditText edit_password2;

    @BindView(R.id.text_id)
    TextView text_id;
    @BindView(R.id.text_email) TextView text_email;
    @BindView(R.id.text_password1) TextView text_password1;
    @BindView(R.id.text_password2) TextView text_password2;

    String email = null, id = null, password1 = null, password2 = null;

    // 이메일 정규식
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    // 비밀번호 정규식
    public static final Pattern VALID_PASSWORD_REGEX_ALPHA_NUM = Pattern.compile("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", Pattern.CASE_INSENSITIVE); //8자리+기호까지 가능


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);

    }
    @OnClick(R.id.btn_signup)
    void onclick() {
        id = edit_id.getText().toString();
        email = edit_email.getText().toString();
        password1 = edit_password1.getText().toString();
        password2 = edit_password2.getText().toString();

        if (email.matches("") || id.matches("")
                || password1.matches("") || password2.matches("")) {
            Toast.makeText(this, "빈칸을 채워주세요 :)", Toast.LENGTH_SHORT).show();
            text_password2.setVisibility(View.INVISIBLE);
        } else {
            if (validateEmail(email)) {
                text_email.setVisibility(View.INVISIBLE);
            } else {
                text_email.setVisibility(View.VISIBLE);
            }
            if (validatePassword(password1)) {
                text_password1.setVisibility(View.INVISIBLE);
                if (password1.equals(password2)) {
                    text_password2.setVisibility(View.INVISIBLE);
                    signUp(id,email, password1, password2);
                } else{
                    text_password2.setVisibility(View.VISIBLE);
                }

            } else {
                text_password1.setVisibility(View.VISIBLE);
            }

        }

    }

    @OnClick(R.id.back)
    void BackClick(){
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


    private void signUp(String id, String email, String password1, String password2) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> call = apiInterface.Singup(id, email, password1, password2);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });


    }



    // 이메일 검사
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    // 비밀번호 검사
    public static boolean validatePassword(String pwStr) {
        Matcher matcher = VALID_PASSWORD_REGEX_ALPHA_NUM.matcher(pwStr);
        return matcher.matches();
    }

    public void Login(View view) {
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}

