package dev.patika.VeterinaryManagementSystem.dto.request.availableDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {
    @Positive(message = "Lütfen id değeri pozitif giriniz")
    @NotNull(message = "Lütfen id giriniz")
    private int id;
    @NotNull(message = "Lütfen tarih giriniz")
    private LocalDate date;
    private Integer doctorId;
}
