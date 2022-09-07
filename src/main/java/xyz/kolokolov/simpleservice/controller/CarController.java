package xyz.kolokolov.simpleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CarController {
    List<HashMap<String, String>> cars = new ArrayList<>();

    @PostMapping("car")
    public void postCar(@RequestBody HashMap<String, String> car) {
        cars.add(car);
    }
    @GetMapping("cars")
    public List<HashMap<String, String>> showCars() {
        return cars;
    }

}
