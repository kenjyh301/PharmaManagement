package main.java;


import lombok.extern.slf4j.Slf4j;
import main.java.Form.CategoryAddForm;
import main.java.Form.CategoryListForm;
import main.java.Model.Pharma;
import main.java.Service.Service;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Slf4j
public class PharmaManagement {

    public static void main(String arg[]) throws IOException {
        Service service=new Service();
//        Pharma pharma=service.findPharma("berberin.json","thông thường");
//        log.info(String.valueOf(pharma.getAmount()));
//        service.findAllGroup("thông thường");
        JFrame frame= new JFrame("CategoryAddForm");
        CategoryAddForm categoryAddForm= new CategoryAddForm();
        CategoryListForm categoryListForm= new CategoryListForm();
        frame.setContentPane(categoryListForm.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

    }
}
