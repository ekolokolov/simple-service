package xyz.kolokolov.simpleservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Engine {
    private int id;
    private Double displacement;
    private String number;
    private String fuel;
}
