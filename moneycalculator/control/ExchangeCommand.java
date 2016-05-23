package moneycalculator.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.input.CurrencyListSelectionDialog;
import moneycalculator.input.MoneyDialog;
import moneycalculator.model.MoneyList;
import moneycalculator.output.MoneyListViewer;
import moneycalculator.process.MoneyExchanger;

public class ExchangeCommand extends Command {
    private MoneyDialog moneyDialog;
    private CurrencyListSelectionDialog selectionDialog;
    private MoneyListViewer moneyListViewer;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyListSelectionDialog selectionDialog, MoneyListViewer moneyListViewer) {
        this.moneyDialog = moneyDialog;
        this.selectionDialog = selectionDialog;
        this.moneyListViewer = moneyListViewer;
    }
    
    @Override
    public void execute()  {
        try {
            MoneyList moneyList = MoneyExchanger.exchange(moneyDialog.getMoney(), selectionDialog.getCurrencyList());
            moneyListViewer.setMoneyList(moneyList);
        } catch (Exception ex) {
            Logger.getLogger(ExchangeCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

