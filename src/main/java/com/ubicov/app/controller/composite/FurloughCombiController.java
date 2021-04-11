/**
 * @Author - Richard Renaud
 * Exposes Combined [Geolocation / Furlough] endpoints and produces data in JSON format.
 * <p>
 */
package com.ubicov.app.controller.composite;

import com.ubicov.app.service.composite.FurloughCompositeService;
import com.ubicov.app.util.transformer.FurloughComposite;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FurloughCombiController {

    private FurloughCompositeService furloughCompositeService;

    public FurloughCombiController(FurloughCompositeService fcService) {
        this.furloughCompositeService = fcService;

    }

    @GetMapping("/compdata/furlough/{district}")
    private FurloughComposite getByDistrict(@PathVariable String district) {
        return furloughCompositeService.getByDistrict(district);
    }
}
