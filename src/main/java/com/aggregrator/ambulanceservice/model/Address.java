package com.aggregrator.ambulanceservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor


@Table
@Entity(name = "address_tbl")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @Getter
    private String province;
    @Getter
    private String city;
    @Getter
    private String address;

    @OneToOne(mappedBy = "address")
    private Ambulance ambulance;

    public Address(String province, String city, String address) {

        this.province=province;
        this.city=city;
        this.address=address;

    }
}
