package com.ubicov.app.service;

import com.ubicov.app.domain.Deprivation;
import com.ubicov.app.domain.Vaccination;
import com.ubicov.app.repository.DeprivationRepository;
import com.ubicov.app.repository.VaccinationRepository;
import com.ubicov.app.util.geojson.GeoJsonGenerator;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeprivationService {
    private DeprivationRepository deprivationRepository;
    private String dataType = "deprivation";
    private double percentageOfTotal = 0.0;

    public DeprivationService(DeprivationRepository deprivationRepository) {
        this.deprivationRepository = deprivationRepository;
        this.percentageOfTotal = setPercentageoftotal();

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
    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param district
     * @return Key value pairs
     */
    public MapInfo getDeprivationMapinfoByDistrict(String district, String date) {
        Deprivation deprivation = deprivationRepository.findDeprivationByDistrictAndDate(district, date);
        GeoJsonGenerator generator = new GeoJsonGenerator();

        return generator.getMapInfoByDistrict(getMapParams(deprivation));
    }

    public MapInfo getDeprivationMapinfoByDistrict(String district) {
        Deprivation deprivation = deprivationRepository.findDeprivationByDistrict(district);
        GeoJsonGenerator generator = new GeoJsonGenerator();

        return generator.getMapInfoByDistrict(getMapParams(deprivation));
    }

    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param deprivation
     * @return Key value pairs
     */
    private Map<String, String> getMapParams(Deprivation deprivation) {
        Map<String, String> params = new HashMap<>();
        params.put("borough", deprivation.getDistrict());
        params.put("datatype", this.dataType); // Hard coded for each dataset type
        params.put("longitude", deprivation.getLoc().getLongitude());
        params.put("latitude", deprivation.getLoc().getLatitude());
        params.put("Feature", "Feature");
        params.put("Point", "Point");
        params.put("value", String.valueOf(getSumAllDeprivations(deprivation)));
        params.put("percentageOfTotal", String.valueOf(((getSumAllDeprivations(deprivation)/percentageOfTotal)*100)));

        return params;
    }

    public double setPercentageoftotal(){

        double result = deprivationRepository.findAll()
                .stream()
                .mapToDouble(f->getSumAllDeprivations(f))
                .sum();


        return result;
    }
    private double getSumAllDeprivations(Deprivation d){
        double result = 0;
        result = d.getIncDepAffectingChildren() + d.getIncDepAffectingOldPeople();
        return result;
    }
}
