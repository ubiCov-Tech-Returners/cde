
package com.ubicov.app.util.geojson;
/*This Object will be used to generate GeoJson code.  This is not a persisted entity
       and it will be populated using OTHER DATA sets which are available to this system.
        <p>
         e.g.  The OTHER DATA has been stored on a DBMS which this system is granted access*/


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Feature{
    Geometry geometry;
    String type;
    Property properties;

    public Feature(Geometry geometry, String type, Property properties) {
        this.geometry = geometry;
        this.type = type;
        this.properties = properties;
    }
}