package lab3;

public class Customer {

    private String theName;
    private CurrentAccount theCurrentAccount = null;

    public Customer(String arg) {
        theName = arg.trim();
    }

    public String getName() {
        return theName;
    }

    public boolean hasCurrentAccount() {
        if ((theCurrentAccount == null))
            return false;
        else
            return true;
    }

    public void addCurrentAccount(CurrentAccount arg) {
        theCurrentAccount = arg;
    }

    public CurrentAccount getCurrentAccount() {
        return theCurrentAccount;
    }

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