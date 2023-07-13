package com.example.iot_bb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView txtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = (TextView) findViewById(R.id.txtData);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app-cm-jec.lolipop.io/iot/")
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        String param = "CM07";

        Button btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.getJsonData(param).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            ResponseBody jsonData = response.body();
                            try {
                                txtData.setText(jsonData.string());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        } else {
                            // Handle API call failure
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // Handle network or API call failure
                    }
                });


            }
        });




    }
}