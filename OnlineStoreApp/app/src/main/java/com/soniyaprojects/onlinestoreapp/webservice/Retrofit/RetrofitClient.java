package com.soniyaprojects.onlinestoreapp.webservice.Retrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Private Methods

    /**
     * Get Logging Interceptor
     * @return {@link Response}
     */
    private Interceptor getHeaderInterceptor(final HashMap<String, String> requestHeaders) {

        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request.Builder requestBuilder = request.newBuilder();
                for (String key: requestHeaders.keySet()) {
                    requestBuilder.addHeader(key, requestHeaders.get(key));
                }

                return chain.proceed(requestBuilder.build());
            }
        };
    }

    /**
     * Get an instance of Retrofit builder
     * @return {@link Retrofit.Builder}
     */
    private Retrofit.Builder getRetrofitBuilder(String baseURL, HashMap<String, String> requestHeaders) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create());

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(60, TimeUnit.SECONDS);

        // Add headers if required
        if (requestHeaders != null && requestHeaders.size() > 0) {
            httpClientBuilder.addInterceptor(getHeaderInterceptor(requestHeaders));
        }


        builder.client(httpClientBuilder.build());

        return builder;
    }

    /**
     * Get Retrofit object
     * @return Retrofit object
     */
    public Retrofit getRetrofit(String baseURL, HashMap<String, String> requestHeaders) {
        return getRetrofitBuilder(baseURL, requestHeaders).build();
    }
}
