package Pig; //java web start?
import java.awt.BorderLayout;

import javax.swing.*;
public class Pig 
{
	private static void initGUI() //creates the GUI for the game
	{
		JFrame frame = new JFrame("Frame"); //creates the jframe
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program when the frame is exited
		frame.getContentPane().add("", BorderLayout.CENTER);
		frame.pack(); //resizes the frame
		frame.setVisible(true); //shows the frame
	}
	
	public static void main(String [] args)
	{
		initGUI(); //creates the GUI
	}
}
