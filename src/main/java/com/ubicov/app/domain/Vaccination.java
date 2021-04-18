/**
 * @Author - Richard Renaud, Urmila Mathew
 * Manually inferred model of London Borough vaccination.
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
public class Vaccination {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String ladCode;
    private String district;
    private int ageUnder50;
    private int age50To54;
    private int age55To59;
    private int age60To64;
    private int age65To69;
    private int age70To74;
    private int age75To79;
    private int ageOver80;
    private LocalDate date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "ladCode", insertable = false, updatable = false)
    private GeoLocation loc;

    public Vaccination(String ladCode, String district, int ageUnder50, int age50To54,
                       int age60To64, int age65To69, int age70To74, int age75To79, int ageOver80, LocalDate date) {
        this.ladCode = ladCode;
        this.district = district;
        this.ageUnder50 = ageUnder50;
        this.age50To54 = age50To54;
        this.age55To59 = age55To59;
        this.age60To64 = age60To64;
        this.age65To69 = age65To69;
        this.age70To74 = age70To74;
        this.age75To79 = age75To79;
        this.ageOver80 = ageOver80;
        this.date = date;

    }
}