package cta1BankSuperClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/*
 * 
 * I chose option #2 Week 3 CTA User Interface Orange
 * 
 */

public class TopBarOrange {

	public TopBarOrange() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//creates a new frame
		JFrame topBarFrame = new JFrame(); 
		
		Random rand = new Random();
		//generates random hue of color Orange
		float hue = 0.04f + rand.nextFloat() * (0.15f - 0.03f); 
		float sat = 0.6f + rand.nextFloat() * 0.4f;             
		float bri = 0.8f + rand.nextFloat() * 0.2f;          
		Color executionOrange = Color.getHSBColor(hue, sat, bri);

		//turns hue value to string
		String hex = String.format("#%02X%02X%02X", 
		                           executionOrange.getRed(), 
		                           executionOrange.getGreen(), 
		                           executionOrange.getBlue());

		
		topBarFrame.setSize(400,400); //sets frame size
		topBarFrame.setTitle("Menu Screen");
		topBarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows exiting window
		topBarFrame.setLocationRelativeTo(null); //centers window on monitor screen
		topBarFrame.setLayout(new BorderLayout());
		
		//creates panel
		JPanel topPanel = new JPanel(); 
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
		//creates label and adds it to panel
		JLabel label = new JLabel("Content:");
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		topPanel.add(label);
		//creates text area
		JTextArea textArea = new JTextArea(5,30);
		//creates a top menu and options
		JMenuBar menuOptions = new JMenuBar();
		JMenu options = new JMenu("Options");
		//wraps the textArea in ScrollPane
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		//adds ScrollPane to panel
		topPanel.add(scrollPane);
		//creates the menu options
		JMenuItem option1 = new JMenuItem("Dat/Time");
		JMenuItem option2 = new JMenuItem("WriteToFile");
		JMenuItem option3 = new JMenuItem("ColorChange (" + hex + ")");
		JMenuItem option4 = new JMenuItem("Exit");
		
		//option1: gets current date and time and formats-prints it to textArea
		option1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
				textArea.setText("" + date);

			}
		});
		//option2: gets text from textArea in prints it to log.txt
		option2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//gets content from textArea
				String content = textArea.getText();
				try (BufferedWriter buff = new BufferedWriter(new FileWriter("log.txt", true))) {
					//writes content to log.txt
	                buff.write(content);
	                buff.newLine();
	                //shows pop up if successful
	                JOptionPane.showMessageDialog(topBarFrame, "Content added to log.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(topBarFrame, "Error writing to file:\n" + ex.getMessage(),
	                        "I/O Error", JOptionPane.ERROR_MESSAGE);
	            }
				//clears textArea
				textArea.setText("");

			}
		});
		//option3: paints panel containers to execution orange color
		option3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			    setBackgroundColor(topBarFrame.getContentPane(), executionOrange);
                topBarFrame.repaint();
			}
		});
		//option4:exits program
		option4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		
		//adds menu menuItems to options
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		//ads options to menuOptions
		menuOptions.add(options);
		//sets the menuBar with the menuOptions
		topBarFrame.setJMenuBar(menuOptions);
		//adds panel with all content to topBarFrame
		topBarFrame.getContentPane().add(topPanel);
		
		topBarFrame.setVisible(true); // makes frame visible
		
		
		
	}
	
	//helper methods
	private static void setBackgroundColor(Component c, Color color) {
	    c.setBackground(color);
	    //sets background color to all child containers
	    if (c instanceof Container) {
	        for (Component child : ((Container) c).getComponents()) {
	            setBackgroundColor(child, color);
	        }
	    }
	}

}
