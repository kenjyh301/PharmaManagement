package main.java.Form;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import main.java.Model.Pharma;
import main.java.Service.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
@Data
@Slf4j
public class CategoryListForm {
    private JPanel panel1;
    private JTextArea showText;
    private JTextField groupText;
    private JTextField nameText;
    private JButton searchButton;
    private Service service;

    public CategoryListForm() {
        service= new Service();
        searchButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */

            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                showText.setText("");
                log.info(groupText.getText());
                if(groupText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Nhóm không được để trống");
                }else{
                    if(nameText.getText().equals("")){
                        List<Pharma> pharmaList= service.findAllGroup(groupText.getText());
                        if(pharmaList.size()==0)JOptionPane.showMessageDialog(null,"Nhóm không tồn tại");
                        else{
                            for(Pharma pharma:pharmaList){
                                String text=pharma.getName()+"\t"+pharma.getAmount()+"\n";
                                showText.append(text);
                            }
                        }
                    }else{
                        Pharma pharma= service.findPharma(nameText.getText()+".json",groupText.getText());
                        if(pharma==null)JOptionPane.showMessageDialog(null,"Tên hoặc nhóm không tồn tại");
                        else{
                            String text=pharma.getName()+"\t"+pharma.getAmount()+"\n";
                            showText.append(text);
                        }
                    }
                }
            }
        });
    }
}
