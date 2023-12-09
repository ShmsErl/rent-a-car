package com.example.rent_a_car_demo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class GetBrandListResponse {
    private String name;

    public GetBrandListResponse(String name) {
        this.name = name;
    }
}
