package com.ubicov.app.util.geojson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoJsonGenerator {
    private final String featureType = "FeatureCollection";
    private final String markerSymbol = "rail-metro";
    private final String url = "http://localhost:3000";  //TODO - change this
    private Map<String, String> plotColours = new HashMap<>();

    //Default No Args constructor
    public GeoJsonGenerator() {
    }

    // Sets the plotting colours of the datasets
    public void setUpColorPlots() {
        // Set map plotting colours
        plotColours.put("covid", "red");
        plotColours.put("vaccination", "yellow");
        plotColours.put("furlough", "blue");
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
        mapInfo.setType(params.get("featureType"));
        mapInfo.setFeatures(getFeature(params));

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

        f.setGeometry(getGeometry(params));
        f.setType(params.get("feature"));
        f.setProperties(getProperties(params));

        features.add(f);

        return features;
    }

    private Property getProperties(Map<String, String> params) {
        Property p = new Property();
        p.setDescription(params.get("district"));
        p.setMakerSymbol(this.markerSymbol);
        p.setUrl(this.url);
        p.setTitle("London Borough of " + params.get("district"));
        p.setLines(getLines(params));
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
        geometry.setType(params.get("geoType"));
        geometry.setCoordinates(getCoordinates(params));

        return geometry;
    }

    /**
     * Gets Coordinates from Geo-location
     *
     * @param params
     * @return List<String>
     */
    private List<String> getCoordinates(Map<String, String> params) {
        List<String> coordinates = new ArrayList<>();

        coordinates.add(params.get("longitude"));
        coordinates.add(params.get("latitude"));

        return coordinates;
    }


}

