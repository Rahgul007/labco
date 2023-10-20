package com.api.labco.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class ContactSupport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "fax_number")
    private String faxNumber;
    @Column(name = "address")
    private String Address;
    @Column(name = "email")
    private String email;
    @Column(name = "website_url")
    private String websiteUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_support_type")
    private ContactSupportType contactSupportType;
    @Column(name = "createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public ContactSupport(String telephoneNumber, String faxNumber, String address, String email, String websiteUrl, ContactSupportType contactSupportType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.telephoneNumber = telephoneNumber;
        this.faxNumber = faxNumber;
        this.Address = address;
        this.email = email;
        this.websiteUrl = websiteUrl;
        this.contactSupportType = contactSupportType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ContactSupport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public ContactSupportType getContactSupportType() {
        return contactSupportType;
    }

    public void setContactSupportType(ContactSupportType contactSupportType) {
        this.contactSupportType = contactSupportType;
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
