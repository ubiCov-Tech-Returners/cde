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
public class Deprivation {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String ladCode;
    private String district;
    private double incDepAffectingChildren;
    private double incDepAffectingOldPeople;
    private LocalDate date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "ladCode", insertable = false, updatable = false)
    private GeoLocation loc;

    public Deprivation(String ladCode, String district, double incDepAffectingChildren, double incDepAffectingOldPeople, LocalDate date) {
        this.ladCode = ladCode;
        this.district = district;
        this.incDepAffectingChildren = incDepAffectingChildren;
        this.incDepAffectingOldPeople = incDepAffectingOldPeople;
        this.date = date;

    }
}