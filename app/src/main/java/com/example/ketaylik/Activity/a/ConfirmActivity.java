package com.example.ketaylik.Activity.a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ketaylik.Activity.a.Response.ConfirmResponse;
import com.example.ketaylik.Activity.a.netWork.ApiClient;
import com.example.ketaylik.Activity.a.netWork.ApiInterface;
import com.example.ketaylik.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmActivity extends AppCompatActivity {
    MaterialButton button;
    TextInputEditText SmsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        initstatusBar();
        initViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms();
            }

        });

    }

    private void sendSms() {
        String phone = getIntent().getStringExtra("phone");
        String sms = SmsText.getText().toString();
        if (sms.equals("")) {
            Toast.makeText(this, "Maydon bo'sh", Toast.LENGTH_SHORT).show();
            return;
        }
        Call<ConfirmResponse> call = ApiClient.getClient()
                .create(ApiInterface.class).sendSms(phone, sms);
        call.enqueue(new Callback<ConfirmResponse>() {
            @Override
            public void onResponse(Call<ConfirmResponse> call, Response<ConfirmResponse> response) {
                ConfirmResponse confirmResponse = response.body();
                if (confirmResponse.isSuccess()) {
                    String token = confirmResponse.getData().getToken();
                    saveToken(token);

                }
            }

            @Override
            public void onFailure(Call<ConfirmResponse> call, Throwable t) {
                String error = t.getMessage();
                Toast.makeText(ConfirmActivity.this, "" + error, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void saveToken(String token) {
        SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
        editor.putString("Token", token);
        editor.apply();
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    private void initViews() {
        button = findViewById(R.id.batton_next);
        SmsText = findViewById(R.id.Phone_text1);

    }

    private void initstatusBar() {
        if (Build.VERSION.SDK_INT > 23) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}
