package Pig; //@notesForMe: java web start?
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Pig 
{
	static int currentRollValue = 0;
	static int potValue = 0;
	static boolean currentUser = true; //true = one / red
	static int userOneScore = 0;
	static int userTwoScore = 0;
	
	static JLabel userOneLabel = new JLabel("User One");
	static JLabel currentRoll = new JLabel("0");
	static JLabel userTwoLabel = new JLabel("User Two");
	static JLabel currentPot = new JLabel("Pot");
	static JButton rollButton = new JButton("Roll Again");
	static JButton takeButton = new JButton("Keep");
	public static void initGUI()
	{
		Random random = new Random();	
		//beginning of the bit that makes the jFrame
		JFrame frame = new JFrame("Frame"); //creates the jframe
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program when the frame is exited
		GridBagLayout progLayout = new GridBagLayout();
		frame.setLayout(progLayout);
		

			userOneLabel.setForeground(Color.RED);
			currentPot.setForeground(Color.RED);
			currentRoll.setForeground(Color.RED);

			userTwoLabel.setForeground(Color.BLUE);

		
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
		frame.add(currentPot, potCon);
		
		GridBagConstraints takeCon = new GridBagConstraints();
		takeCon.gridx = 2;
		takeCon.gridy = 1;
		frame.add(takeButton, takeCon);
		
		frame.pack(); //resizes the frame
		frame.setVisible(true); //shows the frame
		
		rollButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						onRoll(random);
					}
				});
		
		takeButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						onTake();
					}
				});
		//end of the bit that makes the jFrame
	}
	public static void main(String [] args)
	{	
		initGUI();
	}
	public static void onRoll(Random random)
	{
		takeButton.setEnabled(true);
		currentRollValue = random.nextInt(6) + 1;
		potValue += currentRollValue;
		currentRoll.setText(currentRollValue + "");
		currentPot.setText(potValue + "");
		if(currentRollValue == 1)
		{
			potValue = 0;
			onTake();
		}
	}
	public static void onTake()
	{
		if(currentUser)
		{
			userOneScore += potValue;
			userOneLabel.setText(userOneScore + "");
		}else
		{
			userTwoScore += potValue;
			userTwoLabel.setText(userTwoScore + "");
		}
		
		currentUser = !currentUser;
		takeButton.setEnabled(false);
		
		if(currentUser) //the bit that tells the users who's turn it is
		{
			currentRoll.setForeground(Color.RED); //sets the colour of the roll to the active player
			currentPot.setForeground(Color.RED); //sets the colour of the pot
		}else 
		{
			currentRoll.setForeground(Color.BLUE);
			currentPot.setForeground(Color.BLUE);
		}
		
		potValue = 0;
		
		currentRoll.setText(currentRollValue + "");
		currentPot.setText(potValue + "");
		
		if(userOneScore > 100)
			onWin(1);
		if(userTwoScore > 100)
			onWin(2);
	}
	public static void onWin(int winner)
	{
		String winnerName = winner == 1 ? "User One" : "User Two";
		System.out.println(winnerName + " won, the final score was " + userOneScore + ":" + userTwoScore);
		System.exit(0);
	}
}
