package lab3;

public class Customer {

    private String theName;
    private CurrentAccount theCurrentAccount = null;

    //Constructor
    public Customer(String arg) {
        theName = arg.trim();
    }

    //Get the name of customer
    public String getName() {
        return theName;
    }

    //Check if the customer has an account
    public boolean hasCurrentAccount() {
        if ((theCurrentAccount == null))
            return false;
        else
            return true;
    }

    //Connect an account to the customer
    public void addCurrentAccount(CurrentAccount arg) {
        theCurrentAccount = arg;
    }

    //Get the current account for the customer
    public CurrentAccount getCurrentAccount() {
        return theCurrentAccount;
    }

    //Print out information about a customer
    public String toString() {
        String result = "\n******************************";
        result = result + "\nCustomer : " + theName;
        if (hasCurrentAccount()) {
            result = result + "\nAccount number : " + String.valueOf(theCurrentAccount.getAccountNumber());
        }
        result = result + "\n******************************";
        return result;
    }
}