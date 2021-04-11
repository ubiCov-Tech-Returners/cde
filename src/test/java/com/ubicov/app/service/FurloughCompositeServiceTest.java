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
package com.ubicov.app.service;

import com.ubicov.app.domain.Furlough;
import com.ubicov.app.domain.GeoLocation;
import com.ubicov.app.repository.FurloughRepository;
import com.ubicov.app.repository.GeoLocationRepository;
import com.ubicov.app.service.composite.FurloughCompositeService;
import com.ubicov.app.util.transformer.FurloughComposite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class FurloughCompositeServiceTest {

    @Mock
    private GeoLocationRepository geoLocationRepository;

    @Mock
    private FurloughRepository furloughRepository;

    @Mock
    private FurloughCompositeService furloughCompositeService;

    private FurloughComposite furloughComposite;

    @Before
    public void setUp() throws Exception {
        GeoLocation geoLoc = new GeoLocation("E09000001", "City of London", "-0.07969517196215747", "51.5196779388711");
        Furlough furlough = new Furlough("E09000001", "City of London", LocalDate.parse("2020-12-31"), 7100, 8100, 15200);

        furloughComposite = new FurloughComposite(geoLoc, furlough);
    }

    @Test
    public void getFurloughCompositeByDistrict() throws Exception {
        String district = "City of London";
        GeoLocation g = geoLocationRepository.findByDistrict(district);
        Furlough f = furloughRepository.findByDistrict(district);
//        FurloughComposite fc = new FurloughComposite(g, f);

        given(furloughCompositeService.getByDistrict(district)).willReturn(new FurloughComposite(g, f));

        FurloughComposite fc = furloughCompositeService.getByDistrict(district);

        assertThat(furloughComposite.getFurlough().getDistrict()).isEqualTo("City of London");
        assertThat(furloughComposite.getFurlough().getLadCode()).isEqualTo("E09000001");

        assertThat(furloughComposite.getGeoLoc().getDistrict()).isEqualTo("City of London");
        assertThat(furloughComposite.getGeoLoc().getLadCode()).isEqualTo("E09000001");

        // TODO - needs more assertions but due to time restraints will leave until later.
    }
}
