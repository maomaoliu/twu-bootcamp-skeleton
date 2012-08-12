public enum Currency {
    USD(1), EUR(1.56), GBP(1.23);
    private double rate;

    Currency(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
