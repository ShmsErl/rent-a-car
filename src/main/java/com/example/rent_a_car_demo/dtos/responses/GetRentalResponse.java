package com.example.rent_a_car_demo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalResponse {

    private Date rentalStartDate;

    private Date rentalEndDate;

    private Double totalCost;

    private String employeeName;

    private String userName;

    private String carName;

}
