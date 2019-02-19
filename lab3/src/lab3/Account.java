package lab3;

public class Account {
    protected Customer theCustomer;
    protected int accountNumber;
    protected double theBalance;
    private static int availableNumbers = 0;
    protected String accountType;
    protected Bank theBank = null;
    public static final double CURRENTACCOUNTFEE = 10.0;
    public static final double SAVINGSINTEREST = 0.01;

    //Constructor
    public Account(Customer Cust, double balance, Bank bk) {
        theCustomer = Cust;
        theBalance = balance;
        availableNumbers = availableNumbers + 1;
        accountNumber = availableNumbers;
        theBank = bk;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return theBalance;
    }

    //Set the annual change in value
    public void annualChange() {

        if (accountType.equals("current")) {
            theBalance = theBalance - CURRENTACCOUNTFEE;
        } else if (accountType.equals("savings")) {
            theBalance = theBalance + theBalance * SAVINGSINTEREST;
        }
    }

    //Print out the accounts corresponding to a specific customer
    public String toString() {
        String result = "\n******************************";
        result = result + "\nAccount number : " + accountNumber;
        result = result + "\nCustomer : " + theCustomer.getName();
        result = result + "\nBalance : " + theBalance;
        result = result + "\n******************************";
        String s = accountType;
        if( s.matches("current") && (theCustomer.getCurrentAccount().hasSavingsAccount())) {
        	result = result + "\nSavings Account";
            result = result + "\nAccount number : " + theCustomer.getCurrentAccount().getSavingsAccount().getAccountNumber();
            result = result + "\nBalance : " + theCustomer.getCurrentAccount().getSavingsAccount().getBalance();
            result = result + "\n******************************";
        }
        return result;
    }
}
