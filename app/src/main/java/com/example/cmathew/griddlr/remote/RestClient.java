package com.example.cmathew.griddlr.remote;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.cmathew.griddlr.R;
import com.example.cmathew.griddlr.io.JsonFileReader;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class RestClient {
    private static final String LOG_TAG = "RestClient";

    private Uri apiRoot;
    private JsonFileReader fileReader;

    public RestClient(Context ctx) {
        String root = ctx.getString(R.string.api_root_path);
        this.apiRoot = new Uri.Builder().scheme("file").path(root).build();
        this.fileReader = new JsonFileReader(ctx);
    }

    public HttpResponse makeGetRequest(Uri url) {
        Log.v(LOG_TAG, String.format("Making GET request with URL %s", url.toString()));

        try {
            String responseBody = fileReader.read(url.getPath().substring(1));
            return new HttpResponse(responseBody, HttpURLConnection.HTTP_OK);
        } catch (IOException ex) {
            return new HttpResponse(null, HttpURLConnection.HTTP_NOT_FOUND);
        }
    }

    public HttpResponse makePostRequest(Uri uri) {
        Log.v(LOG_TAG, String.format("Making POST request with URL %s", uri.toString()));

        return new HttpResponse(null, HttpURLConnection.HTTP_NO_CONTENT);
    }

    public HttpResponse makePutRequest(Uri uri) {
        Log.v(LOG_TAG, String.format("Making PUT request with URL %s", uri.toString()));

        return new HttpResponse(null, HttpURLConnection.HTTP_NO_CONTENT);
    }

    public Uri getApiRoot() {
        return apiRoot;
    }
}
