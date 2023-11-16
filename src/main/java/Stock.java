public class Stock implements ICountable {
    private final int countStocks;

    public Stock(int stocks) {
        this.countStocks = stocks;
    }

    @Override
    public int getCount() {
        return countStocks;
    }
}
