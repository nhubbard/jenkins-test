public class Barrel implements ICountable {
    private final int countBarrels;

    public Barrel(int barrels) {
        this.countBarrels = barrels;
    }

    @Override
    public int getCount() {
        return countBarrels;
    }
}
