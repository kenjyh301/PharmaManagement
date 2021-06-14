package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public CategoryAddForm() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
