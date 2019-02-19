package lab3;
import java.util.*;

public class CurrentAccount extends Account {

    private SavingsAccount theSavingsAccount;
    public ArrayList<Transaction> theTransactions;

    //Constructor
    public CurrentAccount(Customer Cust, double Money, Bank bk) {
        super(Cust, Money, bk);
        theBank = bk;
        accountType = "current";
        theSavingsAccount = null;
        theTransactions = new ArrayList<Transaction>();
    }

    //Check if the current customer has a savings account
    public boolean hasSavingsAccount() {
        if (theSavingsAccount == null)
            return false;
        else
            return true;
    }

    //Create a new savings account for the customer
    public SavingsAccount createSavingsAccount() {
        if (!hasSavingsAccount())
            theSavingsAccount = new SavingsAccount(theCustomer, 0, theBank);
        else {
            System.out.println("A savings account already exists!");
            return null;
        }
        return theSavingsAccount;
    }

    //Get the specific customer
    public Customer getCustomer() {
        return theCustomer;
    }

    //Get the bank for the current account
    public Bank getBank() {
        return theBank;
    }

    //Check if the current account has a savings account
    public SavingsAccount getSavingsAccount() {
        return theSavingsAccount;
    }

    //Send money
    public void send(double money) {
    	theBalance = theBalance - money;
		Transaction payment = new Transaction(0, money, theBalance );
		theTransactions.add(payment);
    }

    //Send money to another account
    public void send(int ID, double money) {
        if(theBank.getAccount(ID) != null){
            if(theBank.getAccount(ID).accountType == "savings"){
                System.out.println("That is not a current account");
            }
            double res = Math.min(theBalance, money);
            theBalance -= res;
			res = -res;
			Transaction payment = new Transaction(ID, res , theBalance);
			theTransactions.add(payment);
        }else{
            System.out.println("No such account exists");
        }
    }

    //Receive money externally
    public void receive(double money) {
        theBalance = theBalance + money;
        Transaction payment = new Transaction(0, money, theBalance);
        theTransactions.add(payment);
    }

    //Get money transferred to the current account
    public void receive(int ID, double sum) {
    	Account receiver = theBank.getAccount(ID);
		if(receiver == null)
		{
			System.out.println("The account doesn't exist");
		}
		else
		{
			if(receiver instanceof SavingsAccount)
			{
				System.out.println("That is not a current account");
			}
			else
			{
				double res = Math.min(theBalance, sum);
				
				//Update the balance at the account
				theBalance -= res;
				
				//Send money to the receiver
				((CurrentAccount)receiver).send(accountNumber, res);
				
				res = -res;
				Transaction payment = new Transaction(ID, res , theBalance);
				theTransactions.add(payment);
			}
			
			
		}
    }

    //List up all the transactions for the current account
    public String listTransactions() {
    	StringBuilder builder = new StringBuilder();
		builder.append("Transaction summary of the current account " + accountNumber);
			for(int i = 0; i < theTransactions.size(); i++) {
				builder.append("\n" + theTransactions.get(i));
			}
			
			return builder.toString();
        
    }
}
