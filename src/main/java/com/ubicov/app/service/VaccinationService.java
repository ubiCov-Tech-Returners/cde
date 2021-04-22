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

    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    public Vaccination getVaccinationByDistrictAndDate(String district, String date) {
        return vaccinationRepository.findVaccinationByDistrictAndDate(district, date);
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
    public MapInfo getFurloughMapinfoByDistrict(String district, String date) {
        Vaccination vaccination = vaccinationRepository.findVaccinationByDistrictAndDate(district, date);
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
        params.put("district", vaccination.getDistrict());
        params.put("featureType", "FeatureCollection");
        params.put("dataset", "vaccination");
        params.put("geoType", "Point");
        params.put("longitude", vaccination.getLoc().getLongitude());
        params.put("latitude", vaccination.getLoc().getLatitude());
        params.put("feature", "feature");

        return params;
    }
}
