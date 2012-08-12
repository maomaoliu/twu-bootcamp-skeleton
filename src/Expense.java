import java.util.List;

public class Expense {
    private Rate rate = new Rate();

    private int day;
    private Money money;

    public Expense(int day, Money money) {
        this.day = day;
        this.money = money;
    }

    Money getMoneyInDollar() {
        Money money = this.money;
        double amountInDollar = money.getAmount() * this.rate.getRate(this.day, money.getCurrency());
        return new Money(amountInDollar, Currency.USD);
    }

    public Money calculateExpense(List<Expense> expenseList) {
        Money totalMoney = new Money(0, Currency.USD);
        for (Expense aExpense : expenseList) {
            totalMoney = totalMoney.add(aExpense.getMoneyInDollar());
        }
        return totalMoney;
    }

}
