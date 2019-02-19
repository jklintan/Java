package lab3;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> theAccounts;
    private ArrayList<Customer> theCustomers;

    public Bank() {
        theAccounts = new ArrayList<Account>();
        theCustomers = new ArrayList<Customer>();
    }

    public boolean hasCustomer(String arg) {
        boolean dummy = false;
        for (int i = 0; i < theCustomers.size(); i++) {
            if (theCustomers.get(i).getName().equals(arg)) {
                dummy = true;
            }
        }
        return dummy;
    }

    public void addCustomer(String arg) {
        if (hasCustomer(arg)) {
            System.out.println("The customer already exists.");
        } else {
            theCustomers.add(new Customer(arg));
            System.out.println("Customer added.");
        }
    }

    public void addCurrentAccount(String arg1, double arg2) {
        if (hasCustomer(arg1)) {
            Customer dummy = getCustomer(arg1);
            if (dummy.hasCurrentAccount()) {
                System.out.println("The customer already has a current account.");
            } else {
                CurrentAccount newAccount = new CurrentAccount(dummy, arg2, this);
                theAccounts.add(newAccount);
                dummy.addCurrentAccount(newAccount);
                System.out.println("Added a account for " + dummy.getName());
            }
        } else {
            System.out.println("There is no customer with that name.");
        }
    }

    public Customer getCustomer(String arg) {
        if (!hasCustomer(arg))
            return null;
        else {
            Customer dummy;
            int irun = 0;
            do {
                dummy = theCustomers.get(irun);
                irun++;
            } while (!dummy.getName().equals(arg));
            return dummy;
        }
    }

    public void addSavingsAccount(String name) {
    	if(hasCustomer(name)) {
			Customer theCust = getCustomer(name);
			if(theCust.getCurrentAccount().hasSavingsAccount()) {
				System.out.println("The customer already has a savings account!");
			}else {
				SavingsAccount newSa = theCust.getCurrentAccount().createSavingsAccount();
				theAccounts.add(newSa);
				System.out.println("Added a savings account to the current account : ");
			}
			
		}else {
			System.out.println("There is no customer with that name");
		}
    }

    public Account getAccount(int ID) {
        for (Account account : theAccounts) {
            if (account.getAccountNumber() == ID) {
                return account; // Might cause issues! Return inside loop!
            }
        }
        System.out.println("No such account exists...");
        return null;
    }

    public void computeAnnualChange() {
        for (int i = 0; i < theAccounts.size(); i++) {
            theAccounts.get(i).annualChange();
        }
    }

    public String toString() {
        String result = "Bank information : ";
        double totalValue = 0.0;
        for (int i = 0; i < theAccounts.size(); i++) {
            totalValue = totalValue + theAccounts.get(i).getBalance();
        }
        result = result + "\nNumber of customers : " + theCustomers.size();
        result = result + "\nNumber of accounts : " + theAccounts.size();
        result = result + "\nIt controls a total of " + totalValue;
        return result;
    }
    
public void transfer(String name, String method, double money) {
	System.out.println("IM SENDING");
	if (hasCustomer(name)) {
		System.out.println("IM SENDING");
        if (getCustomer(name).hasCurrentAccount()) {
        	System.out.println("IM SENDING");
            CurrentAccount currCust = getCustomer(name).getCurrentAccount();
            if (method.equals("save")) {
            	System.out.println("IM SENDING");
                if (currCust.hasSavingsAccount()) {
                	System.out.println("IM SENDING");
                    currCust.send(money);
                } else {
                	System.out.println("IM CREATING");
                	System.out.println(currCust.getCustomer());
                    addSavingsAccount(name);
                    
                    currCust.send(money);
                }


            } else if (method.equals("withdraw")) {
                if (currCust.hasSavingsAccount()) {
                    currCust.send(money);
                }

            } else if (method.equals("external")) {
                // Pengar kommer från main
                currCust.receive(money);

            } else if (hasCustomer(method)) {
                if (getCustomer(method).hasCurrentAccount()) {
                    CurrentAccount currAccPay = getCustomer(name).getCurrentAccount();
                    int reciever = getCustomer(method).getCurrentAccount().getAccountNumber();
                    currAccPay.send(reciever, money);
                }
            }
        }
    }
	}
    
    public void transactions(String name) {
    	String result = "";
		if(getCustomer(name).hasCurrentAccount()) {
			result = getCustomer(name).getCurrentAccount().listTransactions();
			
		}
		System.out.println(result);
    }
}
