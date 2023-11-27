package com.example.rent_a_car_demo.dtos.requests;

import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.models.Payment;
import com.example.rent_a_car_demo.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {



    private Date rentalStartDate;

    private Date rentalEndDate;

    private Double totalCost;

    private Employee employee;

    private User user;

    private Car car;

}
