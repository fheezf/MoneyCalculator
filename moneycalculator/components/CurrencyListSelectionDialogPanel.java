package moneycalculator.components;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyListSelectionDialogPanel extends JPanel {
    private static final int SIZE = 4;
    private JComboBox[] currency;

    public CurrencyListSelectionDialogPanel(String[] values) {
       setLayout(new FlowLayout(FlowLayout.LEFT));
       setMaximumSize(new Dimension(400,35));
       createComponents(getValues(values));
    }
    
    private String[] getValues(String[] values) {
        String [] result = new String[values.length+1];
        result[0]= "";
        System.arraycopy(values, 0, result, 1, values.length);
        return result;
    }

    private void createComponents(String[] values) {
       currency = new JComboBox[SIZE];
        for (int i=0;i<SIZE;i++)
            add(currency[i] = createCurrency(values));
    }
    private JComboBox createCurrency(String[] values) {
        JComboBox currency = new JComboBox(values);
        currency.setPreferredSize(new Dimension(90,25));
        return currency;
    }

    public String[] getCurrencies() {
       String[] result = new String[SIZE];
       for (int i=0;i<SIZE;i++)
            result[i] = (String) currency[i].getSelectedItem();
       return result;
    }
    
    
}
