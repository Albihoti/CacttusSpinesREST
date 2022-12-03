package com.example.springbootproject.service;

import com.example.springbootproject.model.Perdoruesi;
import com.example.springbootproject.model.PerdoruesiDto;
import com.example.springbootproject.repository.PerdoruesitRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PerdoruesiService  {
    public final PerdoruesitRepository repository;
    EntityManager entityManager;


    public PerdoruesiService(PerdoruesitRepository perdoruesitRepository ) {
        this.repository = perdoruesitRepository;

    }



    public Perdoruesi getPerdoruesiByUsername(String username){
        Optional<Perdoruesi> optionalPerdoruesi = repository.findByUsername(username);
        if(optionalPerdoruesi.isPresent()){
            return optionalPerdoruesi.get();
        }
        else{
            return null;
        }
    }
    public ResponseEntity<Perdoruesi> login(Perdoruesi perdoruesi){
        Perdoruesi savedPerdoruesi = getPerdoruesiByUsername(perdoruesi.getUsername());
        if(savedPerdoruesi!=null){
            if(perdoruesi.getPassword().equals(savedPerdoruesi.getPassword())){
                return ResponseEntity.ok(savedPerdoruesi);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            }
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    public Perdoruesi registerNewAccount(Perdoruesi p){
        Perdoruesi perdoruesi = new Perdoruesi();
        perdoruesi.setId(p.getId());
        perdoruesi.setUsername(p.getUsername());
        perdoruesi.setEmail(p.getEmail());
        perdoruesi.setPassword(p.getPassword());

        return repository.save(perdoruesi);
    }

 

}
