/**
 * @Author - Richard Renaud
 * Very light weight thin test.  This test needs to be expanded depending on
 * service functionality.  Here we are only testing the fetch as this set of data
 * has been manually captured and will NOT need to be changed.
 * <p>
 * n.b.  No test has been deviced for location accuracy.  We assume that the
 * co-ordinates are correct moving forward.
 * <p>
 * Due to time restraints the tests here are limited but what has been achieved should give
 * a good indication on what could be done in the future.
 */
package com.ubicov.app.service;

import com.ubicov.app.domain.GeoLocation;
import com.ubicov.app.repository.GeoLocationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class GeoLocationServiceTest {

    @Mock
    private GeoLocationRepository geoLocationRepository;

    private GeoLocationService geoLocationService;

    @Before
    public void setUp() throws Exception {
        geoLocationService = new GeoLocationService(geoLocationRepository);
    }

    @Test
    public void getGeoLocationByDistrict() {
        given(geoLocationRepository.findByDistrict("City of London")).willReturn(new GeoLocation("E09000001", "City of London", "-0.07969517196215747", "51.5196779388711"));

        GeoLocation geoLocation = geoLocationService.getLocByDistrict("City of London");

        assertThat(geoLocation.getDistrict()).isEqualTo("City of London");
        assertThat(geoLocation.getLadCode()).isEqualTo("E09000001");
        assertThat(geoLocation.getLongitude()).isEqualTo("-0.07969517196215747");
        assertThat(geoLocation.getLatitude()).isEqualTo("51.5196779388711");
    }

//    @Test(expected = GeoLocationNotFoundException.class)
//    public void getGeoLocation_whenGeoLocationNotFound() throws Exception {
//        given(geoLocationRepository.findByDistrict("City of London")).willReturn(null);
//
//        geoLocationService.getLocByDistrict("City of London");
//    }

}
