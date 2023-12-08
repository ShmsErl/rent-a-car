package com.example.rent_a_car_demo.dtos.requests;

import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.models.Payment;
import com.example.rent_a_car_demo.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {



    @FutureOrPresent(message = "Geçerli veya gelecekte bir tarih giriniz")
    private Date rentalStartDate;

    @NotNull(message = "Kiralama bitiş tarihi boş olamaz")
    @Future(message = "Gelecekte bir tarih giriniz")
    private Date rentalEndDate;

    @NotNull(message = "Toplam maliyet bilgisi boş olamaz")
    @Positive(message = "Geçerli bir pozitif maliyet giriniz")
    private Double totalCost;

    @NotNull(message = "Çalışan bilgisi boş olamaz")
    private Employee employee;

    @NotNull(message = "Kullanıcı bilgisi boş olamaz")
    private User user;

    @NotNull(message = "Araç bilgisi boş olamaz")
    private Car car;


}
