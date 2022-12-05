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
import java.util.UUID;

import static java.util.UUID.randomUUID;

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
                System.out.println("Jeni lloguar me sukses!!");
                return ResponseEntity.ok(savedPerdoruesi);

            }
            else{
                System.out.println("gabim kredintials");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            }
        }
        else{
            System.out.println("Not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    public ResponseEntity<Perdoruesi> registerNewAccount(PerdoruesiDto p){

        if(!repository.findByUsername(p.getUsername()).isPresent() ) {
            if (!repository.findByEmail(p.getEmail()).isPresent()) {
                System.out.println(!repository.findByUsername(p.getUsername()).isPresent());
                Perdoruesi perdoruesi = new Perdoruesi();
                perdoruesi.setId(p.getId());
                perdoruesi.setUsername(p.getUsername());
                perdoruesi.setEmail(p.getEmail());
                perdoruesi.setPassword(p.getPassword());
                repository.save(perdoruesi);
                System.out.println("Perdoruesi u krijua me sukses!!!");
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            System.out.println("User Exists");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


        }
        else{
            System.out.println("User exists");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }






        }



    }

 


