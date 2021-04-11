/**
 * @Author - Richard Renaud
 * Very light weight thin test.  This test needs to be expanded depending on
 * service functionality.  Here we are only testing the fetch as this set of data
 * has been manually captured and will NOT need to be changed.
 * <p>
 * n.b.  No test has been devised for location accuracy.  We assume that the
 * co-ordinates are correct moving forward.
 * <p>
 * Due to time restraints the tests here are limited but what has been achieved should give
 * a good indication on what could be done in the future.
 */
package com.ubicov.app.service.composite;

import com.ubicov.app.repository.FurloughRepository;
import com.ubicov.app.repository.GeoLocationRepository;
import com.ubicov.app.util.transformer.FurloughComposite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurloughCompositeService {

    @Autowired
    private GeoLocationRepository geoLocationRepository;
    private FurloughRepository furloughRepository;

    public FurloughCompositeService(GeoLocationRepository geoLocationRepository,
                                    FurloughRepository furloughRepository) {
        this.geoLocationRepository = geoLocationRepository;
        this.furloughRepository = furloughRepository;
    }

    public FurloughComposite getByDistrict(String district) {
        return new FurloughComposite(geoLocationRepository.findByDistrict(district),
                furloughRepository.findByDistrict(district));
    }

}
