package com.assignment2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.assignment2.controller.DemoViewController;

/**
 * 
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class FirstView {

	/**
	 * This is an instance of JFrame
	 */
	private JFrame mainFrame;
	/**
	 * This is used as an header in the frame
	 */
	private JLabel headerLabel;

	/**
	 * This is a panel to hold the buttons
	 */
	private JPanel controlPanel;
	/**
	 * This is the panel used to hold the text box
	 */
	private JPanel controlPanel1;

	/**
	 * Text element
	 */
	private JTextArea text;
	/**
	 * To enable scrollable
	 */
	private JScrollPane scroll;

	/**
	 * The bellow three elements are buttons
	 */
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	int count = 0;
	/**
	 * Instance of option view
	 */
	private OptionPane theModuleView;
	/**
	 * Instance of Demo view
	 */
	private DemoView demo;

	/**
	 * This is the constructor for the class
	 */
	public FirstView() {
		gui();
	}

	/**
	 * This method is used for the "About" button which ihs displayed in the
	 * menu It describes the game and the instructions which have to be followed
	 * to play the game
	 */
	public void aboutDialog() {
		String result = "1. Accept the terms and conditions this will take you to the next view page where the simulation begins. \n"
				+ "2. When the game is running, the player must make sure that the car's do not collide and prevent the car from.\n"
				+ "crashing a object.\n"
				+ "3. Every time a car collides with another or a object there is a buffer period of 3 seconds, if the user presses on  the car that has to be stopped the game resumes and the user gets a score, else the game fails and a new view is displayed.\n"
				+ "4. The game runs for a total of 300 seconds.\n"
				+ "5. At the end of 300 seconds the game stops and displays a table and Graph which has information such\n"
				+ "a. Click count.\n" + "b. Date of click.\n" + "c. Time of click.\n"
				+ "d. Program track record of the crash.\n" + "e. Date of the record generated.\n"
				+ "f. Time at which the record was generated";
		JTextArea about = new JTextArea(20, 30);
		about.setText(result);
		JOptionPane.showMessageDialog(null, result, "ABOUT ME", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * This is the listner class for button4
	 * 
	 * @param listenForButton4
	 *            Information of the game
	 */
	public void aboutListner(ActionListener listenForButton4) {
		button4.addActionListener(listenForButton4);
	}

	/**
	 * This is the listner class for button3
	 * 
	 * @param listenForbutton3
	 *            To set the background
	 */
	public void bckgroundListener(ActionListener listenForbutton3) {
		button3.addActionListener(listenForbutton3);
	}

	// When the Yes button is pressed

	public void demoFunction() {
		count++;
		if (count <= 3) {
			System.out.println("demo presentation");
			demo = new DemoView();
			demo.CreateGUIDemoView();
			DemoViewController d = new DemoViewController(demo);
		} else {
			JOptionPane.showMessageDialog(null, "Trial Has expierd please preceed to the real test!!! ", "DEMO",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * This is the listner class for button5
	 * 
	 * @param listenForButton5
	 *            Information of the game
	 */
	public void demoListner(ActionListener listenForButton5) {
		button5.addActionListener(listenForButton5);
	}

	// When the NO button is pressed

	// In Case of error
	/**
	 * @param errorMessage
	 *            If an error occured
	 */
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(text, errorMessage);
	}

	/**
	 * This is where the view is genrated
	 */
	private void gui() {
		mainFrame = new JFrame();
		mainFrame.setSize(600, 500);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
				System.exit(0);
			}
		});
		headerLabel = new JLabel("ASSIGNMENT 1");
		controlPanel = new JPanel();
		controlPanel1 = new JPanel();

		// for header
		controlPanel1.add(headerLabel);

		// for text inside
		String welcomeText = " This is a Traffic Simulator Game \n" + "\n This Game has three cars "
				+ "\n Each car moves at a speed of less than 40Km/hr " + "\n SCENARIO 1:"
				+ "\n All cars are travelling in a strainght line"
				+ "\n When brake is applied by a car in front the following cars reduce speed"
				+ "\n Objective of the game is to prevent the cars from crashing"
				+ "\n You will get a score with the click count in the form of a table if you succeed "
				+ "\n Else you will lose and have to restart again!" + "\n SCENARIO 2:"
				+ "\n Prevent the cars from crashing into an object which will appear abruptly"
				+ "\n Objective is to prevent the collision with the object"
				+ "\n You will get a score if the collision is prevented"
				+ "\n Else you will lose the and will have to restart again";

		text = new JTextArea();
		text.setText(welcomeText);
		text.setEditable(false);
		text.setBackground(Color.GRAY);
		scroll = new JScrollPane(text);
		scroll.setPreferredSize(new Dimension(50, 200));
		scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		// scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);;
		controlPanel1.add(Box.createRigidArea(new Dimension(100, 20)));
		controlPanel1.setLayout(new BoxLayout(controlPanel1, BoxLayout.PAGE_AXIS));
		controlPanel1.add(scroll);

		// For buttons
		controlPanel.add(Box.createRigidArea(new Dimension(0, 60)));
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
		button1 = new JButton("YES");
		button2 = new JButton("NO");
		button3 = new JButton("SET BACK-GROUND COLOUR");
		button4 = new JButton("About");
		button5 = new JButton("DEMO");
		controlPanel.add(Box.createHorizontalGlue());
		controlPanel.add(button1);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(button2);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		controlPanel.add(button3);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(button4);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(button5);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));

		// Main Frame
		mainFrame.add(controlPanel1, BorderLayout.NORTH);
		mainFrame.add(controlPanel, BorderLayout.PAGE_END);
		mainFrame.setVisible(true);

	}

	/**
	 * This is the listner class for button2
	 * 
	 * @param listenForButton2
	 *            To close the game
	 */
	public void noListner(ActionListener listenForButton2) {
		button2.addActionListener(listenForButton2);
	}

	// To set the bckground
	/**
	 * This method is used to set the background
	 */
	public void setBckground() {
		mainFrame.getContentPane().setBackground(Color.darkGray);
		controlPanel.setBackground(Color.darkGray);
		controlPanel1.setBackground(Color.darkGray);
	}

	public void startTheModule() {
		theModuleView = new OptionPane();
		theModuleView.createGUI();

	}

	/**
	 * This is the listner class for button1
	 * 
	 * @param listenForButton1
	 *            To start the game
	 */
	public void yesListner(ActionListener listenForButton1) {
		button1.addActionListener(listenForButton1);
	}

}
