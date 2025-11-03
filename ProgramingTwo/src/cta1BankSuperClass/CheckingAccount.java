package cta1BankSuperClass;

public class CheckingAccount extends BankAccount {
	
	private double interestRate; //variables

	public CheckingAccount() { //constructor with superclass
		super();
		this.interestRate = 0;
	}
	
	public double getInterestRate() { return this.interestRate; } //getter for new method
	
	public void setInterestRate(double interest) { this.interestRate = interest; } // setter for new method
	
	@Override
	public void withdrawl(double amount) { processWithdrawl(amount);} // override superclass methods
	
	@Override
	public void accountSummary() {displayAccount();}
	
	
	public void processWithdrawl(double amount){ //allows overdraft withdraw
		//if you withdraw more than balance account will go netative plus 30 dollar extra negative balance for overdraft
		if (amount > super.getBalance()) {
			System.out.println("\nOverdraft on withdrawl of $-" + amount + ". $-30 fee will be applied to negative balance.");
			this.deposit(amount * -1);
			this.deposit(-30);
		}
		// if withdraw amount is less than account balance no overdraft fee is palaced
		else {
			this.deposit(amount * -1);
		}


	}
	
	public void displayAccount() { //adds interest to account info
		super.accountSummary();
		System.out.println("Interest Rate: " + this.getInterestRate());
	}

}
