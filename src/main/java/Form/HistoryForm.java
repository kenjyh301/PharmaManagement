package main.java.Form;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import main.java.Model.Pharma;
import main.java.Model.Prescription;
import main.java.Service.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Data
@Slf4j
public class HistoryForm {
    private JPanel formPanel;
    private JTextArea historyText;
    private JTextField customerText;
    private JButton showButton;
    private JTextField phoneNumberText;
    private JButton returnButton;
    Service service;

    public HistoryForm(JFrame frame, CustomerForm customerForm) {
        service= new Service();
        showButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                historyText.setText("");
                String name= customerText.getText();
                String phoneNumber= phoneNumberText.getText();
                boolean check= service.CheckValidCustomer(phoneNumber);
                if(!check){
                    JOptionPane.showMessageDialog(null,"Số điện thoại không tồn tại");
                    return;
                }
                List<Prescription> prescriptionList=service.GetCustomerInfo(phoneNumber,name);
                for(Prescription prescription:prescriptionList){
                    historyText.append(prescription.getDate()+"\n");
                    for(Pharma pharma:prescription.getPharmaList()){
                        historyText.append("\t"+pharma.getName()+"\t"+pharma.getGroup()+"\t"+pharma.getAmount()+"\n");
                    }
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
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

    void InitForm(){
        historyText.setText("");
        customerText.setText("");
        phoneNumberText.setText("");
    }
}
