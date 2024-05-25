package dev.patika.VeterinaryManagementSystem.dto.request.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {

    @Positive(message = "Lütfen id değeri positif giriniz")
    @NotNull(message = "Lütfen id değeri giriniz")
    private int id;

    @NotNull(message = "Lütfen bir tarih giriniz")
    private LocalDateTime dateTime;

    @Positive(message = "Lütfen id değeri positif giriniz")
    @NotNull(message = "Lütfen id değeri giriniz")
    private Integer animalId;

    @Positive(message = "Lütfen id değeri positif giriniz")
    @NotNull(message = "Lütfen id değeri giriniz")
    private Integer doctorId;
}
