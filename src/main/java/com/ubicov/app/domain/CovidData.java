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
public class CovidData {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String ladCode;
    private String district;
    private long newCases;
    private long newDeaths;

    public CovidData(Long id, LocalDate date, String ladCode, String district, long newCases, long newDeaths) {
        this.id = id;
        this.date = date;
        this.ladCode = ladCode;
        this.district = district;
        this.newCases = newCases;
        this.newDeaths = newDeaths;

    }
}
