package com.aggregrator.ambulanceservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "phone", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "phone")
    private List<String> phones;
    @Setter
    private double lat;
    @Setter
    private double lon;


    @OneToMany
    private List<Rating> ratings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @Column(name = "is_opened")
    @Setter
    private boolean isOpened;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    public Ambulance(String name, double lat, double lon, boolean opened,LocalDateTime createdOn,Address address,
                     List<String>phones) {
        this.name= name;
        this.lat=lat;
        this.lon=lon;
        this.isOpened=isOpened;
        this.createdOn=createdOn;
        this.address=address;
        this.phones=phones;

    }



}
