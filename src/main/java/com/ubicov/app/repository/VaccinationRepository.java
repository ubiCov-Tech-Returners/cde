/**
 * @Author - Richard Renaud, Urmila Mathew
 * This class facilitates the interaction with our data store.  Using the
 * '@Repository' and extending 'JpaRepository' we get a lot of functionality for free.
 * We can also override or custom that functionality.  To do this we are using custom SQL queries.
 */
package com.ubicov.app.repository;

import com.ubicov.app.domain.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

    @Query(value = "SELECT * FROM vaccination v WHERE v.district = ?1 AND v.date = ?2", nativeQuery = true)
    Vaccination findVaccinationByDistrictAndDate(String district, String date);

    @Query(value = "SELECT * FROM vaccination v WHERE v.district = ?1", nativeQuery = true)
    Vaccination findVaccinationByDistrict(String district);


}
