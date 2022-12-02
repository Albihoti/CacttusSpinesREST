package com.example.springbootproject.controller;


import com.example.springbootproject.model.Perdoruesi;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PerdoruesiController {

    @GetMapping("/test")
    public ResponseEntity<String> responseStrin(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

//
//    @PostMapping("/test")
//    public  ResponseEntity<Perdoruesi> postData(@RequestBody  Perdoruesi perdoruesi){
////        return ResponseEntity<Perdo   ruesi>("")
//    }


}
