package com.example.iot_bb;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    // Api Call with Retrofit to get Json data
//    @GET("getJson.php")
//    Call<List<DataItem>> getDataItems();

    @GET("getJson.php")
    Call<ResponseBody> getJsonData(@Query("param") String param);
}
