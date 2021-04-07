/**
 * @Author - Richard Renaud
 * Exposes geo-location endpoints and produces data in JSON format.
 * <p>
 * This will be used to match OTHER DATA with geo-locational information.
 */
package com.ubicov.app.controller;

import com.ubicov.app.domain.GeoLocation;
import com.ubicov.app.service.GeoLocationService;
import com.ubicov.app.util.GeoLocationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeoLocationController {

    private GeoLocationService geoLocationService;

    public GeoLocationController(GeoLocationService geoLocationService) {
        this.geoLocationService = geoLocationService;
    }

    @GetMapping("/loc/{district}")
    private GeoLocation getGeoLocation(@PathVariable String district) {
        return geoLocationService.getLocByDistrict(district);
    }

    @GetMapping("/loc/")
    private List<GeoLocation> getAllGeoLocations() {
        return geoLocationService.getAllLoc();
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void geoLocationNotFoundHandler(GeoLocationNotFoundException ex) {

    }
}

