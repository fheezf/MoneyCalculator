package moneycalculator.input;

import moneycalculator.components.MoneyDialogPanel;
import moneycalculator.model.CurrencyList;
import moneycalculator.model.Money;

public class MoneyDialog {
    private CurrencyList supportedCurrencyList;
    private MoneyDialogPanel panel;

    public MoneyDialog(CurrencyList supportedCurrencyList) {
        this.supportedCurrencyList = supportedCurrencyList;
        this.panel = new MoneyDialogPanel(supportedCurrencyList.toArray(CurrencyList.CODE));
    }

    public MoneyDialogPanel getPanel() {
        return panel;
    }
    
    public Money getMoney() {
        return new Money(panel.getAmount(), supportedCurrencyList.search(panel.getCurrency()));
    }
}
