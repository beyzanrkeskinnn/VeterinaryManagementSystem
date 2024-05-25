package dev.patika.VeterinaryManagementSystem.dto.request.animal;

import dev.patika.VeterinaryManagementSystem.entity.Animal;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalSaveRequest {
    @NotNull(message = "Lütfen hayvan ismi giriniz")
    private String name;

    @NotNull(message = "Lütfen hayvanın cinsini giriniz")
    private String species;

    @NotNull(message = "Lütfen hayvanın türünüz giriniz")
    private String breed;

    @NotNull(message = "Lütfen hayvanın cinsiyetini giriniz")
    private Animal.GENDER gender;

    @NotNull(message = "Lütfen hayvanın rengini giriniz")
    private String color;

    @NotNull(message = "Lütfen hayvanın doğum tarihini giriniz")
    private LocalDate birthday;

    private Integer  customerId;
}
