package lab3;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> theAccounts;
    private ArrayList<Customer> theCustomers;

    //Constructor
    public Bank() {
        theAccounts = new ArrayList<Account>();
        theCustomers = new ArrayList<Customer>();
    }

    //Check if the bank has customers
    public boolean hasCustomer(String arg) {
        boolean dummy = false;
        for (int i = 0; i < theCustomers.size(); i++) {
            if (theCustomers.get(i).getName().equals(arg)) {
                dummy = true;
            }
        }
        return dummy;
    }

    //Add a new customer to the bank
    public void addCustomer(String arg) {
        if (hasCustomer(arg)) {
            System.out.println("The customer already exists.");
        } else {
            theCustomers.add(new Customer(arg));
            System.out.println("Customer added.");
        }
    }
    
    //Add a current account to a customer 
    public void addCurrentAccount(String name, double balance) {
        if (hasCustomer(name)) {
            Customer dummy = getCustomer(name);
            if (dummy.hasCurrentAccount()) {
                System.out.println("The customer already has a current account.");
            } else {
                CurrentAccount newAccount = new CurrentAccount(dummy, balance, this);
                theAccounts.add(newAccount);
                dummy.addCurrentAccount(newAccount);
                System.out.println("Added a account for " + dummy.getName());
            }
        } else {
            System.out.println("There is no customer with that name.");
        }
    }

    //Get a customer with specific name
    public Customer getCustomer(String name) {
        if (!hasCustomer(name))
            return null;
        else {
            Customer dummy;
            int irun = 0;
            do {
                dummy = theCustomers.get(irun);
                irun++;
            } while (!dummy.getName().equals(name));
            return dummy;
        }
    }

    //Add a savings account to a customer
    public void addSavingsAccount(String name) {
    	if(hasCustomer(name)) {
			Customer theCust = getCustomer(name);
			if(theCust.getCurrentAccount().hasSavingsAccount()) {
				System.out.println("The customer already has a savings account!");
			}else {
				SavingsAccount newSa = theCust.getCurrentAccount().createSavingsAccount();
				theAccounts.add(newSa);
				String i  = Integer.toString(theCust.getCurrentAccount().getAccountNumber());
				System.out.println("Added a savings account to the current account : " + i);
			}
		}else {
			System.out.println("There is no customer with that name");
		}
    }

    //Get the account with a specific ID
    public Account getAccount(int ID) {
        for (Account account : theAccounts) {
            if (account.getAccountNumber() == ID) {
                return account; 
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

    //Print out the information about the bank
    public String toString() {
        String result = "\nBank information : ";
        double totalValue = 0.0;
        for (int i = 0; i < theAccounts.size(); i++) {
            totalValue = totalValue + theAccounts.get(i).getBalance();
        }
        result = result + "\nNumber of customers : " + theCustomers.size();
        result = result + "\nNumber of accounts : " + theAccounts.size();
        result = result + "\nIt controls a total of " + totalValue;
        return result;
    }
    
    //Transfer money between accounts or between customers
	public void transfer(String name, String method, double money) {
		if(hasCustomer(name)) {
			if(getCustomer(name).hasCurrentAccount()) {
				CurrentAccount currCust = getCustomer(name).getCurrentAccount();
				if(this.getCustomer(name).getCurrentAccount().accountNumber > 0) {
					
					//Send money to savings accountn
					if(method.equals("save"))
					{	
						if(currCust.hasSavingsAccount()) {
							currCust.getSavingsAccount().recieve(money);
							currCust.theBalance -= money;
						}else {
							addSavingsAccount(name);
							currCust.getSavingsAccount().recieve(money);
							currCust.theBalance -= money;
						}
					
					//Send money from saving to current
					}else if (method.equals("withdraw")){
						if(currCust.hasSavingsAccount()) {
							if(money >= currCust.getSavingsAccount().theBalance) {
								money = currCust.getSavingsAccount().theBalance;
							}
							currCust.getSavingsAccount().send(money);
							currCust.theBalance += money;
						}					
						
					//Recieve money externally
					}else if(method.equals("external")) {
						currCust.receive(money);	
						
					//Send money between two customers
					}else if(hasCustomer(method)) {
	
						if(getCustomer(method).hasCurrentAccount()) {
							
							//CurrCust is the one that gets the transaction
							CurrentAccount takeFrom = getCustomer(method).getCurrentAccount();
							
							//Set up the transaction and send the money
							Transaction recieve = new Transaction(currCust.accountNumber, money , takeFrom.theBalance + money);
							takeFrom.theTransactions.add(recieve);
	
							currCust.send(takeFrom.getAccountNumber(), money);
							
							//Update the balance for the sending account
							takeFrom.theBalance += money;
						}
					}
				
				}
			}
		}
	}
    
	//Print out the transactions done at a given account
    public void transactions(String name) {
    	String result = "";
		if(getCustomer(name).hasCurrentAccount()) {
			result = getCustomer(name).getCurrentAccount().listTransactions();
			
		}
		System.out.println(result + "\n");
    }
}
