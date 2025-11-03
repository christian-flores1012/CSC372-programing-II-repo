package cta1BankSuperClass;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * reused BankAccount class from CTA1
 * I chose option #1 Bank Balance Application
 * 
 */

public class BankApp {

	public BankApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame bankAppFrame = new JFrame(); //creates a new frame
		
		final int BANK_APP_WIDTH = 170; // creates frame dimensions
		final int BANK_APP_HEIGHT = 300;
		bankAppFrame.setSize(BANK_APP_WIDTH, BANK_APP_HEIGHT); //sets frame size
		bankAppFrame.setTitle("Bank Screen");
		bankAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows exiting window
		bankAppFrame.setLocationRelativeTo(null); //centers window on monitor screen
		
		CheckingAccount acc = new CheckingAccount(); // creates new checking account
		
		
		JPanel bankPanel = new JPanel(); //creates bankPanel
		//bankPanel.setLayout(new CardLayout());//card layout
		
		JButton bankBalance = new JButton("Update Balance:"); //creates buttons for main menu
		JButton bankWithdrawal = new JButton("Withdrawal:");
		JButton bankDeposit = new JButton("Deposit:");

		
		
		JTextField depositLabel = new JTextField(10); //users to type deposit amount
		JTextField withdrawalLabel = new JTextField(10); //users to type deposit amount
		JLabel feedBack = new JLabel("  "); //gives feedback for user entries
		JTextField accountBalance = new JTextField(10); //stores account balance
		
		accountBalance.setText("$0");
		accountBalance.setEditable(false);
		
		bankWithdrawal.addActionListener(new ActionListener(){// of user selects withdrawal in menu
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double balance = Double.parseDouble(withdrawalLabel.getText() );// converts user input to double
					acc.withdrawl(balance); //updates acc
					feedBack.setText("Withdrew $" + balance); //gives feedback to show user withdrawal amount
				}
				catch(NumberFormatException ex ) {
					feedBack.setText("Withdrawal Failed!"); //button does not update balance 
				}
				withdrawalLabel.setText("");

			}
		});
		
		bankDeposit.addActionListener(new ActionListener(){ // same as withdrawal but with deposit
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double balance = Double.parseDouble(depositLabel.getText() );// converts user input to double
					acc.deposit(balance); //updates acc
					feedBack.setText("Deposited $" + balance); //gives feedback to show user withdrawal amount
				}
				catch(NumberFormatException ex ) {
					feedBack.setText("Deposit Failed!"); //button does not update balance 
				}
				depositLabel.setText("");

			}
		});
		
		bankBalance.addActionListener(new ActionListener(){ //update bank balance
			@Override
			public void actionPerformed(ActionEvent e) {
				accountBalance.setText( "$" + acc.getBalance() );

			}
		});
		

		bankPanel.add(depositLabel);//add menu items
		bankPanel.add(bankDeposit); 
		bankPanel.add(withdrawalLabel);
		bankPanel.add(bankWithdrawal);
		bankPanel.add(bankBalance);
		bankPanel.add(accountBalance);
		bankPanel.add(feedBack);


		
		
		
		bankAppFrame.add(bankPanel); //adds panel to frame
		bankAppFrame.setResizable(false); // locks frame dimensions
		bankAppFrame.setVisible(true); // makes frame visible
		
		
		
	}

}
