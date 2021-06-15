package main.java.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pharma {
    int id;
    String name;
    String group;
    int amount;
}
