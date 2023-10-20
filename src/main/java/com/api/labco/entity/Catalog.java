package com.api.labco.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "img_path")
    private String imgPath;
    @Column(name = "createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Catalog(String title,String imgPath) {
        this.title = title;
        this.imgPath = imgPath;
    }
    public Catalog(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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
