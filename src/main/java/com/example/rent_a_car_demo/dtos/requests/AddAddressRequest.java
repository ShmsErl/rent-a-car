package com.example.rent_a_car_demo.dtos.requests;

import com.example.rent_a_car_demo.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    @NotBlank(message = "Adres boş olamaz")
    @Size(max = 255, message = "Adres en fazla 255 karakter olabilir")
    private String address;

    @NotBlank(message = "Ülke boş olamaz")
    private String country;

    @NotBlank(message = "Bölge boş olamaz")
    private String region;

    @NotBlank(message = "Şehir boş olamaz")
    private String city;

    @NotBlank(message = "Posta Kodu boş olamaz")
    @Pattern(regexp = "\\d{5}", message = "Geçerli bir posta kodu giriniz (5 haneli)")
    private String zipCode;

    @NotNull(message = "Kullanıcı bilgisi boş olamaz")
    private User user;
}
