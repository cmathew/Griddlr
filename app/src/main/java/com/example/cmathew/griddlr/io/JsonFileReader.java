package com.example.cmathew.griddlr.io;

import android.content.Context;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class JsonFileReader {
    protected Context context;

    public JsonFileReader(Context ctx) {
        this.context = ctx;
    }

    public String read(String assetPath) throws IOException {
        InputStream jsonStream = context.getResources().getAssets().open(assetPath);
        return readInputStream(jsonStream);
    }

    private String readInputStream(InputStream jsonStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(jsonStream, "UTF-8"));

        StringBuilder buf = new StringBuilder();
        String str;
        while ((str = in.readLine()) != null) {
            buf.append(str);
        }
        in.close();

        return buf.toString();
    }
}
