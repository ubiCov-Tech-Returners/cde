/**
 * @Author - Richard Renaud, Urmila Mathew, Carmen Lara
 * This Class contains all the CRUD operations for accessing geo-locations.
 */
package com.ubicov.app.service;

import com.ubicov.app.domain.CovidData;
import com.ubicov.app.domain.Furlough;
import com.ubicov.app.repository.CovidDataRepository;
import com.ubicov.app.util.geojson.GeoJsonGenerator;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CovidDataService {

    @Autowired
    private CovidDataRepository covidDataRepository;

    private final String dataType = "covid_cases";

    // Generates data in GeoJson
    private GeoJsonGenerator geoJsonGenerator;

    private double percentageOfTotal;


    public CovidDataService(CovidDataRepository covidDataRepository) {

        this.covidDataRepository = covidDataRepository;
        this.percentageOfTotal = setPercentageoftotal();
    }

    public CovidData getCovidDataByDistrict(String district) {
        return covidDataRepository.findCovidDataByDistrict(district);
    }

    public List<CovidData> getAllCovid() {
        return covidDataRepository.findAll();
    }

    /**
     * Transforms Covid Cases Data into GeoJson Format
     *
     * @param district
     * @return
     */
    public MapInfo getCovidCasesMapinfoByDistrict(String district) {
        CovidData covidCases = covidDataRepository.findCovidDataByDistrict(district);
        GeoJsonGenerator generator = new GeoJsonGenerator();

        return generator.getMapInfoByDistrict(getMapParams(covidCases));
    }


    /**
     * Transforms all Covid cases Data into GeoJson Format
     *

     * @return
     */
    public MapInfo getAllCovidCasesMapinfo() {
        GeoJsonGenerator generator = new GeoJsonGenerator();
        return generator.getAllMapInfo(getMapParamsOfMany(covidDataRepository.findAll()));
    }
    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param covidData
     * @return Key value pairs
     */
    private Map<String, String> getMapParams(CovidData covidData) {
        Map<String, String> params = new HashMap<>();
        params.put("borough", covidData.getDistrict());
        params.put("datatype", this.dataType); // Hard coded for each dataset type
        params.put("longitude", covidData.getLoc().getLongitude());
        params.put("latitude", covidData.getLoc().getLatitude());
        params.put("Feature", "Feature");
        params.put("Point", "Point");
        params.put("value", String.valueOf(covidData.getNewCases()));
        params.put("percentageOfTotal", String.valueOf(((covidData.getNewCases()/percentageOfTotal)*100)));
        return params;
    }

    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param allCases
     * @return Key value pairs
     */
    private List<Map<String, String>> getMapParamsOfMany(List <CovidData> allCases) {
        List<Map<String, String>> paramsOfMany = new ArrayList<>();
        for (CovidData covidCase: allCases){
            paramsOfMany.add(getMapParams(covidCase));
        }
        return paramsOfMany;
    }

    public double setPercentageoftotal(){

        double result = covidDataRepository.findAll()
                .stream()
                .mapToDouble(c->c.getNewCases())
                .sum();


        return result;
    }
}
