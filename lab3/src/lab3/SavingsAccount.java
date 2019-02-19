package lab3;

public class SavingsAccount extends Account {
	
	private CurrentAccount theCurrentAccount;
	
	//Constructor
	SavingsAccount(Customer person, double money, Bank bk) {
		super(person, money, bk);
		accountType = "Savings";
		theBalance = 0;		
		theCurrentAccount = this.theCustomer.getCurrentAccount();
	}
	
	//Get money to the account
	public void recieve(double money) {
		Transaction payment = new Transaction(theCustomer.getCurrentAccount().getSavingsAccount().accountNumber, -money , theCustomer.getCurrentAccount().getBalance() - money);
		theBalance = theBalance + money;
		theCurrentAccount.theTransactions.add(payment);
		
	}
	
	//Send money from savings account to current account
	public double send(double money) {
		if(money <= theBalance) {
			theBalance = theBalance - money;
			Transaction payment = new Transaction(theCustomer.getCurrentAccount().getSavingsAccount().accountNumber, money, theCustomer.getCurrentAccount().getBalance() + money);
			theCurrentAccount.theTransactions.add(payment);
			
		}else {
			money = theBalance;
			Transaction payment = new Transaction(theCustomer.getCurrentAccount().getSavingsAccount().accountNumber, money , theBalance);
			theCurrentAccount.theTransactions.add(payment);
			theBalance = 0;

		}
		return money;
    }
}
