/**
 * @Author Richard Renaud, Carmen Lara
 * models
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
