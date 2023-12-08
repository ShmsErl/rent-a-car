package com.example.rent_a_car_demo.dtos.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class GetCarTypeResponse {
    private String name;

    public GetCarTypeResponse(String name) {
        this.name = name;
    }
}
