package dev.patika.VeterinaryManagementSystem.dto.response.animal;

import dev.patika.VeterinaryManagementSystem.entity.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private int id;
    private String name;
    private String species;
    private String breed;
    private Animal.GENDER gender;
    private String color;
    private LocalDate birthday;
    private Integer customerId;
}
