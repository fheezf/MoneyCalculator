package moneycalculator.process;

import java.io.*;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;

public class CurrencyListLoader {

    public static CurrencyList load(String language) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        CurrencyList list = new CurrencyList();
        FileInputStream inputStream = new FileInputStream("data/currencies.dat");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line = reader.readLine();
        while (line != null) {
            String[] data = line.split(";");
            Currency currency;
            if (data.length == 3)
                currency = new Currency(data[0], data[1], data[2]);
            else
                currency = new Currency(data[0], data[1]);
            list.add(currency);
            line = reader.readLine();
        }
        reader.close();
        return list;
    }
}