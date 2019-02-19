package lab3;

public class SavingsAccount extends Account {
	private CurrentAccount theCurrentAccount;
	
	SavingsAccount(Customer person, double money, Bank bk) {
		super(person, money, bk);
		accountType = "Savings";
		theBalance = 0;		
	}
	
	public void recieve(double money) {
		theBalance = theBalance + money;
	}
	
	public double send(double money) {
		System.out.println("IM IN THE SEND FUNCT");
		if(money <= theBalance) {
			theBalance = theBalance - money;
			
		}else {
			theBalance = 0;
		}
		return money;
    }
}
