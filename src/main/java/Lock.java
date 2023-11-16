public class Lock implements ICountable {
    private final int countLocks;

    public Lock(int locks) {
        this.countLocks = locks;
    }
    public int getCount() {
        return countLocks;
    }
}
