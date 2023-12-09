package com.example.rent_a_car_demo.dtos.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetCarListResponse {
    private Integer year;
    private String color;
    private Double rentalFee;
    private String licencePlate;
    private GetModelResponse model;
    private GetCarTypeResponse carType;

    public GetCarListResponse(Integer year, String color, Double rentalFee, String licencePlate, GetModelResponse model, GetCarTypeResponse carType) {
        this.year = year;
        this.color = color;
        this.rentalFee = rentalFee;
        this.licencePlate = licencePlate;
        this.model = model;
        this.carType = carType;
    }
}
