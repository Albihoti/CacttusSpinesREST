package com.example.springbootproject.repository;

import com.example.springbootproject.model.Perdoruesi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PerdoruesitRepository  extends JpaRepository<Perdoruesi, Integer> {

    Optional<Perdoruesi> findByUsername(String username);
    Optional<Perdoruesi> findByEmail(String email);

    Optional<Perdoruesi> findById(Integer id);
}
