package com.soniyaprojects.onlinestoreapp.webservice.Retrofit;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.soniyaprojects.onlinestoreapp.webservice.ClientServiceListener;
import com.soniyaprojects.onlinestoreapp.webservice.DTOs.BaseRequest;
import com.soniyaprojects.onlinestoreapp.webservice.DTOs.HttpError;
import com.soniyaprojects.onlinestoreapp.webservice.Implementation;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitImplementation extends Implementation{

    private static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    // Private Variables
    private Class responseClass;
    private ClientServiceListener clientServiceListener;


    // Private Methods
    private Object parseJSONResponse(String jsonString) throws JsonSyntaxException {
        return new GsonBuilder().setDateFormat(DATE_FORMAT_DEFAULT).create().fromJson(jsonString, responseClass);
    }

    /**
     * Convert the response received to the response class and send it back
     *
     * @param response Response object received from the server
     */
    private void processResponse(Response<ResponseBody> response) {
        String jsonResponseString = null;

        try {
            if (response.isSuccessful()) {
                //Success 200-299
                jsonResponseString = response.body().string();

                Object responseObject = parseJSONResponse(jsonResponseString);

                if (clientServiceListener != null) {
                    clientServiceListener.didCompleteRequest(responseObject, null);
                }
            } else {
                // Failure - 400-499
                // Map the error response body
                jsonResponseString = response.errorBody().string();
                Object responseObject = parseJSONResponse(jsonResponseString);
                if (clientServiceListener != null) {
                    HttpError error = new HttpError(HttpError.HttpStatus.fromInt(response.code()), response.message());

                    clientServiceListener.didCompleteRequest(responseObject, error);
                }
            }
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
            if (clientServiceListener != null) {
                clientServiceListener.didCompleteRequest(null, new HttpError(HttpError.HttpStatus.UNKNOWN_ERROR, "An error occured while processing the request"));
            }
        }
    }

    /**
     * Execute the service call
     *
     * @param baseDTOCall The call instance to enqueue
     */
    private void execute(Call<ResponseBody> baseDTOCall) {

        baseDTOCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                processResponse(response);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Exception exception = new Exception(t);
                if (clientServiceListener != null) {
                    if (t instanceof SocketException ||
                            t instanceof UnknownHostException ||
                            t instanceof SocketTimeoutException ||
                            t instanceof IOException ) {
                        HttpError error = new HttpError(HttpError.HttpStatus.NOT_REACHABLE, "Unable to find network connection.");
                        clientServiceListener.didCompleteRequest(null, error);
                    } else {
                        HttpError error = new HttpError(HttpError.HttpStatus.UNKNOWN_ERROR, exception.getLocalizedMessage());
                        clientServiceListener.didCompleteRequest(null, error);
                    }
                }
            }
        });

    }

    @Override
    public Call<ResponseBody> request(String baseURL, String endpointURL, RequestMethod requestMethod, BaseRequest request, HashMap<String, String> requestHeaders, HashMap<String, String> queryParams, Class responseClass, ClientServiceListener clientServiceListener) {
        this.clientServiceListener = clientServiceListener;
        this.responseClass = responseClass;

        // Create a Retrofit instance and append headers if required
        Retrofit retrofit = new RetrofitClient().getRetrofit(baseURL, requestHeaders);

        // Create a RetrofitInterface instance
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<ResponseBody> call = null;

        // Query parameter's list should not be sent null
        if (queryParams == null) {
            queryParams = new HashMap<>();
        }

        switch (requestMethod) {
            case GET:
                call = retrofitInterface.requestGET(endpointURL, queryParams);
                break;
            case POST:
                call = retrofitInterface.requestPOST(endpointURL, queryParams, request);
                break;

        }
        if (call != null) {
            this.execute(call);
        }

        return call;
    }
}
