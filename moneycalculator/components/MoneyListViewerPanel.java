package moneycalculator.components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyListViewerPanel extends JPanel{
    private JLabel label;

    public MoneyListViewerPanel() {
        add(createLabel());
    }
    
    private JLabel createLabel() {
        label = new JLabel();
        return label;
    }
    
    public void setText(String text) {
        label.setText(text);
    }
    
}
