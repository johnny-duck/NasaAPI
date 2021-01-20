package com.devmind.nasa.project.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class OkHttpResponseWrapper {
    private HttpStatus httpStatus;
    private String jsonBody;

    public boolean isSuccess() {
        return httpStatus.is2xxSuccessful();
    }

    public boolean isConflict() {
        return httpStatus == HttpStatus.CONFLICT;
    }

    public boolean isForbidden() {
        return httpStatus == HttpStatus.FORBIDDEN;
    }

    public boolean isServerError() {
        return httpStatus == HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
