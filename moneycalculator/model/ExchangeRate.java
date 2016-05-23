package moneycalculator.model;

import java.util.Date;

public class ExchangeRate {

    private Currency source;
    private Currency target;
    private Date date;
    private Double rate;

    public ExchangeRate(Currency source, Currency target, Date date, Double rate) {
        this.source = source;
        this.target = target;
        this.date = date;
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public Date getDate() {
        return date;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getTarget() {
        return target;
    }
}
