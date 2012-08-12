import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExpenseTest {
    @Test
    public void shouldGetTotalExpenseWithSameDate() {
        Expense oneHundredDollarInDayOne = new Expense(1, new Money(100, Currency.USD));
        Expense oneHundredEuroInDayOne = new Expense(1, new Money(100, Currency.EUR));
        List<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(oneHundredDollarInDayOne);
        expenseList.add(oneHundredEuroInDayOne);
        Expense totalExpense = new Expense(1, null);

        Money totalMoney = totalExpense.calculateExpense(expenseList);
        Money expectedMoney = new Money(256, Currency.USD);

        assertThat(totalMoney, is(expectedMoney));
    }

    @Test
    public void shouldGetTotalExpenseWithDifferentDate() {
        Expense oneHundredDollarInDayOne = new Expense(1, new Money(100, Currency.USD));
        Expense oneHundredEuroInDayOne = new Expense(1, new Money(100, Currency.EUR));
        Expense oneHundredEuroInDayTwo = new Expense(2, new Money(100, Currency.EUR));
        List<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(oneHundredDollarInDayOne);
        expenseList.add(oneHundredEuroInDayOne);
        expenseList.add(oneHundredEuroInDayTwo);
        Expense totalExpense = new Expense(2, null);

        Money totalMoney = totalExpense.calculateExpense(expenseList);
        Money expectedMoney = new Money(401, Currency.USD);

        assertThat(totalMoney, is(expectedMoney));
    }
}
