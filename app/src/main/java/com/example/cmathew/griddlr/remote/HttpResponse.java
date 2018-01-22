package com.example.cmathew.griddlr.remote;

import java.net.HttpURLConnection;

public class HttpResponse {
    private String data;
    private int code;

    public HttpResponse(String data, int code) {
        this.data = data;
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccessfull() {
        return code >= HttpURLConnection.HTTP_OK &&
                code <= HttpURLConnection.HTTP_PARTIAL;
    }

    public boolean isClientError() {
        return code >= HttpURLConnection.HTTP_BAD_REQUEST &&
                code <= HttpURLConnection.HTTP_UNSUPPORTED_TYPE;
    }

    public boolean isServerError() {
        return code >= HttpURLConnection.HTTP_INTERNAL_ERROR;
    }
}
