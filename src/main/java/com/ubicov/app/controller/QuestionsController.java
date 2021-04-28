package com.ubicov.app.controller;

import com.ubicov.app.domain.CovidData;
import com.ubicov.app.domain.Furlough;
import com.ubicov.app.service.*;
import com.ubicov.app.util.geojson.Feature;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionsController {

    ///questions/1

    private VaccinationService vaccinationService;
    private CovidDataService covidDataService;
    private DeprivationService deprivationService;
    private FurloughService furloughService;


    public QuestionsController(VaccinationService vaccinationService, CovidDataService covidDataService, DeprivationService deprivationService, FurloughService furloughService) {
        this.vaccinationService = vaccinationService;
        this.covidDataService = covidDataService;
        this.deprivationService = deprivationService;
        this.furloughService = furloughService;
    }

/**
* Will use CovidData dataset & FurloughData Dataset
*/
    @GetMapping("/questions/{id}")
    public List<MapInfo> question1(@PathVariable int id ){
    //Get list of covid
    List<CovidData> covidList = new ArrayList<>();
    //get list of Furlough
    List<Furlough> furloughList = new ArrayList<>();
    // Combo list<<
    ArrayList<MapInfo> combo = new ArrayList<>();


    //Add Data to furlough
        furloughList = furloughService.getAllFurlough();
    //Add Data to Covid
        covidList = covidDataService.getAllCovid();


    // Use GeoJsonTransformer o generate json

    //iterate furlough list - calling geoJsonTrans
        for(Furlough f: furloughList){
            // ForEach record we get Mapinfo add to combo
            combo.add(
              furloughService. getFurloughMapinfoByDistrict(f.getDistrict()));
        }

        for(CovidData c: covidList){
            // ForEach record we get Mapinfo add to combo
            combo.add(covidDataService.getCovidCasesMapinfoByDistrict(c.getDistrict()));
        }

    //iterate furlough list - calling geoJsonTrans
    System.out.println("Size of combo is:  " + combo.size());


        return combo;
    }
}

/**
* remove all the logic from controoller and put into service
* create selector if id = 1 then quetion1 service

*/