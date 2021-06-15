package main.java.Service;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import main.java.Form.CategoryAddForm;

import javax.swing.*;
import java.awt.*;

@Data
//@Slf4j
public class CategoryAddService {
    private JFrame frame;
    private CategoryAddForm categoryAddForm;

    public CategoryAddService(){
        frame= new JFrame("CategoryAddForm");
        categoryAddForm= new CategoryAddForm();
        frame.setContentPane(categoryAddForm.getCategoryAddPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
}
