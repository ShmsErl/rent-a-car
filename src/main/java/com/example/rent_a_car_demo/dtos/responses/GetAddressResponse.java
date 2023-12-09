package com.example.rent_a_car_demo.dtos.responses;

import com.example.rent_a_car_demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressResponse {

    private String address;

    private String country;

    private String region;

    private String city;

    private String zipCode;

    private GetUserResponse username;


}