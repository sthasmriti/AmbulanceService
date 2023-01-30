package com.aggregrator.ambulanceservice.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AmbulanceDTO {
    @NotNull(message = "The name of the ambulance provider cannot be null")
    @NotEmpty
    private String name;
    @NotEmpty
    private List<String> phones;

    private double lat;
    private double lon;
    private AddressDTO address;
    private boolean isOpened;


}
