package com.example.rent_a_car_demo.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    @NotBlank(message = "Ad bilgisi boş olamaz")
    private String firstName;

    @NotBlank(message = "Soyad bilgisi boş olamaz")
    private String lastName;

    @NotBlank(message = "Kullanıcı adı boş olamaz")
    @Size(min = 4, max = 20, message = "Kullanıcı adı 4 ile 20 karakter arasında olmalıdır")
    private String username;

    @NotBlank(message = "Şifre bilgisi boş olamaz")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    private String password;

    @NotBlank(message = "E-posta bilgisi boş olamaz")
    @Email(message = "Geçerli bir e-posta adresi giriniz")
    private String email;

    @NotBlank(message = "Telefon bilgisi boş olamaz")
    @Pattern(regexp = "\\d{10}", message = "Geçerli bir telefon numarası giriniz (10 rakam)")
    private String phone;

    @NotBlank(message = "Cinsiyet bilgisi boş olamaz")
    private String gender;

    @NotNull(message = "Doğum tarihi bilgisi boş olamaz")
    @Past(message = "Geçerli bir geçmiş tarih giriniz")
    private LocalDate birthDate;
}
