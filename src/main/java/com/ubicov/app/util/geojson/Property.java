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

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Property {

    String borough;
    String description;
    double value;
    String dataType;
    String colour;
    double percentageOfTotal; //This is for the scatterchart

    public Property(String borough, String description, double value, String dataType, String colour,double percentageOfTotal) {
        this.borough = borough;
        this.description = description;
        this.value = value;
        this.dataType = dataType;
        this.colour = colour;
        this.percentageOfTotal = percentageOfTotal;
    }
}
