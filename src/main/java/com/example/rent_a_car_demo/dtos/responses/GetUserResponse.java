package com.example.rent_a_car_demo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

@NoArgsConstructor
public class GetUserResponse {


    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phone;

    private String gender;

    private Date birthDate;

    public GetUserResponse(String firstName, String lastName, String username, String email, String phone, String gender, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
    }
}
