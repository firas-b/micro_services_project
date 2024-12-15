package com.example.userservice.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
public class Address {

    private String country;
    private String street;
    private String city;
    private String state;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String zip;
}
