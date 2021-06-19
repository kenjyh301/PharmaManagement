package main.java.Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerForm {
    private JTextField customerText;
    private JButton addButton;
    private JTextArea textArea1;
    private JPanel formPanel;
    private JTextField nameText;
    private JTextField groupText;
    private JTextField amountText;
    private JButton finishButton;

    public CustomerForm() {
        addButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        finishButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
