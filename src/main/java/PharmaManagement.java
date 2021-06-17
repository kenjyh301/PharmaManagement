package main.java;


import lombok.extern.slf4j.Slf4j;
import main.java.Form.CategoryAddForm;

import javax.swing.*;
import java.awt.*;

@Slf4j
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
