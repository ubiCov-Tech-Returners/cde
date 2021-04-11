/**
 * @Author - Richard Renaud
 * Manually inferred model of London Borough geo-locations.
 * This Object will be used in conjunction with OTHER DATA where the OTHER DATA does
 * not contain Longitude / Latitude information.
 * <p>
 * e.g.  The OTHER DATA has been filtered by London Borough and the dataSet omits locational
 * information.
 *
 * NOTE: A table join is NOT suitable in this case as too many foreign_keys will need to
 * be added to gelocation table
 */
package com.ubicov.app.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GeoLocation {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String ladCode;
    private String district;
    private String longitude;
    private String latitude;

    public GeoLocation(String ladCode, String district, String longitude, String latitude) {
        this.ladCode = ladCode;
        this.district = district;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
