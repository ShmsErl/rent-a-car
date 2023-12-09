package com.example.rent_a_car_demo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class GetModelResponse {

    private String name;

    private String fuelType;

    private String enginePower;

    private GetBrandResponse brand;

    public GetModelResponse(String name, String fuelType, String enginePower, GetBrandResponse brand) {
        this.name = name;
        this.fuelType = fuelType;
        this.enginePower = enginePower;
        this.brand = brand;
    }
}


