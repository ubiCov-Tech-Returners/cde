package com.ubicov.app.util.geojson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoJsonGenerator {
    private final String featureType = "FeatureCollection";
    private Map<String, String> plotColours = new HashMap<>();

    //Default No Args constructor
    public GeoJsonGenerator() {
    }

    // Sets the plotting colours of the datasets
    public void setUpColorPlots() {
        // Set map plotting colours
        plotColours.put("covid", "rgb(255,0,0)");
        plotColours.put("vaccination", "rgb(255,250,205)");
        plotColours.put("furlough", "rgb(0,0,255)");
    }

    /**
     * Builds and populates a MapInfo object
     *
     * @param paramsOfMany
     * @return
     */
    public MapInfo getAllMapInfo(List<Map<String, String>> paramsOfMany) {
        setUpColorPlots();  // Set MapInfo defaults

        MapInfo mapInfo = new MapInfo();
        mapInfo.setType(this.featureType);
        mapInfo.setFeatures(getFeatures(paramsOfMany)); // Sets GeoJson Features

        return mapInfo;
    }


    /**
     * Builds and populates a MapInfo object
     *
     * @param params
     * @return
     */
    public MapInfo getMapInfoByDistrict(Map<String, String> params) {
        setUpColorPlots();  // Set MapInfo defaults

        MapInfo mapInfo = new MapInfo();
        mapInfo.setType(this.featureType);
        mapInfo.setFeatures(getFeature(params)); // Sets GeoJson Features

        return mapInfo;
    }
    /**
     * Sets the feature element
     *
     * @param params
     * @return
     */
    private List<Feature> getFeature(Map<String, String> params) {
        Feature f = new Feature();
        List<Feature> features = new ArrayList<>();

        f.setType(params.get("Feature"));
        f.setProperties(getProperties(params));
        f.setGeometry(getGeometry(params));

        features.add(f);

        return features;
    }

    /**
     * Sets the feature element of many
     *
     * @param paramsOfMany
     * @return
     */
    private List<Feature> getFeatures(List<Map<String, String>> paramsOfMany) {
        List<Feature> features = new ArrayList<>();
        for(Map<String, String> params: paramsOfMany)
        {
            Feature f = new Feature();
            f.setType(params.get("Feature"));
            f.setProperties(getProperties(params));
            f.setGeometry(getGeometry(params));
            features.add(f);
        }


        return features;
    }
    private Property getProperties(Map<String, String> params) {
        Property p = new Property();
        p.setBorough(params.get("borough"));
        p.setDescription("London Borough of " + params.get("borough"));
        p.setColour(plotColours.get(params.get("datatype")));
        p.setValue(Double.parseDouble(params.get("value")));
        p.setDataType(params.get("datatype"));


        return p;
    }

    private List<String> getLines(Map<String, String> params) {
        String colour = plotColours.get(params.get("dataset"));

        List<String> lines = new ArrayList<>();
        lines.add(colour);

        return lines;
    }

    /**
     * Get Geometry information
     *
     * @param params
     * @return
     */
    public Geometry getGeometry(Map<String, String> params) {
        Geometry geometry = new Geometry();
        geometry.setType(params.get("Point"));
        geometry.setCoordinates(getCoordinates(params));

        return geometry;
    }

    /**
     * Gets Coordinates from Geo-location
     *
     * @param params
     * @return List<String>
     */
    private List<Double> getCoordinates(Map<String, String> params) {
        List<Double> coordinates = new ArrayList<>();

        coordinates.add(Double.parseDouble(params.get("longitude")));
        coordinates.add(Double.parseDouble(params.get("latitude")));

        return coordinates;
    }


}

