package com.soniyaprojects.onlinestoreapp.webservice;

import com.soniyaprojects.onlinestoreapp.webservice.DTOs.BaseRequest;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;

public abstract class Implementation {

    public enum RequestMethod {
        POST,
        GET
    }

    /**
     * Method for base getDeliveriesOfType
     *
     * @param baseURL               Server base URL
     * @param endpointURL           Endpoint path URL
     * @param requestMethod         Type of getDeliveriesOfType
     * @param request               Request object to POST/PUT
     * @param requestHeaders        List key-value to add as request headers
     * @param queryParams           List key-value to add as query parameters
     * @param responseClass         Class to which the response should be matched to
     * @param clientServiceListener Listener to notify once the service getDeliveriesOfType is complete
     */
    public Call<ResponseBody> request(String baseURL,
                                      String endpointURL,
                                      RequestMethod requestMethod,
                                      BaseRequest request,
                                      HashMap<String, String> requestHeaders,
                                      HashMap<String, String> queryParams,
                                      Class responseClass,
                                      ClientServiceListener clientServiceListener) {

        return null;
    }

}
