package com.ubicov.app.util.geojson;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MapInfo {
    String type;
    List<Feature> features;

    public MapInfo(String type, List<Feature> features) {
        this.type = type;
        this.features = features;
    }
}
