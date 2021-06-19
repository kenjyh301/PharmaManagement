package main.java.Model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import main.java.Service.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class Prescription {
    String customer;
    List<Pharma> pharmaList;
    Service service;

    public Prescription(String customerName){
        customer=customerName;
        pharmaList= new ArrayList<Pharma>();
        service= new Service();
    }

    void AddPrescription(Pharma pharma){
        pharmaList.add(pharma);
    }

    void UpdatePrescription() throws IOException {
        for(Pharma pharma:pharmaList){
            service.UpdatePharma(pharma, Service.UpdateType.REMOVE);
        }
    }
}
