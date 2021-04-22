package com.ubicov.app.service;

import com.ubicov.app.domain.Deprivation;
import com.ubicov.app.repository.DeprivationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeprivationService {

    private DeprivationRepository deprivationRepository;

    public DeprivationService(DeprivationRepository deprivationRepository){
        this.deprivationRepository = deprivationRepository;

    }
    public Deprivation getDeprivationByDistrictAndDate(String district, String date) {
        return deprivationRepository.findDeprivationByDistrictAndDate(district, date);
    }

    public Deprivation getDeprivationByDistrict(String district) {
        return deprivationRepository.findDeprivationByDistrict(district);
    }

    public List<Deprivation> getAllDeprivations() {
        return deprivationRepository.findAll();
    }
}
