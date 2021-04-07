package com.ubicov.app.service;

import com.ubicov.app.domain.CovidData;
import com.ubicov.app.repository.CovidDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidDataService {

    @Autowired
    private CovidDataRepository covidDataRepository;

    public CovidDataService(CovidDataRepository covidDataRepository) {
        this.covidDataRepository = covidDataRepository;
    }

    public CovidData getCovidDataByDistrict(String district) {
        return covidDataRepository.findCovidDataByDistrict(district);
    }
}
