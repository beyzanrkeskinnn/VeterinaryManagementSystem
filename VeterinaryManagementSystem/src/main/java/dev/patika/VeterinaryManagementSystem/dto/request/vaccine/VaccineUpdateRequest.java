package dev.patika.VeterinaryManagementSystem.dto.request.vaccine;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineUpdateRequest {

    @Positive(message = "ID pozitif olmalı")
    @NotNull(message = "Lütfen bir aşı id'si giriniz")
    private int id;

    @NotNull(message = "Lütfen aşı ismi giriniz")
    private String name;

    @NotNull(message = "Lütfen aşının kodunu giriniz")
    private String code;

    @NotNull(message = "Lütfen aşının başlangıç tarihini giriniz")
    private LocalDate protectionStrtDate;

    @NotNull(message = "Lütfen aşı bitiş tarihini giriniz")
    private LocalDate protectionFnshDate;

    private Integer animalId;
}
