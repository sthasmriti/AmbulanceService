package com.aggregrator.ambulanceservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Table
@Entity(name = "ambulance_tbl")
public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    private String name;
//    private List<String> phones;
    @Setter
    private double lat;
    @Setter
    private double lon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @Column(name = "is_opened")
    @Setter
    private boolean isOpened;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    public Ambulance(String name, double lat, double lon, boolean opened,LocalDateTime createdOn) {
        this.name= name;
        this.lat=lat;
        this.lon=lon;
        this.isOpened=isOpened;
        this.createdOn=createdOn;
    }



}
