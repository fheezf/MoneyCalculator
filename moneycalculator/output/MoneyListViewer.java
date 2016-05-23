package moneycalculator.output;

import moneycalculator.components.MoneyListViewerPanel;
import moneycalculator.model.Money;
import moneycalculator.model.MoneyList;

public class MoneyListViewer {

    private MoneyList moneyList;
    private MoneyListViewerPanel panel;

    public MoneyListViewer() {
        this.panel = new MoneyListViewerPanel();
    }

    public MoneyListViewerPanel getPanel() {
        return panel;
    }
    
    public MoneyList getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(MoneyList moneyList) {
        this.moneyList = moneyList;
        refresh();
    }
    
    public void refresh() {
        String text = "<html>";
        for (Money money : moneyList) {
            text += "<p>" + "<b>" + money.getAmount() + "</b>" + " " + money.getCurrency().getName() + "</p>";
        }
        text += "</html>";
        panel.setText(text);
    }
}
