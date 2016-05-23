package moneycalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import moneycalculator.components.CalculatorFrame;
import moneycalculator.control.ExchangeCommand;
import moneycalculator.input.CurrencyListSelectionDialog;
import moneycalculator.input.MoneyDialog;
import moneycalculator.model.CurrencyList;
import moneycalculator.output.MoneyListViewer;
import moneycalculator.process.CurrencyListLoader;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        CurrencyList supportedCurrencyList = CurrencyListLoader.load("es");
        
        MoneyDialog moneyDialog = new MoneyDialog(supportedCurrencyList);
        CurrencyListSelectionDialog selectionDialog = new CurrencyListSelectionDialog(supportedCurrencyList);
        MoneyListViewer moneyListViewer = new MoneyListViewer();
        
        ExchangeCommand command = new ExchangeCommand(moneyDialog, selectionDialog, moneyListViewer);
        
        CalculatorFrame frame = new CalculatorFrame();
        frame.addPanel(moneyDialog.getPanel());
        frame.addPanel(selectionDialog.getPanel());
        frame.addPanel(moneyListViewer.getPanel());
        frame.start(command);
        
    }
}

