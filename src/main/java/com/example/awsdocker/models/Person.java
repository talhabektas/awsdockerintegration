package com.example.awsdocker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // int yerine Integer kullanın
    private String name;
    private String address;

    // Getter ve setter'ları manuel olarak ekleyin
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}