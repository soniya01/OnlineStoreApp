package com.soniyaprojects.onlinestoreapp.webservice;

import android.content.Context;
import android.support.annotation.NonNull;

import com.soniyaprojects.onlinestoreapp.webservice.DTOs.BaseResponse;
import com.soniyaprojects.onlinestoreapp.webservice.DTOs.HttpError;
import com.soniyaprojects.onlinestoreapp.webservice.Retrofit.RetrofitImplementation;

import java.util.HashMap;

public abstract class BaseService {

    // Public Variables
    protected Context applicationContext;

    //TODO: make the WebServiceError changes in customer module also
    protected ClientServiceListener clientServiceListener = new ClientServiceListener() {
        @Override
        public void didCompleteRequest(Object object, HttpError httpError) {
            if (httpError == null) {
                // Success 200-299
                if (object != null && object instanceof BaseResponse) {
                    processResponse((BaseResponse) object);
                } else {
//                    if (serviceListener != null) {
//
//                    }
                }
            } else {
                if (object != null && object instanceof BaseResponse) {
                    // Service error - 400 to 499
                    BaseResponse baseResponse = (BaseResponse) object;
                    //Process error if required
                    processError(httpError.getStatusCode(), baseResponse);
                } else {
                    // Network, timeout or internal server errors

//                    if (serviceListener != null) {
//
//                    }
                }
            }
        }
    };


    // Constructor
    protected BaseService(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    // Public Methods
    protected Implementation getImplementation() {
        return new RetrofitImplementation();
    }

    /**
     * Method to set the global headers
     *
     * @return {@link HashMap <String,String>}
     */
    public HashMap<String, String> getGlobalHeaders() {
        HashMap<String, String> headers = new HashMap<>();

        return headers;
    }

    /**
     * Method that will be overridden by the service calls with custom implementation specific to the service call
     */
    abstract public void execute();

    /**
     * Override the method in subclass to include service specific response handling,
     * on receiving success from the server
     *
     * @param object - Response object
     */
    abstract public void processResponse(@NonNull BaseResponse object);

    /**
     * Override the method in subclass to include service specific response handling,
     * on receiving error response object from the server
     *
     * @param baseResponse BaseResponseDTO with the error object set
     */
    public void processError(HttpError.HttpStatus httpStatus, BaseResponse baseResponse) {
        //Check for app version not supported error

//        if (serviceListener != null) {
//            if (baseResponse.getError() != null && baseResponse.getError().getCode() != null) {
//                serviceListener.didCompleteRequest(baseResponse, baseResponse.getError());
//            } else if (httpStatus != null) {
//                serviceListener.didCompleteRequest(baseResponse, new WebServiceError(httpStatus == HttpError.HttpStatus.NOT_REACHABLE ? AppError.AppErrorCode.ERROR_NOT_REACHABLE : AppError.AppErrorCode.UNKNOWN_ERROR, ""));
//            } else {
//                serviceListener.didCompleteRequest(baseResponse, new WebServiceError(AppError.AppErrorCode.UNKNOWN_ERROR, ""));
//            }
//        }
    }
}
