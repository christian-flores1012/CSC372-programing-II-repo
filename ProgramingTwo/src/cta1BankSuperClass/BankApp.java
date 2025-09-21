package cta1BankSuperClass;
import javax.swing.*;
import java.util.*;
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
		final int BANK_APP_HEIGHT = 200;
		bankAppFrame.setSize(BANK_APP_WIDTH, BANK_APP_HEIGHT); //sets frame size
		bankAppFrame.setTitle("Bank Screen");
		bankAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows exiting window
		bankAppFrame.setLocationRelativeTo(null); //centers window on monitor screen
		
		CheckingAccount acc = new CheckingAccount(); // creates new checking account
		
		
		JPanel bankPanel = new JPanel(); //creates bankPanel
		
		JButton bankBalance = new JButton("Account Balance:"); //creates buttons for main menu
		JButton bankWithdrawal = new JButton("Withdrawal:");
		JButton bankDeposit = new JButton("Deposit:");
		
		JButton realWithdrawal = new JButton("Withdrawal:");// creates buttons for deposit and withdrawal menus
		JButton realDeposit = new JButton("Deposit:");
		JButton backButton = new JButton("Back"); // button to go back to main menu
		
		
		JTextField depositLabel = new JTextField(10); //users to type deposit amount
		JLabel feedBack = new JLabel("  "); //gives feedback for user entries
		JLabel accountBalance = new JLabel(""); //stores account balance
		
		bankWithdrawal.addActionListener(new ActionListener(){// of user selects withdrawal in menu
			@Override
			public void actionPerformed(ActionEvent e) {
				bankPanel.removeAll(); //removes all buttons
				bankPanel.revalidate(); // repaints the screen
				bankPanel.repaint();
				bankPanel.add(depositLabel); //adds text box for users to put amount
				bankPanel.add(realWithdrawal); // adds withdrawal button
				bankPanel.add(backButton); // adds back button
				bankPanel.add(feedBack); // adds label so users know if button was successful
			}
		});
		
		bankDeposit.addActionListener(new ActionListener(){ // same as withdrawal but with deposit
			@Override
			public void actionPerformed(ActionEvent e) {
				bankPanel.removeAll();
				bankPanel.revalidate();
				bankPanel.repaint();
				bankPanel.add(depositLabel);
				bankPanel.add(realDeposit);
				bankPanel.add(backButton);
				bankPanel.add(feedBack);
			}
		});
		
		bankBalance.addActionListener(new ActionListener(){ //displays account balance
			@Override
			public void actionPerformed(ActionEvent e) {
				accountBalance.setText("Balance: $" + acc.getBalance() ); //gets account balance from acc
				bankPanel.removeAll();//clears and repaints panel
				bankPanel.revalidate();
				bankPanel.repaint();
				bankPanel.add(accountBalance); //adds account balance
				bankPanel.add(backButton); // adds back button
			}
		});
		
		realWithdrawal.addActionListener(new ActionListener(){// button that actually changes balance
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double balance = Double.parseDouble(depositLabel.getText() );// converts user input to double
					acc.withdrawl(balance); //updates acc
					feedBack.setText("Withdrew $" + balance); //gives feedback to show user withdrawal amount
				}
				catch(NumberFormatException ex ) {
					feedBack.setText("Withdrawal Failed!"); //button does not update balance 
				}

			}
		});
		
		realDeposit.addActionListener(new ActionListener(){ //same as withdrawal but with deposit
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double balance = Double.parseDouble(depositLabel.getText() );
					acc.deposit(balance);// updates balance
					feedBack.setText("Deposited $" + balance);
				}
				catch(NumberFormatException ex ) {
					feedBack.setText("Deposit Failed!"); // button does not do anything shows failure message
				}

			}
		});
		
		backButton.addActionListener(new ActionListener(){ //clears panel and adds menu buttons
			@Override
			public void actionPerformed(ActionEvent e) {
				bankPanel.removeAll(); // clears and repaints panel
				bankPanel.revalidate();
				bankPanel.repaint();
				feedBack.setText("  ");
				depositLabel.setText("");
				bankPanel.add(bankDeposit); // adds all 3 menu buttons
				bankPanel.add(bankWithdrawal);
				bankPanel.add(bankBalance);
			}
		});
		

		bankPanel.add(bankDeposit); //initial 3 menu items
		bankPanel.add(bankWithdrawal);
		bankPanel.add(bankBalance);
		
		
		
		bankAppFrame.add(bankPanel); //adds panel to frame
		bankAppFrame.setResizable(false); // locks frame dimensions
		bankAppFrame.setVisible(true); // makes frame visible
		
		
		
	}

}
