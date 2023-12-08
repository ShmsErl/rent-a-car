package com.example.rent_a_car_demo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetCarResponse {

    private Integer year;
    private String color;
    private Double rentalFee;
    private String licencePlate;
    private GetCarTypeResponse getCarTypeResponse;

    public GetCarResponse(Integer year, String color, Double rentalFee, String licencePlate, GetCarTypeResponse getCarTypeResponse) {
        this.year = year;
        this.color = color;
        this.rentalFee = rentalFee;
        this.licencePlate = licencePlate;
        this.getCarTypeResponse = getCarTypeResponse;
    }
}
