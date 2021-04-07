package com.ubicov.app.controller;

import com.ubicov.app.domain.Furlough;
import com.ubicov.app.service.FurloughService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FurloughController {

    private FurloughService furloughService;

    public FurloughController(FurloughService furloughService) {
        this.furloughService = furloughService;
    }

    @GetMapping("/furlough/{district}")
    private Furlough getFurlough(@PathVariable String district) {
        return furloughService.getFurloughByDistrictAndDate(district);
    }

}
