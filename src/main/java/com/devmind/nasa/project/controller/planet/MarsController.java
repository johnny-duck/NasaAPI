package com.devmind.nasa.project.controller.planet;

import java.io.IOException;

import com.devmind.nasa.project.service.planet.MarsService;
import com.devmind.nasa.project.utils.OkHttpResponseWrapper;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mars")
public class MarsController {

    @Autowired
    private MarsService marsService;

    @GetMapping("/checkAsteroids")
    public String checkAsteroids() throws IOException {
        return marsService.checkAsteroids();
    }

}
