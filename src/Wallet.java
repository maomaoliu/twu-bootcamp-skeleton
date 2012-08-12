import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Wallet {


    public Money getCheapest(List<Money> moneyList) {
        Collections.sort(moneyList, new Comparator<Money>() {
            @Override
            public int compare(Money money1, Money money2) {
                if (money1 == null) return -1;
                if (money2 == null) return 1;
                if (getAmountInDollar(money1) > getAmountInDollar(money2)) return 1;
                else if (getAmountInDollar(money1) == getAmountInDollar(money2)) return 0;
                else return -1;
            }
        });
        return moneyList.get(0);
    }

    private double getAmountInDollar(Money money) {
        return money.getAmount() * money.getCurrency().getRate();
    }
}
