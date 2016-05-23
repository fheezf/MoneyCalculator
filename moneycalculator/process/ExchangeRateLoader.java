package moneycalculator.process;

import java.io.*;
import java.util.Date;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public class ExchangeRateLoader {

    public static ExchangeRate load(Currency source, Currency target, Date date) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader reader = openReader(getFilename(date));
        String line = reader.readLine();
        while (line != null) {          
            double rate = getRate(source, target, line);
            line = reader.readLine();
            if (rate == 0) continue;
            reader.close();
            return new ExchangeRate(source, target, date, rate);
        }
        reader.close();
        return new ExchangeRate(source, target, date, 1.0);
    }

    private static String getFilename(Date date) {
        return "20121108";
    }

    private static BufferedReader openReader(String filename) throws UnsupportedEncodingException, FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("data/exchangerates/" + filename + ".dat");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        return reader;
    }
    
    private static double getRate(Currency source, Currency target, String line) {
        String data[] = line.split(";");
        if ((source.getCode().equals(data[0])) && (target.getCode().equals(data[1]))) {
            return Double.valueOf(data[2]);
        }
        else if ((source.getCode().equals(data[1])) && (target.getCode().equals(data[0]))) {
            return 1/Double.valueOf(data[2]);
        }
        return 0;
    }
}
