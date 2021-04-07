package com.ubicov.app.repository;

import com.ubicov.app.domain.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

    @Query(value = "SELECT * FROM vaccination v WHERE v.district = ?1 AND v.date = ?2", nativeQuery = true)
    Vaccination findVaccinationByDistrictAndDate(String district, String date);

}
