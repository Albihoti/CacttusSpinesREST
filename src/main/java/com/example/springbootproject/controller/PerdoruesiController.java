package com.example.springbootproject.controller;


import com.example.springbootproject.model.Perdoruesi;
import com.example.springbootproject.model.PerdoruesiDto;
import com.example.springbootproject.service.PerdoruesiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("rest")
@CrossOrigin
public class PerdoruesiController {

    public final PerdoruesiService service;

    public PerdoruesiController(PerdoruesiService service) {
        this.service = service;
    }


    @GetMapping()
    public ResponseEntity<Perdoruesi> getPerdoruesi(){
        return  ResponseEntity.status(HttpStatus.OK).body(new Perdoruesi());

    }

    @GetMapping("/hello")
    @ResponseBody
    public Perdoruesi getText(){
        System.out.println("HelloWorld");
        Perdoruesi perdo = service.getPerdoruesiByUsername("mael");
        System.out.println(perdo);
        return perdo;
    }


    @PostMapping("/login")
    public  ResponseEntity<PerdoruesiDto> login(@RequestBody Perdoruesi perdoruesi){
        return service.login(perdoruesi);
    }


    @RequestMapping(value="/perdoruesi/register",method = RequestMethod.POST)
    public ResponseEntity<PerdoruesiDto> registerAccount(@RequestBody PerdoruesiDto p){
        System.out.println(p);
        return  service.registerNewAccount(p);

    }

    @GetMapping("/userProfile/{id}")
    public ResponseEntity<Perdoruesi> getProfile(@PathVariable Integer id ){
        return  service.getProfile(id);
    }


    @PutMapping("/perdoruesi/update/{id}")
    public  ResponseEntity<Perdoruesi> updateUser(@PathVariable Integer id, @RequestBody PerdoruesiDto p){
                    return service.updateUser(p, id);
    }

}
