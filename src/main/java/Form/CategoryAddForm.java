package main.java.Form;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import main.java.Model.Pharma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.Service.Service;

@Data
@Slf4j
public class CategoryAddForm {
    private JTextField nameText;
    private JTextField groupText;
    private JTextField amountText;
    private JButton addButton;
    private JButton EraseButton;
    private JButton ReturnButton;
    private JPanel headPanel;
    private JPanel labelPanel;
    private JPanel buttonPanel;
    private JPanel CategoryAddPanel;
    public Service service;

    public CategoryAddForm() {
        service= new Service();

        addButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= nameText.getText();
                String group= groupText.getText();
                int amount=0;
                try{
                    amount= Integer.parseInt(amountText.getText());
                }catch (Exception exception){
                    log.info("Amount is not number: {}",amountText.getText());
                    JOptionPane.showMessageDialog(null,"Số lượng không chính xác");
                    return;
                }

                if(amount>0){
                    Pharma pharma= new Pharma(name,group,amount);
                    Pharma existPharma= service.findPharma(name+".json",group);
                    if(existPharma!=null)pharma.setAmount(existPharma.getAmount()+pharma.getAmount());
                    service.SavePharma(pharma);
                }else{
                    JOptionPane.showMessageDialog(null,"Số lượng không chính xác");
                    log.info("Amount is below zero: {}",amount);
                }
            }
        });
        EraseButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                groupText.setText("");
                amountText.setText("");
            }
        });
        ReturnButton.addActionListener(new ActionListener() {
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
