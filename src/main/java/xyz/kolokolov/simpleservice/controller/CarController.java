package xyz.kolokolov.simpleservice.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.kolokolov.simpleservice.Car;
import xyz.kolokolov.simpleservice.Owner;
import xyz.kolokolov.simpleservice.repository.CarRepository;
import xyz.kolokolov.simpleservice.repository.OwnerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController

public class CarController {
    @Autowired
    CarRepository carRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @PostMapping("addCar")
    public ResponseEntity postCar(@RequestBody Car car) {
        carRepository.save(new Car(car.getId(), UUID.randomUUID(), car.getVendor(), car.getModel(), car.getYear(), car.getOwner()));
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("cars")
    public ResponseEntity<List<Car>> showCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("car/{num}")
    public ResponseEntity<Car> returnOne(@PathVariable int num) {
        return new ResponseEntity<>(carRepository.getReferenceById(num), HttpStatus.OK);
    }

    @PostMapping("owner")
    public String addNewOwner(@RequestBody Owner owner) {
        ownerRepository.save(new Owner(owner.getId(), owner.getName(), owner.getSurname(), owner.getAge(), owner.getSex()));
        return "Owner successfully added";
    }

}
