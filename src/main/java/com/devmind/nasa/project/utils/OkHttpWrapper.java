package com.devmind.nasa.project.utils;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OkHttpWrapper {

    protected final OkHttpClient httpClient;

    @Autowired
    public OkHttpWrapper(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Optional<OkHttpResponseWrapper> doCall(Request request) {

        String url = request.url().toString();
        String method = request.method();

        try {
            Response response = httpClient.newCall(request).execute();
            String jsonResponse = "";
            int responseCode = response.code();
            if (response.body() != null) {
                jsonResponse = response.body().string();
            }
            return Optional.of(new OkHttpResponseWrapper(HttpStatus.valueOf(responseCode), jsonResponse));
        } catch (Exception e) {
            log.error(": call failed, url: " + method + " " + url, e);
            return Optional.empty();
        }
    }

}
