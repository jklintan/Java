package lab3;
import java.util.*;

public class CurrentAccount extends Account {

    private SavingsAccount theSavingsAccount;
    private ArrayList<Transaction> theTransactions;

    public CurrentAccount(Customer Cust, double Money, Bank bk) {
        super(Cust, Money, bk);
        theBank = bk;
        accountType = "current";
        theSavingsAccount = null;
        theTransactions = new ArrayList<Transaction>();
    }

    public boolean hasSavingsAccount() {
        if (theSavingsAccount == null)
            return false;
        else
            return true;
    }

    public SavingsAccount createSavingsAccount() {
        if (!hasSavingsAccount())
            theSavingsAccount = new SavingsAccount(theCustomer, 0, theBank);
        else {
            System.out.println("A savings account already exists!");
            return null;
        }
        return theSavingsAccount;
    }

    public Customer getCustomer() {
        return theCustomer;
    }

    public Bank getBank() {
        return theBank;
    }

    public SavingsAccount getSavingsAccount() {
        return theSavingsAccount;
    }

    public void send(double money) {
    	theBalance = theBalance + money;
		Transaction payment = new Transaction(0, money, theBalance );
		theTransactions.add(payment);
    }

    //DONE METHOD
    public void send(int ID, double money) {
        if(theBank.getAccount(ID) != null){
            if(theBank.getAccount(ID).accountType == "savings"){
                System.out.println("That is not a current account");
            }
            double res = Math.min(theBalance, money);
            theBalance -= res;
            //theBank.getAccount(ID).receive(ID, res);
			res = -res;
			Transaction payment = new Transaction(ID, res , theBalance);
			theTransactions.add(payment);
        }else{
            System.out.println("No such account exists");
        }
    }

    public void receive(double money) {
        theBalance = theBalance + money;
        Transaction payment = new Transaction(0, money, theBalance);
        theTransactions.add(payment);
    }

    public void receive(int ID, double sum) {
        // If ID is 0, then
        theBalance += sum;
        if (ID == 0) {
            receive(sum);
        } else {
            Transaction payment = new Transaction(ID, sum, theBalance);
            theTransactions.add(payment);
        }
    }

    public String listTransactions() {
    	StringBuilder builder = new StringBuilder();
		builder.append("Transaction summary of the current account " + accountNumber);
			for(int i = 0; i < theTransactions.size(); i++) {
				builder.append("\n" + theTransactions.get(i));
			}
			
			return builder.toString();
        
    }
}
