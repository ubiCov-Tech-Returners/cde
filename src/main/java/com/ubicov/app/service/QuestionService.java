package com.ubicov.app.service;

import com.ubicov.app.domain.CovidData;
import com.ubicov.app.domain.Furlough;
import com.ubicov.app.domain.Vaccination;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
* Is vaccination uptake lesser in areas with lower income?
Have covid cases fallen enough to safely reopen my business?
Is the spread of Covid-19 in your area related to nights outs?
* */

@Service
public class QuestionService {

// Add all service
    private VaccinationService vaccinationService;
    private CovidDataService covidDataService;
    private DeprivationService deprivationService;
    private FurloughService furloughService;

    public QuestionService(VaccinationService vaccinationService, CovidDataService covidDataService, DeprivationService deprivationService, FurloughService furloughService) {
        this.vaccinationService = vaccinationService;
        this.covidDataService = covidDataService;
        this.deprivationService = deprivationService;
        this.furloughService = furloughService;
    }

    /**
     * This answer Question1
     * Is vaccination uptake lesser in areas with lower income?
     * @return
     */
    public List<MapInfo> getQuestion1(){


        //Get list of covid
        List<CovidData> covidList = new ArrayList<>();
        //get list of vaccination
        List<Vaccination> vaccinationList = new ArrayList<>();
        // Combo list<<
        ArrayList<MapInfo> combo = new ArrayList<>();

        vaccinationList = vaccinationService.getAllVaccinations();
        covidList = covidDataService.getAllCovid();

        //Pending to investigate why doesn't work
        for(Vaccination v: vaccinationList){
            combo.add(
                    vaccinationService.getVaccinationMapinfoByDistrict(v.getDistrict()));
        }

        for(CovidData c: covidList){
            combo.add(covidDataService.getCovidCasesMapinfoByDistrict(c.getDistrict()));
        }
        System.out.println("Size is correct " + combo.size());
        return combo;




    }


    /**
     * This answer Question3
     * How has Covid-19 affected your area?
     * @return
     */
    public List<MapInfo> getQuestion3(){
        //Get list of covid
        List<CovidData> covidList = new ArrayList<>();
        //get list of Furlough
        List<Furlough> furloughList = new ArrayList<>();
        // Combo list<<
        ArrayList<MapInfo> combo = new ArrayList<>();

        furloughList = furloughService.getAllFurlough();

        covidList = covidDataService.getAllCovid();
        for(Furlough f: furloughList){
            combo.add(
                    furloughService. getFurloughMapinfoByDistrict(f.getDistrict()));
        }

        for(CovidData c: covidList){
            combo.add(covidDataService.getCovidCasesMapinfoByDistrict(c.getDistrict()));
        }
        return combo;
    }

    public List<MapInfo> getQuestion2() {
        return null;
    }

    /**
     * This answer Question4
     * Is the spread of Covid-19 in your area related to nights outs?
     * @return
     */
    public List<MapInfo> getQuestion4(){
       return null;
    }
}
