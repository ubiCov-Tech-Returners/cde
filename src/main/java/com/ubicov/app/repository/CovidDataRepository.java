package com.ubicov.app.repository;

import com.ubicov.app.domain.CovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CovidDataRepository extends JpaRepository<CovidData, Long> {
    @Query(value = "SELECT * FROM covid_data c WHERE c.district= ?1", nativeQuery = true)
    CovidData findCovidDataByDistrict(String district);
}