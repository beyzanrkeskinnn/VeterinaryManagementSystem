package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entity.AvailableDate;
import dev.patika.VeterinaryManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Integer> {
    List<AvailableDate> findByDateAndDoctorId(LocalDate availableDate, Integer doctorId);
}
