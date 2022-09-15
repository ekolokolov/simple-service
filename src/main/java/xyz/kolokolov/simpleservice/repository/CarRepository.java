package xyz.kolokolov.simpleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.kolokolov.simpleservice.Car;


public interface CarRepository extends JpaRepository<Car, Integer> {

}
