package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AnimalRepo extends JpaRepository<Animal, Integer> {

    //Hayvanlar isme göre filtreler (Question 13)
    List<Animal> findByName(String name);

    //Girilen hayvan sahibinin sistemde kayıtlı tüm hayvanlarını görüntüleme (Question 14)
    List<Animal> findByCustomerId(int id);
    List<Animal> findByNameAndSpeciesAndBreedAndGender(String name,String species,String breed,Animal.GENDER gender);
}
