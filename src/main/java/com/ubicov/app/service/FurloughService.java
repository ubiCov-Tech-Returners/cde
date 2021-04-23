/**
 * @Author - Richard Renaud
 * This Class contains all the CRUD operations for accessing geo-locations.
 */
package com.ubicov.app.service;

import com.ubicov.app.domain.Furlough;
import com.ubicov.app.repository.FurloughRepository;
import com.ubicov.app.util.geojson.GeoJsonGenerator;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FurloughService {

    private final String dataType = "furlough";
    private FurloughRepository furloughRepository;

    // Generates data in GeoJson
    private GeoJsonGenerator geoJsonGenerator;

    public FurloughService(FurloughRepository furloughRepository) {
        this.furloughRepository = furloughRepository;
    }

    public Furlough getFurloughByDistrictAndDate(String district) {
        return furloughRepository.findByDistrict(district);
    }

    public List<Furlough> getAllFurlough() {
        return furloughRepository.findAll();
    }

    public Furlough getByDistrict(String district) {
        return furloughRepository.findByDistrict(district);
    }

    /**
     * Transforms Furlough Data into GeoJson Format
     *
     * @param district
     * @return
     */
    public MapInfo getFurloughMapinfoByDistrict(String district) {
        Furlough furlough = furloughRepository.findByDistrict(district);
        GeoJsonGenerator generator = new GeoJsonGenerator();

        return generator.getMapInfoByDistrict(getMapParams(furlough));
    }


    /**
     * Transforms all Furlough Data into GeoJson Format
     *

     * @return
     */
    public MapInfo getAllFurloughMapinfo() {
        GeoJsonGenerator generator = new GeoJsonGenerator();
         return generator.getAllMapInfo(getMapParamsOfMany(furloughRepository.findAll()));
    }
    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param furlough
     * @return Key value pairs
     */
    private Map<String, String> getMapParams(Furlough furlough) {
        Map<String, String> params = new HashMap<>();
        params.put("borough", furlough.getDistrict());
        params.put("datatype", this.dataType); // Hard coded for each dataset type
        params.put("longitude", furlough.getLoc().getLongitude());
        params.put("latitude", furlough.getLoc().getLatitude());
        params.put("Feature", "Feature");
        params.put("Point", "Point");
        params.put("value", String.valueOf(furlough.getTotal_furloughed()));

        return params;
    }

    /**
     * Sets the paramaters of the GeoJson fields
     *
     * @param allFurlough
     * @return Key value pairs
     */
    private List<Map<String, String>> getMapParamsOfMany(List <Furlough> allFurlough) {
        List<Map<String, String>> paramsOfMany = new ArrayList<>();
        for (Furlough furlough: allFurlough){
            Map<String, String> params = new HashMap<>();
            params.put("borough", furlough.getDistrict());
            params.put("datatype", this.dataType); // Hard coded for each dataset type
            params.put("longitude", furlough.getLoc().getLongitude());
            params.put("latitude", furlough.getLoc().getLatitude());
            params.put("Feature", "Feature");
            params.put("Point", "Point");
            params.put("value", String.valueOf(furlough.getTotal_furloughed()));
            paramsOfMany.add(params);
        }
        return paramsOfMany;
    }
}
