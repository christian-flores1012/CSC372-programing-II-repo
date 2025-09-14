package cta1BankSuperClass;

public class BankSimulation {

	public static void main(String[] args) {
		
		System.out.println("Testing Bank Account---------------------------------------------");
		
		BankAccount account = new BankAccount(); //testing bank account class
		
		account.setFirstName("Chris");
		account.setLastName("Vega");
		account.setId(2048);
		
		account.deposit(500.45);
		account.withdrawl(800.89);
		account.withdrawl(250);
		
		account.accountSummary();
		
		
		System.out.println("Testing Checking Account---------------------------------------------");
		
		CheckingAccount checking = new CheckingAccount(); //testing checking account class
		
		checking.setFirstName("Charlie");
		checking.setLastName("Cruz");
		checking.setId(3067);
		
		checking.deposit(1245.23);
		checking.withdrawl(100);
		checking.withdrawl(1500);
		checking.deposit(2000);
		
		checking.accountSummary();
		
		System.out.println("Checking Methods---------------------------------------------");
		
		checking.setInterestRate(9.18); //testing new methods
		checking.processWithdrawl(20);
		checking.displayAccount();

	}

}
