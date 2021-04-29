/**
 * @Author - Richard Renaud, Urmila Mathew
 * This Class contains all the CRUD operations for accessing geo-locations.
 */
package com.ubicov.app.service;

import com.ubicov.app.domain.Vaccination;
import com.ubicov.app.repository.VaccinationRepository;
import com.ubicov.app.util.geojson.GeoJsonGenerator;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VaccinationService {

    private VaccinationRepository vaccinationRepository;
    private String dataType = "vaccination";
    private double percentageOfTotal = 0.0;

    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
        this.percentageOfTotal = setPercentageoftotal();
        
    }

    public Vaccination getVaccinationByDistrictAndDate(String district, String date) {
        return vaccinationRepository.findVaccinationByDistrictAndDate(district, date);
    }
    public Vaccination getVaccinationByDistrict(String district) {
        return vaccinationRepository.findVaccinationByDistrict(district);
    }

    public List<Vaccination> getAllVaccinations() {
        return vaccinationRepository.findAll();
    }

    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param district
     * @return Key value pairs
     */
    public MapInfo getVaccinationMapinfoByDistrict(String district, String date) {
        Vaccination vaccination = vaccinationRepository.findVaccinationByDistrictAndDate(district, date);
        GeoJsonGenerator generator = new GeoJsonGenerator();

        return generator.getMapInfoByDistrict(getMapParams(vaccination));
    }

    public MapInfo getVaccinationMapinfoByDistrict(String district) {
        Vaccination vaccination = vaccinationRepository.findVaccinationByDistrict(district);
        GeoJsonGenerator generator = new GeoJsonGenerator();

        return generator.getMapInfoByDistrict(getMapParams(vaccination));
    }

    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param vaccination
     * @return Key value pairs
     */
    private Map<String, String> getMapParams(Vaccination vaccination) {
        Map<String, String> params = new HashMap<>();
        params.put("borough", vaccination.getDistrict());
        params.put("datatype", this.dataType); // Hard coded for each dataset type
        params.put("longitude", vaccination.getLoc().getLongitude());
        params.put("latitude", vaccination.getLoc().getLatitude());
        params.put("Feature", "Feature");
        params.put("Point", "Point");
        params.put("value", String.valueOf(getSumAllVaccinations(vaccination)));
        params.put("percentageOfTotal", String.valueOf(((getSumAllVaccinations(vaccination)/percentageOfTotal)*100)));

        return params;
    }

    public double setPercentageoftotal(){

        double result = vaccinationRepository.findAll()
                .stream()
                .mapToDouble(f->getSumAllVaccinations(f))
                .sum();


        return result;
    }
    private double getSumAllVaccinations(Vaccination v){
        double result = 0;
        result = v.getAgeUnder50() + v.getAge50To54() + v.getAge55To59() + v.getAge60To64() + v.getAge65To69() + v.getAge70To74() + v.getAgeOver80();
        return result;
    }
}
