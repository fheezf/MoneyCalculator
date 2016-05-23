package moneycalculator.model;

import java.util.ArrayList;

public class CurrencyList extends ArrayList<Currency> {

    public static final int CODE = 0;
    public static final int NAME = 1;
    public static final int SYMBOL = 2;

    public Currency search(String token) {
        if (token.isEmpty()) return null;
        for (int i = 0; i < this.size(); i++) {
            Currency currency = this.get(i);
            if (token.equalsIgnoreCase(currency.getCode()))
                return currency;
            if (token.equalsIgnoreCase(currency.getName()))
                return currency;
            if (token.equals(currency.getSymbol()))
                return currency;
        }
        return null;
    }

    public String[] toArray(int field) {
        String[] result = new String[size()];
        for (int i = 0; i < size(); i++)
            if (field == CODE)
                result[i] = get(i).getCode();
            else if (field == NAME)
                result[i] = get(i).getName();
            else if (field == SYMBOL)
                result[i] = get(i).getSymbol();
        return result;
    }
}
