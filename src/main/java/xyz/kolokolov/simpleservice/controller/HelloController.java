package xyz.kolokolov.simpleservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/hello")
public class HelloController {
    AtomicInteger counter = new AtomicInteger(0);
    @GetMapping
    public ResponseEntity<String> hello(){
        counter.getAndIncrement();
        return ResponseEntity.ok("Hello " + counter.get() + " times");
    }
}
