package com.aggregrator.ambulanceservice.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AddressDTO {
    @NotNull
    @NotEmpty
    private String province;
    private String city;
    private String address;
}
