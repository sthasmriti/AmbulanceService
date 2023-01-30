package com.aggregrator.ambulanceservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Table
@Entity(name = "address_tbl")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String province;
    private String city;
    private String address;

    @OneToOne(mappedBy = "address")
    private Ambulance ambulance;
}
