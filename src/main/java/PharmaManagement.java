package main.java;


import lombok.extern.slf4j.Slf4j;
import main.java.Form.CategoryAddForm;
import main.java.Form.CategoryListForm;
import main.java.Form.CustomerForm;
import main.java.Form.MainFunction;
import main.java.Service.Service;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Slf4j
public class PharmaManagement {
    static JFrame frame= new JFrame("MainFunction");
    static CategoryAddForm categoryAddForm= new CategoryAddForm(frame);
    static CategoryListForm categoryListForm= new CategoryListForm(frame);
    static CustomerForm customerForm=new CustomerForm(frame);
    public static MainFunction mainFunction=new MainFunction(frame,categoryAddForm,categoryListForm,customerForm);


    public static void main(String arg[]) throws IOException {
        Service service=new Service();
//        Pharma pharma=service.findPharma("berberin.json","thông thường");
//        log.info(String.valueOf(pharma.getAmount()));
//        service.findAllGroup("thông thường");


        frame.setContentPane(mainFunction.getFormPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(100,100,450,300);
//        frame.pack();

        frame.setVisible(true);

    }
}
