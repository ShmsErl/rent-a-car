package com.example.rent_a_car_demo.dtos.requests;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotNull(message = "Yıl bilgisi boş olamaz")
    @Min(value = 1900, message = "Geçerli bir yıl giriniz")
    private Integer year;

    @NotBlank(message = "Renk bilgisi boş olamaz")
    private String color;

    @NotNull(message = "Kira ücreti boş olamaz")
    @Positive(message = "Geçerli bir pozitif kira ücreti giriniz")
    private Double rentalFee;

    @NotBlank (message = "Plaka bilgisi boş olamaz")
    @Pattern(regexp = "[A-Z0-9]{1,10}", message = "Geçerli bir plaka giriniz (en fazla 10 karakter, büyük harf ve rakamlardan oluşmalı)")
    private String licencePlate;
}
