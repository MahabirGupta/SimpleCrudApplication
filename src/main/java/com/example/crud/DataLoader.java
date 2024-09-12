package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insert predefined customer data
        customerRepository.save(new Customer(1L, "SG Pte.Ltd", "Jose Pavarotti"));
        customerRepository.save(new Customer(2L, "Don Pte.Ltd", "Maria Larsson"));
        customerRepository.save(new Customer(3L, "Star Pte.Ltd", "Roland Mendel"));
        customerRepository.save(new Customer(4L, "JB Pte.Ltd", "Elizabeth Lincoln"));
        customerRepository.save(new Customer(5L, "Vera Pte.Ltd", "Horst Kloss"));
        customerRepository.save(new Customer(6L, "BSA Pte.Ltd", "Felipe Izquierdo"));
        customerRepository.save(new Customer(7L, "ABC Pte.Ltd", "José Pedro Freyre"));
        customerRepository.save(new Customer(8L, "HIJ Pte.Ltd", "Mario Pontes"));
        customerRepository.save(new Customer(9L, "XYZ Pte.Ltd", "Carlos Hernández"));
        customerRepository.save(new Customer(10L, "RST Pte.Ltd", "Laurence Lebihan"));
        customerRepository.save(new Customer(11L, "EGD Pte.Ltd", "David Koh"));
        customerRepository.save(new Customer(12L, "FPT Pte.Ltd", "William Chan"));
        customerRepository.save(new Customer(13L, "RST Pte.Ltd", "Ben Goh"));
        customerRepository.save(new Customer(14L, "CDA Pte.Ltd", "Ryan Giggs"));
        customerRepository.save(new Customer(15L, "ManU Pte.Ltd", "Alex Ferguson"));
        System.out.println("Customers have been added successfully!");
    }
}
