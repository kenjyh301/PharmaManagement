package main.java.Form;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
@Slf4j
public class MainFunction {
    private JButton cateAddButton;
    private JButton cateListButton;
    private JButton addPrescriptionButton;
    private JPanel formPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        formPanel= new JPanel();
        formPanel.setSize(200,100);
    }

    public MainFunction(JFrame frame,CategoryAddForm categoryAddForm,CategoryListForm categoryListForm,CustomerForm customerForm){


        cateAddButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryAddForm.InitForm();
                frame.setContentPane(categoryAddForm.getCategoryAddPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
        cateListButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryListForm.InitForm();
                frame.setContentPane(categoryListForm.getPanel1());
                frame.pack();
                frame.setVisible(true);
            }
        });
        addPrescriptionButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                customerForm.InitForm();
                frame.setContentPane(customerForm.getFormPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
