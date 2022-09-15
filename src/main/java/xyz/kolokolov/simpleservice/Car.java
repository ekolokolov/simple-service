package xyz.kolokolov.simpleservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cars")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
    @Id
    @SequenceGenerator(name = "cars_sequence_gen", sequenceName = "cars_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_sequence_gen")
    private Integer id;
    private UUID uuid;
private String vendor;
private String model;
private Integer year;
private String owner;
}
