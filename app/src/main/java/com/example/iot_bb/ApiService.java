package com.example.iot_bb;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("getJson.php")
    Call<ResponseBody> getJsonData(@Query("param") String param);
}
