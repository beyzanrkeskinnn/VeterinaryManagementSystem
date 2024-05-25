package dev.patika.VeterinaryManagementSystem.dto.request.animal;

import dev.patika.VeterinaryManagementSystem.entity.Animal;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalUpdateRequest {

    @Positive(message = "Lütfen hayvan id değerini positif giriniz")
    @NotNull(message = "Lütfen hayvan id giriniz")
    private int id;

    @NotNull(message = "Lütfen hayvan ismi giriniz")
    private String name;

    @NotNull(message = "Lütfen hayvan cinsini giriniz")
    private String species;

    @NotNull(message = "Lütfen hayvan türünü giriniz")
    private String breed;

    @NotNull(message = "Lütfen hayvan cinsiyetini giriniz")
    private Animal.GENDER gender;

    @NotNull(message = "Lütfen hayvan rengini giriniz")
    private String color;

    @NotNull(message = "Lütfen hayvanın doğum tarihini giriniz")
    private LocalDate birthday;
    private int customerId;
}
