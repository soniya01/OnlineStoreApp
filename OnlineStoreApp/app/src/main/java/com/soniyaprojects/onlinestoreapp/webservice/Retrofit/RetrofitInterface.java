package com.soniyaprojects.onlinestoreapp.webservice.Retrofit;

import com.soniyaprojects.onlinestoreapp.webservice.DTOs.BaseRequest;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

    @GET("{endpoint}")
    Call<ResponseBody> requestGET(@Path(value = "endpoint", encoded = true) String endpoint, @QueryMap Map<String, String> options);

    @POST("{endpoint}")
    Call<ResponseBody> requestPOST(@Path(value = "endpoint", encoded = true) String endpoint, @QueryMap Map<String, String> options, @Body BaseRequest baseRequest);
}
