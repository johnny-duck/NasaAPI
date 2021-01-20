package com.devmind.nasa.project;

import java.util.Collections;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PingController {

    @RequestMapping(path = "/ping", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public java.util.Map<String, Object> get() {
        return Collections.singletonMap("ping", "pong");
    }
}


