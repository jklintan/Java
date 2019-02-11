package lab3;

public class Transaction {
    private int otherAccount = 0;
    private double money;
    private double balance;

    // Constructor
    Transaction(int i, double arg1, double arg2) {
        otherAccount = i;
        money = arg1;
        balance = arg2 - money;
    }

    public String toString() {
        System.out.println(otherAccount);
        System.out.println(money);
        System.out.println(balance);

        return Integer.toString(otherAccount) + Double.toString(money) + Double.toString(balance);
    }
}
