package com.ubicov.app.repository;

import com.ubicov.app.domain.Furlough;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FurloughRepository extends JpaRepository<Furlough, Long> {

    @Query(value = "SELECT * FROM furlough f WHERE f.district = ?1", nativeQuery = true)
    Furlough findByDistrict(String district);
}
