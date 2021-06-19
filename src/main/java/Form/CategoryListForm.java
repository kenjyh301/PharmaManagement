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
public class CategoryListForm {
    private JPanel panel1;
    private JTextArea showText;
    private JTextField groupText;
    private JTextField nameText;
    private JButton searchButton;
    private JTextArea groupListPanel;
    private JButton returnButton;
    private Service service;

    public CategoryListForm(JFrame frame) {

        service = new Service();
        searchButton = new JButton("Tìm");
        InitForm();
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
                if (groupText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhóm không được để trống");
                } else {
                    if (nameText.getText().equals("")) {
                        List<Pharma> pharmaList = service.FindAllGroup(groupText.getText());
                        if (pharmaList.size() == 0) JOptionPane.showMessageDialog(null, "Nhóm không tồn tại");
                        else {
                            for (Pharma pharma : pharmaList) {
                                String text = pharma.getName() + "\t" + pharma.getAmount() + "\n";
                                showText.append(text);
                            }
                        }
                    } else {
                        Pharma pharma = service.FindPharma(nameText.getText() + ".json", groupText.getText());
                        if (pharma == null) JOptionPane.showMessageDialog(null, "Tên hoặc nhóm không tồn tại");
                        else {
                            String text = pharma.getName() + "\t" + pharma.getAmount() + "\n";
                            showText.append(text);
                        }
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
                frame.setContentPane(mainFunction.getFormPanel());
                frame.setBounds(100,100,450,300);
                frame.setVisible(true);
            }
        });
    }

    public void InitForm(){
        groupListPanel.setText("");
        List<String> groupList=service.GetAllGroup();
        for(String group:groupList){
            groupListPanel.append(group);
            groupListPanel.append("\n");
        }
    }
}
