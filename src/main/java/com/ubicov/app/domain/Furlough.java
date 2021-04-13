/**
 * @Author - Richard Renaud
 * Manually inferred model of London Borough furlough.
 * This Object will be used in conjunction with OTHER DATA where the OTHER DATA does
 * not contain Longitude / Latitude information.
 * <p>
 * e.g.  The OTHER DATA has been filtered by London Borough and the dataSet omits locational
 * information.
 */
package com.ubicov.app.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Furlough {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private int total_furloughed;
    private String ladCode;
    private String district;
    private LocalDate date;
    private int female_furloughed;
    private int male_furloughed;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "ladCode", insertable = false, updatable = false)
    private GeoLocation loc;

    public Furlough(String ladCode, String district, LocalDate date, int female_furloughed, int male_furloughed, int total_furloughed) {
        this.ladCode = ladCode;
        this.district = district;
        this.date = date;
        this.female_furloughed = female_furloughed;
        this.male_furloughed = male_furloughed;
        this.total_furloughed = total_furloughed;
    }
}
