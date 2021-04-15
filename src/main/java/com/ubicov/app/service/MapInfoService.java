/**
 * @Author Richard Renaud
 * This Class transforms persisted data into GeoJson format for use with MapBox.
 */
package com.ubicov.app.service;

import com.ubicov.app.domain.GeoLocation;
import com.ubicov.app.repository.GeoLocationRepository;
import com.ubicov.app.util.geojson.Feature;
import com.ubicov.app.util.geojson.Geometry;
import com.ubicov.app.util.geojson.MapInfo;
import com.ubicov.app.util.geojson.Property;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapInfoService {

    public final Map<String, String> plotColours = new HashMap<>();
    private final String geoType = "Point";
    private final String featureType = "FeatureCollection";
    private final String markerSymbol = "rail-metro";
    public List<String> dataset = new ArrayList<>(); // Used to change color of plots on map
    public GeoLocation loc;
    private GeoLocationRepository geoLocationRepository;
    private GeoLocationService geoLocationService;

    public MapInfoService(GeoLocationService geoLocationService) {
        this.geoLocationService = geoLocationService;
    }

    public GeoLocation deleteTest(String district) {
        return geoLocationRepository.findByDistrict(district);
    }

    public void setUpMapInfo(String district, String dataSet) {
        //Get location for this district
        this.loc = new GeoLocation("E09000001", "City of London", "-0.07969517196215747", "51.5196779388711");
//        this.loc = geoLocationService.getLocByDistrict(district);

        // Set map plotting colours
        plotColours.put("covid", "red");
        plotColours.put("vaccination", "yellow");
        plotColours.put("furlough", "blue");

        // Set the colour to plot onto the map
        this.dataset = getLines(dataSet);

    }

    //TODO - add feature
    public MapInfo getMapInfoByDistrict(String district, String dataSet) {
        setUpMapInfo(district, dataSet);  // Set MapInfo defaults

        MapInfo mapInfo = new MapInfo();
        mapInfo.setType(this.featureType);
        mapInfo.setFeatures(getFeature(district));
        return mapInfo;
    }

    private List<Feature> getFeature(String district) {
        Feature f = new Feature();
        List<Feature> features = new ArrayList<>();

        f.setGeometry(getGeometry(district));
        f.setType(this.featureType);

        features.add(f);

        return features;
    }

    /**
     * Get Geometry information
     *
     * @param district
     * @return Geometry
     */
    public Geometry getGeometry(String district) {
        Geometry geometry = new Geometry();
        geometry.setType(this.geoType);
        geometry.setCoordinates(getCoordinates(district));
//        geometry.setLadCode(loc.getLadCode());

        return geometry;
    }

    /**
     * Gets Coordinates from Geo-location
     *
     * @param district
     * @return Property
     */
    private List<String> getCoordinates(String district) {
        List<String> coordinates = new ArrayList<>();

        coordinates.add(this.loc.getLongitude());
        coordinates.add(this.loc.getLatitude());

        return coordinates;
    }

    public Property getProperties(String dataSet) {
        Property property = new Property();
        property.setDescription(loc.getDistrict());  //set same as district
        property.setMakerSymbol(this.markerSymbol);
        property.setTitle(loc.getDistrict());
        property.setUrl("http://google.com");
        property.setLines(getLines(dataSet));
        property.setAddress("London Borough of " + loc.getDistrict());

        return property;
    }

    private List<String> getLines(String dataSet) {
        List<String> lines = new ArrayList<String>();
        lines.add(plotColours.get(dataSet));

//        switch (dataSet) {
//            case "furlough": lines[0] = plotColours.get(dataSet);  break;
//            case "vaccinations": lines[0] = plotColours.get(dataSet);  break;
//            case "covid": lines[0] = plotColours.get(dataSet);  break;
//        }
        return lines;
    }
}