package main.java.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.java.Service.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@NoArgsConstructor
public class Prescription {
    String phoneNumber;
    String customer;
    String date;
    List<Pharma> pharmaList;
    Service service;

    public Prescription(String customerName){
        customer=customerName;
        pharmaList= new ArrayList<Pharma>();
        service= new Service();
    }

    public void AddPrescription(Pharma pharma){
        pharmaList.add(pharma);
    }

}
