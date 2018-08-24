package com.soniyaprojects.onlinestoreapp.webservice;

import android.content.Context;
import android.support.annotation.NonNull;

import com.soniyaprojects.onlinestoreapp.webservice.DTOs.BaseResponse;
import com.soniyaprojects.onlinestoreapp.webservice.DTOs.OnlineStoreResponse;

public class ProductsWithCategoriesWebservice extends BaseService{
    private String baseURL = "https://stark-spire-93433.herokuapp.com/json/";

    public ProductsWithCategoriesWebservice(Context applicationContext) {
        super(applicationContext);
    }

    @Override
    public void execute() {
        this.getImplementation().request(this.baseURL,
                "",
                Implementation.RequestMethod.GET,
                null,
                getGlobalHeaders(),
                null,
                OnlineStoreResponse.class,
                clientServiceListener);
    }

    @Override
    public void processResponse(@NonNull BaseResponse object) {

    }
}
