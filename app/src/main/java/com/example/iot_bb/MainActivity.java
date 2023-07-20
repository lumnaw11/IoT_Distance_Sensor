package com.example.iot_bb;

import static com.example.iot_bb.R.id.btnReset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView txtData;
    TextView txtMessage;
    Button btnReset;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = (TextView) findViewById(R.id.txtData);
        txtMessage = (TextView) findViewById(R.id.txtMessage);
        txtMessage.setText("何もない");
        btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMessage.setText("何もない");
            }
        });

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
                            List<DataItem> dataItems = null;
                            try {
                                // convert JSON data to GSON to parse data to DataItem
                                dataItems = new Gson().fromJson(response.body().charStream(), new TypeToken<List<DataItem>>() {}.getType());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (dataItems != null) {
                                // Create a StringBuilder to build the text for TextView
                                StringBuilder textViewText = new StringBuilder();

                                // Get data and timestamp from JSon data
                                for (DataItem dataItem : dataItems) {
                                    double data1 = dataItem.getData1();
                                    String timestamp = dataItem.getCreate_time();
//                                    textViewText.append("Timestamp: ").append(timestamp)
//                                            .append(", Data1: ").append(data1)
//                                            .append("\n");

                                    Log.i("DataItem", "Data1: " + data1 + ", Timestamp: " + timestamp);
                                    if (data1 > 300){
                                        txtMessage.setText(timestamp + "に荷物届いた！");
                                    }
                                }
                                // Set the final text from the StringBuilder to the TextView
//                                txtData.setText(textViewText.toString());
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