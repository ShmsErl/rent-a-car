package com.example.rent_a_car_demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandNameWithModelNameDto {
    private String brandName;
    private String modelName;
}
