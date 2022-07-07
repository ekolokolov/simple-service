package xyz.kolokolov.simpleservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    int counter;
    @GetMapping
    public ResponseEntity<String> hello(){
        counter++;
        return ResponseEntity.ok("Hello " + counter + " time(s)");

    }



}
