package main.java.Form;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import main.java.Model.Pharma;
import main.java.Service.Service;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static main.java.PharmaManagement.mainFunction;


@Data
@Slf4j
public class CustomerForm {
    public static HistoryForm historyForm;
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
    private JButton historyButton;
    List<Pharma> prescription;
    Service service;
    String currentCustomer;

    public CustomerForm(JFrame frame) {
        historyForm = new HistoryForm(frame, this);
        prescription = new ArrayList<>();
        service = new Service();
        addButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Khách hàng không được để trống");
                    return;
                }
                if (nameText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống");
                    return;
                }
                if (groupText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhóm không được để trống");
                    return;
                }
                if (amountText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Số lượng không được để trống");
                    return;
                }

                if (!phoneText.getText().equals(currentCustomer)) {
                    prescription = new ArrayList<>();
                    log.info("New customer, old customer was not saved");

                    currentCustomer = phoneText.getText();
                    prescriptionText.setText(customerText.getText() + ":\n");
                }
                String name = nameText.getText();
                String group = groupText.getText();
                int amount;
                try {
                    amount = Integer.parseInt(amountText.getText());
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Số lượng không chính xác");
                    return;
                }
                Pharma existPharma = service.FindPharma(name + ".json", group);
                if (existPharma == null) {
                    JOptionPane.showMessageDialog(null, "Tên hoặc nhóm không chính xác");
                    return;
                } else {
                    if (amount > existPharma.getAmount()) {
                        JOptionPane.showMessageDialog(null, "Số lượng hiện tại không đủ (" + existPharma.getAmount() + ")");
                        return;
                    }
                    Pharma currentPharma = new Pharma(name, group, amount);
                    prescription.add(currentPharma);
                    prescriptionText.append(name + "\t" + group + "\t" + amount + "\n");
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
                for (Pharma pharma : prescription) {
                    service.UpdatePharma(pharma, Service.UpdateType.REMOVE);
                }
                service.UpdateCustomer(phoneText.getText(), prescription, customerText.getText());
                log.info("Update prescription success");
                frame.setContentPane(mainFunction.getFormPanel());
                frame.setBounds(100, 100, 450, 300);
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
                prescription = new ArrayList<>();
            }
        });
        historyButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                historyForm.InitForm();
                frame.setContentPane(historyForm.getFormPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void InitForm() {
        customerText.setText("");
        prescriptionText.setText("");
        nameText.setText("");
        groupText.setText("");
        amountText.setText("");

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        formPanel = new JPanel();
        formPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(12, 6, new Insets(0, 0, 0, 0), -1, -1));
        groupText = new JTextField();
        formPanel.add(groupText, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        nameText = new JTextField();
        formPanel.add(nameText, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        amountText = new JTextField();
        formPanel.add(amountText, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addButton = new JButton();
        addButton.setText("Thêm");
        formPanel.add(addButton, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prescriptionText = new JTextArea();
        formPanel.add(prescriptionText, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 10, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(300, 800), new Dimension(150, 50), null, 0, false));
        finishButton = new JButton();
        finishButton.setText("Kết thúc");
        formPanel.add(finishButton, new com.intellij.uiDesigner.core.GridConstraints(11, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        formPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eraseButton = new JButton();
        eraseButton.setText("Xóa");
        formPanel.add(eraseButton, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        formPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(11, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        customerText = new JTextField();
        formPanel.add(customerText, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Tên thuốc");
        formPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, -1, 20, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Nhóm");
        formPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, -1, 20, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Số lượng");
        formPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$(null, -1, 20, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Khách hàng");
        formPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clearPrescriptionButton = new JButton();
        clearPrescriptionButton.setText("Xóa đơn");
        formPanel.add(clearPrescriptionButton, new com.intellij.uiDesigner.core.GridConstraints(11, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        phoneText = new JTextField();
        formPanel.add(phoneText, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$(null, -1, 20, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("Số điện thoại");
        formPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        historyButton = new JButton();
        historyButton.setText("Lịch sử");
        formPanel.add(historyButton, new com.intellij.uiDesigner.core.GridConstraints(11, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return formPanel;
    }
}
