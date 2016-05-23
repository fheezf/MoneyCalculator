package moneycalculator.components;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyDialogPanel extends JPanel{
    private JTextField amount;
    private JComboBox currency;
    
    public MoneyDialogPanel(String[] values) {
       setLayout(new FlowLayout(FlowLayout.LEFT));
       createComponents(values);
       setMaximumSize(new Dimension(400,50));
    }

    private void createComponents(String[] values) {
        add(createAmount());
        add(createCurrency(values));
    }
    private JTextField createAmount() {
        amount = new JTextField();
        amount.setFont(new Font("Arial", Font.PLAIN, 24));
        amount.setPreferredSize(new Dimension(200,40));
        amount.setHorizontalAlignment(JTextField.RIGHT);
        amount.setText("1");
        return amount;
    }
    private JComboBox createCurrency(String[] values) {
        currency = new JComboBox(values);
        currency.setFont(new Font("Arial", Font.PLAIN, 20));
        currency.setSelectedItem("USD");
        currency.setPreferredSize(new Dimension(150,40));
        return currency;
    }
    
    public double getAmount() {
        return Double.valueOf(amount.getText());
    }
    
    public String getCurrency() {
        return (String) currency.getSelectedItem();
    }
    
    
}
