package dev.patika.VeterinaryManagementSystem.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateRequest {
    @Positive(message = "ID pozitif olmalı")
    @NotNull(message = "Doktor Id boş olamaz")
    private int id;
    @NotNull(message = "Doktor ismi boş olamaz")
    private String name;
    @NotNull(message = "Doktor telefonu boş olamaz")
    @Size(min = 11, max = 11, message = "Lütfen 11 haneli telefon numarası giriniz ")
    private String phone;
    @Email
    @NotNull(message = "Doktor maili boş olamaz")
    private String mail;
    @NotNull(message = "Doktor adresi boş olamaz")
    private String address;
    @NotNull(message = "Doktor şehri boş olamaz")
    private String city;
}
