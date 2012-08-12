import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {
    @Test
    public void shouldAddWithSameCurrency() {
        Money oneHundredDollar = new Money(100, Currency.USD);
        Money twoHundredDollar = new Money(200, Currency.USD);

        Money threeHundredDollar = oneHundredDollar.add(twoHundredDollar);
        Money expectedDollar = new Money(300, Currency.USD);

        assertThat(threeHundredDollar, is(expectedDollar));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWithDifferentCurrency() {
        Money oneHundredDollar = new Money(100, Currency.USD);
        Money twoHundredEuro = new Money(200, Currency.EUR);

        oneHundredDollar.add(twoHundredEuro);
    }

}
