package com.soniyaprojects.onlinestoreapp.webservice.DTOs;

public class HttpError {

    private HttpStatus statusCode;
    private String errorMessage;


    public enum HttpStatus {

        UNKNOWN_ERROR(-1),
        NOT_REACHABLE(0),
        STATUS_OK(200),
        BAD_REQUEST(400),
        UNAUTHORISED(401),
        INTERNAL_SERVER_ERROR(500);

        private int _value;

        HttpStatus(int Value) {
            this._value = Value;
        }

        public int getValue() {
            return _value;
        }

        public static HttpStatus fromInt(int intValue) {
            for (HttpStatus httpStatus : HttpStatus.values()) {
                if (httpStatus.getValue() == intValue) { return httpStatus; }
            }
            return UNKNOWN_ERROR;
        }
    }

    public HttpError(HttpStatus statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
