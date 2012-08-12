import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class WalletTest {

    @Test
    public void shouldGetCheapestWithSameCurrency() {
        List<Money> moneyList = new ArrayList<Money>();
        Money oneHundredDollar = new Money(100, Currency.USD);
        Money twoHundredDollar = new Money(200, Currency.USD);
        Money threeHundredDollar = new Money(300, Currency.USD);
        moneyList.add(threeHundredDollar);
        moneyList.add(oneHundredDollar);
        moneyList.add(twoHundredDollar);
        Wallet wallet = new Wallet();

        Money cheapest = wallet.getCheapest(moneyList);

        Assert.assertThat(cheapest, is(oneHundredDollar));
    }
    @Test
    public void shouldGetCheapestWithDifferentCurrency() {
        List<Money> moneyList = new ArrayList<Money>();
        Money oneHundredAndTwoEuro = new Money(102, Currency.EUR);
        Money oneHundredAndOneDollar = new Money(101, Currency.USD);
        Money oneHundredPound = new Money(100, Currency.GBP);
        moneyList.add(oneHundredPound);
        moneyList.add(oneHundredAndTwoEuro);
        moneyList.add(oneHundredAndOneDollar);
        Wallet wallet = new Wallet();

        Money cheapest = wallet.getCheapest(moneyList);

        Assert.assertThat(cheapest, is(oneHundredAndOneDollar));
    }
}