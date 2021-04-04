/**
 * @Author - Richard Renaud
 * This class facilitates the interaction with our data store.  Using the
 * '@Repository' and extending 'JpaRepository' we get a lot of functionality for free.
 * We can also override or custom that functionality.  To do this we are using custom SQL queries.
 */
package com.ubicov.app.repository;

import com.ubicov.app.domain.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoLocationRepository extends JpaRepository<GeoLocation, Long> {

    @Query(value = "SELECT * FROM geo_location g WHERE g.district = ?1", nativeQuery = true)
    GeoLocation findByDistrict(String district);
}
