package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    //Hayvan sahipleri isme göre filtreler (Question 11)
    List<Customer> findByName(String name);

    List<Customer> findByNameAndMailAndPhone(String name, String mail, String phone);

    //Müşteriye ait email adresini kontrol eder
    boolean existsByMail(String email);

    //Müşteriye ait telefonu kontrol eder
    boolean existsByPhone(String phone);
}
