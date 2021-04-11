package com.ubicov.app.domain;

import lombok.*;

import javax.persistence.Column;
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
    int total_furloughed;
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ladCode", insertable = false, updatable = false)
    private String ladCode;
    private String district;
    private LocalDate date;
    private int female_furloughed;
    private int male_furloughed;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "lad_code_fur")
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
