public class Driver {
    public static void main(String[] args) {
        CalculateCommission calculate = new CalculateCommission();
        System.out.println("Commission: " + calculate.getCommission(new Lock(5), new Stock(5), new Barrel(5)));
        System.out.println("Commission: " + calculate.getCommission(new Lock(-1), new Stock(5), new Barrel(5)));
    }
}