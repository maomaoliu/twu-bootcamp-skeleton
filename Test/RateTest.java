import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RateTest {

    @Test
    public void shouldGetRateWithDayAndCurrent() {
        Rate rate = new Rate();

        double euroRateInDayTwo = rate.getRate(2, Currency.EUR);

        assertThat(euroRateInDayTwo, is(1.45));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWithIllegalDay() {
        Rate rate = new Rate();
        rate.getRate(0, Currency.USD);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowExceptionWithUnSupportedDay() {
        Rate rate = new Rate();
        rate.getRate(5, Currency.USD);
    }
}
