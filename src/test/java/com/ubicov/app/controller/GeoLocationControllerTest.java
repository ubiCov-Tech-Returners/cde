/**
 * @Author - Richard Renaud
 * WebMvc Test Slice - only tests the controller.
 * <p>
 * Due to time restraints the tests here are limited but what has been achieved should give
 * a good indication on what could be done in the future.
 */
package com.ubicov.app.controller;

import com.ubicov.app.domain.GeoLocation;
import com.ubicov.app.service.GeoLocationService;
import com.ubicov.app.util.GeoLocationNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GeoLocationController.class)
public class GeoLocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeoLocationService geoLocationService;

    @Test
    public void getGeoLocation_shouldReturnGeolocation() throws Exception {
        given(geoLocationService.getLocByDistrict(anyString())).willReturn(new GeoLocation("E09000001", "City of London", "-0.07969517196215747", "51.5196779388711"));

        mockMvc.perform(MockMvcRequestBuilders.get("/loc/City of London"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("district").value("City of London"))
                .andExpect(jsonPath("ladCode").value("E09000001"))
                .andExpect(jsonPath("longitude").value("-0.07969517196215747"))
                .andExpect(jsonPath("latitude").value("51.5196779388711"));
    }

    @Test
    public void getGeoLocation_notFOund() throws Exception {
        given(geoLocationService.getLocByDistrict(anyString())).willThrow(new GeoLocationNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/loc/City of London"))
                .andExpect(status().isNotFound());
    }
}
