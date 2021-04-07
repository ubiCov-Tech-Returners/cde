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
    int total_furloughed;
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String ladCode;
    private String district;
    private LocalDate date;
    private int female_furloughed;
    private int male_furloughed;

    public Furlough(String ladCode, String district, LocalDate date, int female_furloughed, int male_furloughed, int total_furloughed) {
        this.ladCode = ladCode;
        this.district = district;
        this.date = date;
        this.female_furloughed = female_furloughed;
        this.male_furloughed = male_furloughed;
        this.total_furloughed = total_furloughed;
    }
}
