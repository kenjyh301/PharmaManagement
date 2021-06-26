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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class PharmaManagement {
    static JFrame frame= new JFrame("MainFunction");
    static CategoryAddForm categoryAddForm;
    static CategoryListForm categoryListForm;
    static CustomerForm customerForm;
    public static MainFunction mainFunction;
    public static String pharmaDataFolder;
    public static String customerDataFolder;


    public static void main(String arg[]) throws IOException {
        pharmaDataFolder=arg[0];
        customerDataFolder=arg[1];

        categoryAddForm= new CategoryAddForm(frame);
        categoryListForm= new CategoryListForm(frame);
        customerForm=new CustomerForm(frame);
        mainFunction=new MainFunction(frame,categoryAddForm,categoryListForm,customerForm);

        frame.setContentPane(mainFunction.getFormPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(100,100,450,300);
//        frame.pack();

        frame.setVisible(true);

    }
}
