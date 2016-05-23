package moneycalculator.process;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import moneycalculator.model.*;

public class MoneyExchanger {
   public static Money exchange(Money money, Currency currency) throws FileNotFoundException, UnsupportedEncodingException, IOException{
       ExchangeRate exchangeRate= ExchangeRateLoader.load (money.getCurrency(), currency, new Date());
       double amount= money.getAmount()*exchangeRate.getRate();
       return  new Money(amount,currency);
   }
   
  public static MoneyList exchange(Money money, CurrencyList currencyList) throws FileNotFoundException, UnsupportedEncodingException, IOException{
     MoneyList list = new MoneyList();      
     for (Currency currency: currencyList)
         list.add(exchange(money,currency));
     return list;
  }
}
