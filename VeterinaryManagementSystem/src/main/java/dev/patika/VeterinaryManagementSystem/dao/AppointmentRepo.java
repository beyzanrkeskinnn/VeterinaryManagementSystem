package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByDateTime(LocalDateTime localDateTime);

    //Randevular kullanıcı tarafından girilen tarih aralığına ve doktora göre filtrelenir (Question 20)
    List<Appointment> findByDoctorIdAndDateTimeBetween(int id, LocalDateTime entryDate, LocalDateTime exitDate);

    //Randevular kullanıcı tarafından girilen tarih aralığına ve hayvana göre filtrelenir (Question 19)
    List<Appointment> findByAnimalIdAndDateTimeBetween(int id, LocalDateTime entryDate, LocalDateTime exitDate);
    Optional<Appointment> findByDateTimeAndDoctorIdAndAnimalId(LocalDateTime dateTime, Integer doctorId, Integer animalId);
}
