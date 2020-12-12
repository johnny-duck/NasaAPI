package com.devmind.nasa.project.service.planet;

import java.io.IOException;
import java.util.Optional;

import com.devmind.nasa.project.utils.OkHttpResponseWrapper;
import com.devmind.nasa.project.utils.OkHttpWrapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarsService {

    @Autowired
    private OkHttpWrapper okHttpWrapper;

    public String checkAsteroids() throws IOException {

        Request request = new Request.Builder()
                .url("http://www.neowsapp.com/rest/v1/feed?start_date=2020-12-12&end_date=2020-12-13&detailed=false&api_key=8LnbQBEJ4L1XBqYQnxbqRRhJzOVxLJpXmzWe9vDE")
                .build();
        Optional<OkHttpResponseWrapper> okHttpResponseWrapper = okHttpWrapper.doCall(request);
        return okHttpResponseWrapper.get().getJsonBody();

    }
}
