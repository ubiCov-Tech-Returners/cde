/**
 * @Author - Richard Renaud
 * Integration test for ubiCov/Improbable web application.
 * This will give us a full spring Boot instance which will run on a random port.
 */
package com.ubicov.app;

import com.ubicov.app.domain.GeoLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private List geoLocationsList = new ArrayList<GeoLocation>();

    public void setUp() {
        // Initialise Gelocation
        geoLocationsList.add(new GeoLocation("E09000001", "City of London", "-0.07969517196215747", "51.5196779388711"));
        geoLocationsList.add(new GeoLocation("E09000002", "Barking and Dagenham", "0.08406889679520191", "51.53197153659997"));
        geoLocationsList.add(new GeoLocation("E09000003", "Barnet", "-0.19885620792410919", "51.64894479224796"));
    }

    @Test
    public void test() throws Exception {
        //arrange

        //act
        ResponseEntity<GeoLocation> response = restTemplate.getForEntity("/loc/City of London", GeoLocation.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getDistrict()).isEqualTo("City of London");
        assertThat(response.getBody().getLadCode()).isEqualTo("E09000001");
        assertThat(response.getBody().getLongitude()).isEqualTo("-0.07969517196215747");
        assertThat(response.getBody().getLatitude()).isEqualTo("51.5196779388711");

    }

//    @Test
//    public void getCovidData_returnsCovidData() {
//        //arrange
//
//        //act
//        ResponseEntity<CovidData> response = restTemplate.getForEntity("/covid/Barking and Dagenham", CovidData.class);
//
//        // assert
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getBody().getLtla_name()).isEqualTo("Barking and Dagenham");
//        assertThat(response.getBody().getLtla_code()).isEqualTo("E09000002");
//        assertThat(response.getBody().getStart_date()).isEqualTo(LocalDate.parse("08/12/2020"));
//        assertThat(response.getBody().getEnd_date()).isEqualTo(LocalDate.parse("21/02/2021"));
//        assertThat(response.getBody().getDose()).isEqualTo(LocalDate.parse("1st dose"));
//        assertThat(response.getBody().getAge()).isEqualTo(LocalDate.parse("71-74"));
//        assertThat(response.getBody().getVaccines()).isEqualTo(4059);
//        assertThat(response.getBody().getPopulation()).isEqualTo(4839);
//        assertThat(response.getBody().getPercentage_vaccine()).isEqualTo(0.839330025);
//    }

}
