package com.example.springbootproject.service;

import com.example.springbootproject.model.Perdoruesi;
import com.example.springbootproject.model.PerdoruesiDto;
import com.example.springbootproject.repository.PerdoruesitRepository;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
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




    public  Perdoruesi getPerdoruesiById(Integer id){
        Optional<Perdoruesi> optionalPerdoruesi = repository.findById(id);
        if(optionalPerdoruesi.isPresent()){
            return optionalPerdoruesi.get();
        }
        else{
            return null;
        }
    }




    public ResponseEntity<Perdoruesi> getProfile(Integer id){
        Perdoruesi perdoruesi1 = getPerdoruesiById(id);

        return ResponseEntity.ok(perdoruesi1);
    }




    public ResponseEntity<PerdoruesiDto> login(Perdoruesi perdoruesi){
        Perdoruesi savedPerdoruesi = getPerdoruesiByUsername(perdoruesi.getUsername());
            PerdoruesiDto dtoPerdoruesi = new PerdoruesiDto();
        if(savedPerdoruesi!=null){
            if(perdoruesi.getPassword().equals(savedPerdoruesi.getPassword())){
                dtoPerdoruesi.setMessage(true);
                dtoPerdoruesi.setEmail(savedPerdoruesi.getEmail());
                dtoPerdoruesi.setUsername(savedPerdoruesi.getUsername());
                dtoPerdoruesi.setId(savedPerdoruesi.getId());
                System.out.println("Jeni lloguar me sukses!!");
                return ResponseEntity.ok(dtoPerdoruesi);
            }
            else{
                dtoPerdoruesi.setMessage(false);
                System.out.println("gabim kredintials");
                return ResponseEntity.ok(dtoPerdoruesi);
            }
        }
        else{
            dtoPerdoruesi.setMessage(false);
            System.out.println("Not found");
            return ResponseEntity.ok(dtoPerdoruesi);
        }
    }





    public ResponseEntity<PerdoruesiDto> registerNewAccount(PerdoruesiDto p){
        PerdoruesiDto perdoruesiDto = new PerdoruesiDto();
        if(!(repository.findByUsername(p.getUsername()).isPresent() || repository.findByEmail(p.getEmail()).isPresent())) {
                Perdoruesi perdoruesi = new Perdoruesi();
                perdoruesi.setUsername(p.getUsername());
                perdoruesi.setEmail(p.getEmail());
                perdoruesi.setPassword(p.getPassword());
                repository.save(perdoruesi);

                perdoruesiDto.setMessage(true);
                perdoruesiDto.setId(perdoruesi.getId());
                System.out.println("Perdoruesi u krijua me sukses!!!");
                return ResponseEntity.ok(perdoruesiDto);
        }
        else{
            System.out.println("User exists");
            perdoruesiDto.setMessage(false);

            return ResponseEntity.ok(perdoruesiDto);
        }
        }





        public ResponseEntity<Perdoruesi> updateUser(PerdoruesiDto p, Integer id){

                    Perdoruesi perdoruesi = getPerdoruesiById(id);

                    perdoruesi.setUsername(p.getUsername());
                    perdoruesi.setEmail(p.getEmail());
                    perdoruesi.setPassword(p.getPassword());
                    repository.save(perdoruesi);
                    return ResponseEntity.ok(perdoruesi);

        }
    }

 


