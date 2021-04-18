/**
 * @Author - Richard Renaud, Urmila Mathew, Carmen Lara
 * Manually inferred model of London Borough covid.
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
public class CovidData {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String ladCode;
    private String district;
    private long newCases;
    private long newDeaths;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "ladCode", insertable = false, updatable = false)
    private GeoLocation loc;

    public CovidData(Long id, LocalDate date, String ladCode, String district, long newCases, long newDeaths) {
        this.id = id;
        this.date = date;
        this.ladCode = ladCode;
        this.district = district;
        this.newCases = newCases;
        this.newDeaths = newDeaths;

    }
}
