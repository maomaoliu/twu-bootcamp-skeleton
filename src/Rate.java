import java.util.*;

public class Rate {
    private List<HashMap<Currency, Double>> currencyRates;

    public Rate() {
        init();
    }

    private void init() {
        currencyRates = new ArrayList<HashMap<Currency, Double>>();
        HashMap<Currency, Double> dayOne = new HashMap<Currency, Double>();
        dayOne.put(Currency.USD, 1d);
        dayOne.put(Currency.GBP, 1.23d);
        dayOne.put(Currency.EUR, 1.56d);
        HashMap<Currency, Double> dayTwo = new HashMap<Currency, Double>();
        dayTwo.put(Currency.USD, 1d);
        dayTwo.put(Currency.GBP, 1.30d);
        dayTwo.put(Currency.EUR, 1.45d);
        HashMap<Currency, Double> dayThree = new HashMap<Currency, Double>();
        dayThree.put(Currency.USD, 1d);
        dayThree.put(Currency.GBP, 1.25d);
        dayThree.put(Currency.EUR, 1.60d);
        HashMap<Currency, Double> dayFour = new HashMap<Currency, Double>();
        dayFour.put(Currency.USD, 1d);
        dayFour.put(Currency.GBP, 1.10d);
        dayFour.put(Currency.EUR, 1.50d);
        currencyRates.add(dayOne);
        currencyRates.add(dayTwo);
        currencyRates.add(dayThree);
        currencyRates.add(dayFour);
    }


    public double getRate(int day, Currency currency) {
        if (day < 1) throw new IllegalArgumentException();
        if(day>=this.currencyRates.size()) throw new UnsupportedOperationException();
        return currencyRates.get(day - 1).get(currency);
    }
}
