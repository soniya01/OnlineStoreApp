package com.soniyaprojects.onlinestoreapp.webservice;

import com.soniyaprojects.onlinestoreapp.webservice.DTOs.HttpError;

public interface ClientServiceListener {

    /**
     * Method to notify the calling class about the completion of the data service call
     * @param object The Response DTO received from the server
     * @param httpError The error object notifying the failure
     */
    void didCompleteRequest(Object object, HttpError httpError);
}
