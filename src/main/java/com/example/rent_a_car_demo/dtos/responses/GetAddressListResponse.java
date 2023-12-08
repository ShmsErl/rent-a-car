package com.example.rent_a_car_demo.dtos.responses;

import com.example.rent_a_car_demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@NoArgsConstructor
public class GetAddressListResponse {

    private String address;

    private String country;

    private String region;

    private String city;

    private String zipCode;

    private String username;

    public GetAddressListResponse(String address, String country, String region, String city,String zipCode, String username){
        this.address = address;
        this.country = country;
        this.region = region;
        this.city = city;
        this.zipCode = zipCode;
        this.username = username;

    }


}
