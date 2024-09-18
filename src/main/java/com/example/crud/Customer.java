package com.example.crud;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    private Long customerId;
    private String companyName;
    private String contactName;

    // One customer can have many orders
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    // Constructors, Getters, and Setters
    public Customer() {}

    // Custom constructor to accept customerId, companyName, and contactName
    public Customer(Long customerId, String companyName, String contactName) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.contactName = contactName;
    }

    public Customer(String companyName, String contactName) {
        this.companyName = companyName;
        this.contactName = contactName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}

