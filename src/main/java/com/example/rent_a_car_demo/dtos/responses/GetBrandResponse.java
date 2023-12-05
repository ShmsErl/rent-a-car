package com.example.rent_a_car_demo.dtos.responses;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
public class GetBrandResponse {
    private String name;

    public GetBrandResponse(String name) {
        this.name = name;
    }
}
