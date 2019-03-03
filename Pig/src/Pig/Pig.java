package Pig; //@notesForMe: java web start?
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class Pig 
{
	private static void initGUI() //creates the GUI for the game
	{
		JFrame frame = new JFrame("Frame"); //creates the jframe
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program when the frame is exited
		frame.setLayout(new GridBagLayout());
		
		JLabel userOneLabel = new JLabel("User One");
		JLabel currentRoll = new JLabel("0");
		JLabel userTwoLabel = new JLabel("User Two");
		JLabel CurrentPot = new JLabel("Pot");
		JButton rollButton = new JButton("Roll Again");
		JButton takeButton = new JButton("Keep");
		
		GridBagConstraints userOneCon = new GridBagConstraints();
		userOneCon.gridx = 0;
		userOneCon.gridy = 0;
		frame.add(userOneLabel, userOneCon);
		
		GridBagConstraints rollCon = new GridBagConstraints();
		rollCon.gridx = 1;
		rollCon.gridy = 0;
		frame.add(currentRoll, rollCon);
		
		GridBagConstraints userTwoCon = new GridBagConstraints();
		userTwoCon.gridx = 2;
		userTwoCon.gridy = 0;
		frame.add(userTwoLabel, userTwoCon);
		
		GridBagConstraints rollButtonCon = new GridBagConstraints();
		rollButtonCon.gridx = 0;
		rollButtonCon.gridy = 1;
		frame.add(rollButton, rollButtonCon);
		
		GridBagConstraints potCon = new GridBagConstraints();
		potCon.gridx = 1;
		potCon.gridy = 1;
		frame.add(CurrentPot, potCon);
		
		GridBagConstraints takeCon = new GridBagConstraints();
		takeCon.gridx = 2;
		takeCon.gridy = 1;
		frame.add(takeButton, takeCon);
		
		frame.pack(); //resizes the frame
		frame.setVisible(true); //shows the frame
	}
	
	public static void main(String [] args)
	{
		initGUI(); //creates the GUI
	}
}
