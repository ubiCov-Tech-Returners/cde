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
public class Property {
    String description;
    String makerSymbol;
    String title;
    String url;
    List<String> lines;
    String address;

    public Property(String description, String makerSymbol, String title, String url, List<String> lines, String address) {
        this.description = description;
        this.makerSymbol = makerSymbol;
        this.title = title;
        this.url = url;
        this.lines = lines;
        this.address = address;
    }
}
