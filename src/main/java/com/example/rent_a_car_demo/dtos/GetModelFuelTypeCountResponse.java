package com.example.rent_a_car_demo.dtos;

public class GetModelFuelTypeCountResponse {

    private String fuelType;
    private Long count;

    public GetModelFuelTypeCountResponse() {
    }

    public GetModelFuelTypeCountResponse(String fuelType, Long count) {
        this.fuelType = fuelType;
        this.count = count;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
