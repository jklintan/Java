package lab3;

public class SavingsAccount extends Account {
	
	private CurrentAccount theCurrentAccount;
	
	SavingsAccount(Customer person, double money, Bank bk) {
		super(person, money, bk);
		accountType = "Savings";
		theBalance = 0;		
		theCurrentAccount = this.theCustomer.getCurrentAccount();
	}
	
	public void recieve(double money) {
		Transaction payment = new Transaction(this.theCustomer.getCurrentAccount().getAccountNumber(), -money , theBalance);
		theBalance = theBalance + money;
		theCurrentAccount.theTransactions.add(payment);
		
	}
	
	public double send(double money) {
		
		if(money <= theBalance) {
			Transaction payment = new Transaction(this.theCustomer.getCurrentAccount().getAccountNumber(), money , theBalance);
			theCurrentAccount.theTransactions.add(payment);
			theBalance = theBalance - money;
			
		}else {
			money = theBalance;
			Transaction payment = new Transaction(this.theCustomer.getCurrentAccount().getAccountNumber(), money , theBalance);
			theCurrentAccount.theTransactions.add(payment);
			theBalance = 0;
		}
		
		
		return money;
    }
}
