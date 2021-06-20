package main.java.Form;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import main.java.Model.Pharma;
import main.java.Service.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static main.java.PharmaManagement.mainFunction;


@Data
@Slf4j
public class CustomerForm {
    private JTextField customerText;
    private JButton addButton;
    private JTextArea prescriptionText;
    private JPanel formPanel;
    private JTextField nameText;
    private JTextField groupText;
    private JTextField amountText;
    private JButton finishButton;
    private JButton eraseButton;
    private JButton clearPrescriptionButton;
    private JTextField phoneText;
    List<Pharma> prescription;
    Service service;
    String currentCustomer;

    public CustomerForm(JFrame frame) {
        prescription= new ArrayList<>();
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
                if(customerText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Khách hàng không được để trống");
                    return;
                }
                if(nameText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống");
                    return;
                }
                if(groupText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Nhóm không được để trống");
                    return;
                }
                if(amountText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Số lượng không được để trống");
                    return;
                }

                if(!phoneText.getText().equals(currentCustomer)){
                    prescription= new ArrayList<>();
                    log.info("New customer, old customer was not saved");

                    currentCustomer=phoneText.getText();
                    prescriptionText.setText(customerText.getText()+":\n");
                }
                String name= nameText.getText();
                String group= groupText.getText();
                int amount;
                try{
                    amount= Integer.parseInt(amountText.getText());
                }catch (Exception exception){
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Số lượng không chính xác");
                    return;
                }
                Pharma existPharma= service.FindPharma(name+".json",group);
                if(existPharma==null){
                    JOptionPane.showMessageDialog(null,"Tên hoặc nhóm không chính xác");
                    return;
                }else{
                    if(amount>existPharma.getAmount()){
                        JOptionPane.showMessageDialog(null,"Số lượng hiện tại không đủ ("+existPharma.getAmount()+")");
                        return;
                    }
                    Pharma currentPharma= new Pharma(name,group,amount);
                    prescription.add(currentPharma);
                    prescriptionText.append(name+"\t"+group+"\t"+amount+"\n");
                    log.info("New element was add to prescription");
                }


            }
        });
        finishButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Pharma pharma:prescription){
                    service.UpdatePharma(pharma, Service.UpdateType.REMOVE);
                }
                service.UpdateCustomer(phoneText.getText(),prescription,customerText.getText());
                log.info("Update prescription success");
                frame.setContentPane(mainFunction.getFormPanel());
                frame.setBounds(100,100,450,300);
                frame.setVisible(true);
            }
        });
        clearPrescriptionButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                prescription= new ArrayList<>();
            }
        });
    }

    public void InitForm(){
        customerText.setText("");
        prescriptionText.setText("");
        nameText.setText("");
        groupText.setText("");
        amountText.setText("");

    }
}
