/**
 * @Author - Richard Renaud, Carmen Lara
 * This Object will be used to generate GeoJson code.  This is not a persisted entity
 * and it will be populated using OTHER DATA sets which are available to this system.
 * <p>
 * e.g.  The OTHER DATA has been stored on a DBMS which this system is granted access.
 * This class is a subclass of the 'Feature' class.
 */
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
