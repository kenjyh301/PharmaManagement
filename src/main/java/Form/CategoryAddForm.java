package main.java.Form;

import com.google.gson.Gson;
import lombok.Data;
import lombok.SneakyThrows;
import main.java.Model.Pharma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

@Data
public class CategoryAddForm {
    private JTextField nameText;
    private JTextField groupText;
    private JTextField amountText;
    private JButton addButton;
    private JButton EraseButton;
    private JButton ReturnButton;
    private JPanel headPanel;
    private JPanel labelPanel;
    private JPanel buttonPannel;
    private JPanel CategoryAddPanel;

    public CategoryAddForm() {
        addButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
//                int id=0;
//                String name= nameText.getText();
//                String group= groupText.getText();
//                int amount=0;
//                try{
//                    amount= Integer.parseInt(amountText.getText());
//                }catch(Exception exception){
//                    exception.printStackTrace();
//                }
//                Pharma pharma= new Pharma(id,name,group,amount);
//                Gson gson= new Gson();
//                String s= gson.toJson(pharma);
//                String filePath= "D:\\database\\"+pharma.getGroup()+"\\";
//                new File(filePath).mkdir();
//                String fileName=filePath+pharma.getName()+".json";
//                FileWriter fw= new FileWriter(fileName);
//                fw.append(s);
//                fw.close();
            }
        });
        EraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                groupText.setText("");
                amountText.setText("");
            }
        });
        ReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
