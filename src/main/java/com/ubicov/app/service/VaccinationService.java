/**
 * @Author - Richard Renaud, Urmila Mathew
 * This Class contains all the CRUD operations for accessing geo-locations.
 */
package com.ubicov.app.service;

import com.ubicov.app.domain.Vaccination;
import com.ubicov.app.repository.VaccinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationService {

    private VaccinationRepository vaccinationRepository;

    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
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
}
