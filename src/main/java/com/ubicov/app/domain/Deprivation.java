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
public class Deprivation {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String ladCode;
    private String district;
    //IDACI - Average rank
    private double incDepAffectingChildren;
    //IDAOPI - Average rank
    private double incDepAffectingOldPeople;
    private LocalDate date;

    public Deprivation(String ladCode, String district, double incDepAffectingChildren, double incDepAffectingOldPeople, LocalDate date) {
        this.ladCode = ladCode;
        this.district = district;
        this.incDepAffectingChildren = incDepAffectingChildren;
        this.incDepAffectingOldPeople = incDepAffectingOldPeople;
        this.date = date;

    }
}