package com.ubicov.app.controller;


import com.ubicov.app.domain.Deprivation;
import com.ubicov.app.service.DeprivationService;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeprivationController {
    private DeprivationService deprivationService;


    public DeprivationController(DeprivationService deprivationService) {
        this.deprivationService = deprivationService;
    }


    @GetMapping("/deprivation/{district}/{date}")
    private Deprivation getDeprivationByDistrictAndDate(@PathVariable String district, @PathVariable String date) {
        return deprivationService.getDeprivationByDistrictAndDate(district, date);
    }
    @GetMapping("/deprivation/{district}/")
    private Deprivation getDeprivationByDistrict(@PathVariable String district) {
        return deprivationService.getDeprivationByDistrict(district);
    }
    @GetMapping("/deprivation/")
    private List<Deprivation> findAll() {
        return deprivationService.getAllDeprivations();
    }


    @GetMapping("/mapinfo/deprivation/{district}/")
    private MapInfo getDeprivationMapinfoByDistrict(@PathVariable String district) {
        return deprivationService.getDeprivationMapinfoByDistrict(district);
    }

}
