package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Integer> {

    //Belirli bir hayvana ait tüm aşı kayıtları listeler (Question 24)
    List<Vaccine> findByAnimalId(int id);
    //Aşı koruyuculuk bitiş tarihine göre filtreleme(Question 23)
    List<Vaccine> findByprotectionFnshDateBetween(LocalDate entryDate, LocalDate exitDate);
    List<Vaccine> findByCodeAndName(String code, String name);
}
