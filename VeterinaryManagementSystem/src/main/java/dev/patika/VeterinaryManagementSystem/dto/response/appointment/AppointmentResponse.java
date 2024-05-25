package dev.patika.VeterinaryManagementSystem.dto.response.appointment;

import dev.patika.VeterinaryManagementSystem.entity.Animal;
import dev.patika.VeterinaryManagementSystem.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private int id;
    private LocalDateTime dateTime;
    private Animal animal;
    private Doctor doctor;
}
