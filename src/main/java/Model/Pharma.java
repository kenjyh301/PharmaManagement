package main.java.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pharma {
    String name;
    String group;
    int amount;
}
