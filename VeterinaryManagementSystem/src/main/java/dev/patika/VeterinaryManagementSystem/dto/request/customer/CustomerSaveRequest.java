package dev.patika.VeterinaryManagementSystem.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    @NotNull(message = "Lütfen isim giriniz")
    private String name;

    @NotNull(message = "Lütden telefon numarası giriniz")
    @Size(min = 11, max = 11, message = "Lütfen 11 haneli telefon numarası giriniz ")
    private String phone;

    @NotNull(message = "Lütfen mail giriniz")
    @Email
    private String mail;

    @NotNull(message = "Lütfen adres giriniz")
    private String address;

    @NotNull(message = "Lütfen şehir giriniz")
    private String city;
}
