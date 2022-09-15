package xyz.kolokolov.simpleservice;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @SequenceGenerator(name = "owners_sequence_gen", sequenceName = "owners_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "owners_sequence_gen")
    private int id;
    private String name;
    private String surname;
    private int age;
    private String sex;
}
