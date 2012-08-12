
public class Money{
    private double amount;
    private Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money another) {
        if (!this.currency.equals(another.currency)) throw new IllegalArgumentException();
        return new Money(this.amount + another.amount, this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (Double.compare(money.amount, amount) != 0) return false;
        if (currency != money.currency) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + currency.hashCode();
        return result;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
