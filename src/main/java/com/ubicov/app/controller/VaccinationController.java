/**
 * @Author - Richard Renaud, Urmila Mathew
 * Exposes vaccination endpoints and produces data in JSON format.
 * <p>
 * This will be used to match OTHER DATA with geo-locational information.
 */
package com.ubicov.app.controller;


import com.ubicov.app.domain.Vaccination;
import com.ubicov.app.service.VaccinationService;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VaccinationController {
    private VaccinationService vaccinationService;


    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }


    @GetMapping("/vaccination/{district}/{date}")
    private Vaccination getVaccinationByDistrictAndDate(@PathVariable String district, @PathVariable String date) {
        return vaccinationService.getVaccinationByDistrictAndDate(district, date);
    }

    @GetMapping("/vaccination/")
    private List<Vaccination> findAll() {
        return vaccinationService.getAllVaccinations();
    }

    @GetMapping("/mapinfo/vaccination/{district}/{date}")
    private MapInfo getVaccinationMapinfoByDistrict(@PathVariable String district, @PathVariable String date) {
        return vaccinationService.getFurloughMapinfoByDistrict(district, date);
    }
}
