package cta1BankSuperClass;
import java.text.DecimalFormat;

public class BankAccount {
	
	DecimalFormat df = new DecimalFormat("0.00"); //formats output of balance
	
	private String firstName; //variables
	private String lastName;
	private int id = -1;
	private double balance;
	
	public BankAccount() { // constructor
		this.balance = 0;
		System.out.println("\nAccount created successfully.");
		System.out.println("Current balance: $" + df.format( this.getBalance() ));
	}
	
	
	public void deposit(double amount) { // adds money to the account
		this.balance += amount;
		if(amount > 0) {
			System.out.println("\nDeposit of $" + df.format(amount) + " successful.");
		}
		else {
			System.out.println("\nWithdrawl of $" + df.format(amount) + " successful.");
		}
		System.out.println("Current balance: $" + df.format( this.getBalance() ));
	}
	
	public void withdrawl(double amount) { //removes money from the account
		if (amount > this.getBalance()) {
			System.out.println("\nInsufficient funds. Withdrawl of $-" + df.format(amount) + " failed.");
			System.out.println("Current balance: $" + df.format( this.getBalance() ));
		}
		else {
			this.deposit(amount * -1);
		}
		
	}
	
	public String getFirstName() {return this.firstName;} //getters
	public String getLastName() {return this.lastName;}
	public int getId() {return this.id;}
	
	public void setFirstName(String name) {this.firstName = name;} //setters
	public void setLastName(String last) {this.lastName = last;}
	public void setId(int id) {this.id =  id;}
	
	public double getBalance() {return this.balance;} //get balance
	
	public void accountSummary() { //prints account info
		System.out.println("\nAccount Information:");
		System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
		System.out.println("Account ID: " + this.getId());
		System.out.println("Account Balance: " + df.format(this.getBalance() ));
	}

}
