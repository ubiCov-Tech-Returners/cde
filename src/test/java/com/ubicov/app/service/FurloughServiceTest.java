package com.ubicov.app.service;

import com.ubicov.app.domain.Furlough;
import com.ubicov.app.repository.FurloughRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class FurloughServiceTest {

    @Mock
    private FurloughRepository furloughRepository;

    private FurloughService furloughService;

    @Before
    public void setUp() throws Exception {
        furloughService = new FurloughService(furloughRepository);
    }

    @Test
    public void getGeoLocationByDistrict() {
        given(furloughRepository.findByDistrict("City of London")).willReturn(new Furlough("E09000001", "City of London", LocalDate.parse("2020-12-31"), 7100, 8100, 15200));

        Furlough furlough = furloughService.getFurloughByDistrictAndDate("City of London");

        assertThat(furlough.getDistrict()).isEqualTo("City of London");
        assertThat(furlough.getDate()).isEqualTo(LocalDate.parse("2020-12-31").toString());
        assertThat(furlough.getLadCode()).isEqualTo("E09000001");
        assertThat(furlough.getFemale_furloughed()).isEqualTo(7100);
        assertThat(furlough.getMale_furloughed()).isEqualTo(8100);
        assertThat(furlough.getTotal_furloughed()).isEqualTo(15200);
    }
}
