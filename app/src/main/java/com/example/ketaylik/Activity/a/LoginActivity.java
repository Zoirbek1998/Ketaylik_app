package com.example.ketaylik.Activity.a;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ketaylik.Activity.a.Response.RegisterResponse;
import com.example.ketaylik.Activity.a.netWork.ApiClient;
import com.example.ketaylik.Activity.a.netWork.ApiInterface;
import com.example.ketaylik.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    MaterialButton button;
    TextInputEditText PhoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initstatusBar();
        initViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPhone();
            }

        });

    }

    private void sendPhone() {

        String phone = PhoneText.getText().toString();
        if (phone.equals("")) {
            Toast.makeText(this, "Maydon bo'sh", Toast.LENGTH_SHORT).show();
            return;
        }
        Call<RegisterResponse> call = ApiClient.getClient()
                .create(ApiInterface.class).sendPhone(phone);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse = response.body();
                if (registerResponse.isSuccess()) {
                    String phone = registerResponse.getData().getPhone();
                    Intent intent = new Intent(LoginActivity.this, ConfirmActivity.class);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                    finish();
                } else {
                    String message = registerResponse.getMessage();
                    Toast.makeText(LoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String error = t.getMessage();
                Toast.makeText(LoginActivity.this, "" + error, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initViews() {
        button = findViewById(R.id.batton_next);
        PhoneText = findViewById(R.id.Phone_text1);
    }

    private void initstatusBar() {
        if (Build.VERSION.SDK_INT > 23) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}