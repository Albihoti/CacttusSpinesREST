package com.example.springbootproject.controller;


import com.example.springbootproject.model.Perdoruesi;
import com.example.springbootproject.model.PerdoruesiDto;
import com.example.springbootproject.service.PerdoruesiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PerdoruesiController {
    public final PerdoruesiService service;

    public PerdoruesiController(PerdoruesiService service) {
        this.service = service;
    }


    @GetMapping("/")
    public ResponseEntity<Perdoruesi> getPerdoruesi(){
        return  ResponseEntity.status(HttpStatus.OK).body(new Perdoruesi());

    }


    @PostMapping("/login")
    public  ResponseEntity<Perdoruesi> login(@RequestBody Perdoruesi perdoruesi){
        return service.login(perdoruesi);
    }


    @PostMapping("/perdoruesi/register")
    public Perdoruesi registerAccount(@RequestBody Perdoruesi p){
        System.out.println(p);
      return service.registerNewAccount(p);





    }


}
