package com.example.person.repository;

import com.example.person.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<PersonModel, Long> {

}
