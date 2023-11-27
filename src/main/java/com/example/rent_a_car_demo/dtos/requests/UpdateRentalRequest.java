package com.example.rent_a_car_demo.dtos.requests;

import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {


    private  int id;
    private Date rentalStartDate;

    private Date rentalEndDate;

    private Double totalCost;

    private Employee employee;

    private User user;

    private Car car;

}