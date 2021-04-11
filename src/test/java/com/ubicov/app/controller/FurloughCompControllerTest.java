/**
 * @Author - Richard Renaud
 * WebMvc Test Slice - only tests the controller.
 * <p>
 * Due to time restraints the tests here are limited but what has been achieved should give
 * a good indication on what could be done in the future.
 * <p>
 * ## Note - further reading ##
 * - https://dzone.com/articles/rest-endpoint-testing-with-mockmvc
 * - https://www.briansdevblog.com/2017/05/rest-endpoint-testing-with-mockmvc/
 */
package com.ubicov.app.controller;

import com.ubicov.app.controller.composite.FurloughCombiController;
import com.ubicov.app.domain.Furlough;
import com.ubicov.app.domain.GeoLocation;
import com.ubicov.app.service.composite.FurloughCompositeService;
import com.ubicov.app.util.transformer.FurloughComposite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FurloughCombiController.class)
public class FurloughCompControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FurloughCompositeService furloughCompositeService;

    private FurloughComposite furloughComposite;

    @Before
    public void setUp() throws Exception {
        GeoLocation geoLoc = new GeoLocation("E09000001", "City of London", "-0.07969517196215747", "51.5196779388711");
        Furlough furlough = new Furlough("E09000001", "City of London", LocalDate.parse("2020-12-31"), 7100, 8100, 15200);

        // Initialise FurloughComposite
        furloughComposite = new FurloughComposite(geoLoc, furlough);

    }

    @Test
    public void getFurloughComposite_shouldReturd_FurloughComposite() throws Exception {
        given(furloughCompositeService.getByDistrict(anyString())).willReturn(furloughComposite);

        mockMvc.perform(MockMvcRequestBuilders.get("/compdata/furlough/City of London"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("geoloc.district").value("City of London"));
//                .andExpect(model().attributeExists("geoLoc"));
    }
}
