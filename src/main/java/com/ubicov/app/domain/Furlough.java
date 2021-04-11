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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "lad_code_fur")
//    @OneToOne(targetEntity = GeoLocation.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="lad_code_fk", referencedColumnName = "ladCode")
//    private GeoLocation loc;

    public Furlough(String ladCode, String district, LocalDate date, int female_furloughed, int male_furloughed, int total_furloughed) {
        this.ladCode = ladCode;
        this.district = district;
        this.date = date;
        this.female_furloughed = female_furloughed;
        this.male_furloughed = male_furloughed;
        this.total_furloughed = total_furloughed;
    }
}
