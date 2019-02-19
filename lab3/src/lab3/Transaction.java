package lab3;

public class Transaction {
    private int otherAccount = 0;
    private double money;
    private double balance;

    // Constructor
    Transaction(int i, double arg1, double arg2) {
        otherAccount = i;
        money = arg1;
        balance = arg2;
    }
    
    public String toString() {
        return "Account: " + Integer.toString(otherAccount) + " Transfered money: " 
        		+ Double.toString(money) + " Balance: " + Double.toString(balance);
    }
}
