/**
 * @Author - Richard Renaud, Urmila Mathew, Carmen Lara
 * Exposes covid endpoints and produces data in JSON format.
 * <p>
 * This will be used to match OTHER DATA with geo-locational information.
 */
package com.ubicov.app.controller;

import com.ubicov.app.domain.CovidData;
import com.ubicov.app.service.CovidDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidDataController {

    private CovidDataService covidDataService;

    public CovidDataController(CovidDataService covidDataService) {
        this.covidDataService = covidDataService;
    }


    @GetMapping("/covid/{district}")
    private CovidData getCovidByDistrict(@PathVariable String district) {
        return covidDataService.getCovidDataByDistrict(district);
    }

}
