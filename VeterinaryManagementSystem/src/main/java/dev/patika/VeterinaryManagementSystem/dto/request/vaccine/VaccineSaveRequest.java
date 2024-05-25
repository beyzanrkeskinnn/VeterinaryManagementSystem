package dev.patika.VeterinaryManagementSystem.dto.request.vaccine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineSaveRequest {

    @NotNull(message = "Lütfen aşı ismi giriniz")
    private String name;

    @NotNull(message = "Lütfen aşının kodunu giriniz")
    private String code;

    @NotNull(message = "Lütfen aşı başlangıç tarihini giriniz")
    private LocalDate protectionStrtDate;

    @NotNull(message = "Lütfen aşı bitiş tarihini giriniz")
    private LocalDate protectionFnshDate;

    private Integer animalId;
}
