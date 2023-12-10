package com.example.rent_a_car_demo.dtos.requests;

import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.models.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {

    @NotBlank(message = "Ad bilgisi boş olamaz")
    private String name;

    @NotBlank(message = "Yakıt tipi bilgisi boş olamaz")
    private String fuelType;

    @NotBlank(message = "Motor gücü bilgisi boş olamaz")
    private String enginePower;


    private  Brand brand;


}
