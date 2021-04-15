package com.ubicov.app.util.geojson;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Geometry {
    String type;
    List<String> coordinates;
//    String ladCode;

    public Geometry(String type, List<String> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }
}
