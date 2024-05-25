package dev.patika.VeterinaryManagementSystem.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {

    @NotNull(message = "Lütfen doktor isminiz giriniz")
    private String name;

    @NotNull(message = "Lütfen telefon numarası giriniz")
    @Size(min = 11, max = 11, message = "Lütfen 11 haneli telefon numarası giriniz ")
    private String phone;

    @NotNull(message = "Lütfen mail adresi giriniz")
    @Email
    private String mail;

    @NotNull(message = "Lütfen adres giriniz")
    private String address;

    @NotNull(message = "Lütfen şehir giriniz")
    private String city;
}
