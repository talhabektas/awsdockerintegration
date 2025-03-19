package com.example.awsdocker.repository;

import com.example.awsdocker.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
