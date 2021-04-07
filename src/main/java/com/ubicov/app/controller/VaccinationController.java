package com.ubicov.app.controller;


import com.ubicov.app.domain.Vaccination;
import com.ubicov.app.service.VaccinationService;
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

}
