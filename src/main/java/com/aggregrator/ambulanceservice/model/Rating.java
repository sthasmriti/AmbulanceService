package com.aggregrator.ambulanceservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Table
@Entity(name = "rating_tbl")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="fk_ambulance_id")
    private Ambulance ambulance;

    private String value;

    public Rating(Ambulance ambulance, String value) {
        this.ambulance = ambulance;
        this.value = value;
    }
}
