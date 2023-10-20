package com.api.labco.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class ContactUs {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "company_name")
    private String company_name;
    @Column(name = "email")
    private String email;
    @Column(name = "message")
    private String message;
    @Column(name = "createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public ContactUs(String name, String phoneNumber, String company_name, String email, String message, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.company_name = company_name;
        this.email = email;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ContactUs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
