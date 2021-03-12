package com.assignment2.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestTable extends JFrame {
	

	/**
	 * This is an instance of JPanel
	 */
	private JPanel mousePanel;
	/**
	 * Instance of JTable
	 */
	private JTable table;
	/**
	 * Instance of JButton
	 */
	private JButton buttonToSave;
	/**
	 * Instance of JScrollPane
	 */
	private JScrollPane scroll;
	private JPanel controlTable;
	/**
	 * This is an instance od JLabel
	 */
	private JLabel FinalScore;

	// Coloumns  for the table
	String[] columns = new String[] { "Car Number","Count", "Date", "Car Clciked At Time", "Program Track Reccord", "Track Date", "Crash Occured At Time" };

	// Data for the table
	Object[][] data = new Object[][] { {1, 0, 0, 0, 0, 0, 0 }, { 2,0, 0, 0, 0, 0, 0 }, { 3,0, 0, 0, 0, 0, 0 }, { 4,0, 0, 0, 0, 0, 0 },{ 5,0, 0, 0, 0, 0, 0 }, };
	private BufferedWriter writer;
	private FileWriter fileWriter;

	public void createGUI() {
		System.out.println("t");
		super.setSize(700, 500);
		mousePanel = new JPanel();
		controlTable = new JPanel();
		buttonToSave = new JButton("save");
		FinalScore = new JLabel();
		//FinalScore.setText(getScore());

		table = new JTable(data, columns);

		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(900, 900));
		scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		controlTable.add(scroll);
		add(controlTable, BorderLayout.NORTH);
		add(mousePanel, BorderLayout.PAGE_END);
		mousePanel.add(buttonToSave);
		mousePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		mousePanel.add(FinalScore);
		mousePanel.add(Box.createRigidArea(new Dimension(10, 5)));
		setTitle("Final Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	
	

}
