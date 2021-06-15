package main.java;

import main.java.Form.CategoryAddForm;
import main.java.Service.CategoryAddService;

import javax.swing.*;
import java.awt.*;

public class PharmaManagement {

    public static void main(String arg[]){
        JFrame frame= new JFrame("CategoryAddForm");
        CategoryAddForm categoryAddForm= new CategoryAddForm();
        frame.setContentPane(categoryAddForm.getCategoryAddPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
}
