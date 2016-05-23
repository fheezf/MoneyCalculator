package moneycalculator.input;

import moneycalculator.components.CurrencyListSelectionDialogPanel;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;

public class CurrencyListSelectionDialog {

    private CurrencyList supportedCurrencyList;
    private CurrencyListSelectionDialogPanel panel;

    public CurrencyListSelectionDialog(CurrencyList supportedCurrencyList) {
        this.supportedCurrencyList = supportedCurrencyList;
        this.panel = new CurrencyListSelectionDialogPanel(supportedCurrencyList.toArray(CurrencyList.CODE));
    }

    public CurrencyListSelectionDialogPanel getPanel() {
        return panel;
    }

    public CurrencyList getCurrencyList() {
        CurrencyList result = new CurrencyList();
        for (String selection : panel.getCurrencies()) {
            Currency currency = supportedCurrencyList.search(selection);
            if (currency == null) {
                continue;
            }
            result.add(currency);
        }
        return result;
    }
}
