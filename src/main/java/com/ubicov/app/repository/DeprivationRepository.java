package com.ubicov.app.repository;

import com.ubicov.app.domain.Deprivation;
import com.ubicov.app.domain.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeprivationRepository extends JpaRepository<Deprivation, Long> {

    @Query(value = "SELECT * FROM deprivation v WHERE v.district = ?1 AND v.date = ?2", nativeQuery = true)
    Deprivation findDeprivationByDistrictAndDate(String district, String date);

    @Query(value = "SELECT * FROM deprivation v WHERE v.district = ?1", nativeQuery = true)
    Deprivation findDeprivationByDistrict(String district);



}
