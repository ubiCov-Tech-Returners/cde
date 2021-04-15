/**
 * @Author - Richard Renaud
 * WebMvc Test Slice - only tests the controller.
 * <p>
 * Due to time restraints the tests here are limited but what has been achieved should give
 * a good indication on what could be done in the future.
 * <p>
 * Assertion of LocalDate needs to be converted to a string since (JsonPath operates on actual JSON itself)
 */
package com.ubicov.app.controller;

import com.ubicov.app.domain.Furlough;
import com.ubicov.app.service.FurloughService;
import com.ubicov.app.util.geojson.MapInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FurloughController.class)
public class FurloughControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FurloughService furloughService;

    @Test
    public void getFurlough_shouldReturnFurlough() throws Exception {
        given(furloughService.getFurloughByDistrictAndDate(anyString())).willReturn(new Furlough("E09000001", "City of London", LocalDate.parse("2020-12-31"), 7100, 8100, 15200));

        mockMvc.perform(MockMvcRequestBuilders.get("/furlough/City of London"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("district").value("City of London"))
                .andExpect((ResultMatcher) jsonPath("date").value(LocalDate.parse("2020-12-31").toString()))
                .andExpect((ResultMatcher) jsonPath("female_furloughed").value(7100))
                .andExpect((ResultMatcher) jsonPath("male_furloughed").value(8100))
                .andExpect((ResultMatcher) jsonPath("total_furloughed").value(15200));
    }

    @Test
    public void getFurloughMapinfo_shouldReturnMapInfo() throws Exception {
        given(furloughService.getFurloughMapinfoByDistrict(anyString())).willReturn(new MapInfo());


    }
}
