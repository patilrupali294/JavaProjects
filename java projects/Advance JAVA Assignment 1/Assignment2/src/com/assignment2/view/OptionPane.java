package com.assignment2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.assignment2.controller.PractiseViewController;

public class OptionPane extends JFrame implements ActionListener {

	private 	ButtonGroup group ;
	private JRadioButton option1;
	private JRadioButton option2;
	private JRadioButton option3;
	private JRadioButton option4;
	private JRadioButton option5;

	// radio buttons for colors
	private ButtonGroup groupforcolor ;
	private JRadioButton optioncolor1;
	private JRadioButton optioncolor2;
	private JRadioButton optioncolor3;
	private JRadioButton optioncolor4;
	private JRadioButton optioncolor5;



	private JLabel labelForCars;
	private JLabel labelForCarColor;
	private JLabel labelForCarSpeed;
	private JButton startButton;
	private JButton resetButton;
	private JButton backButton;

	private JPanel panelForbuttons;
	private JPanel panelForSpeed;
	
	
	private JComboBox<Integer> combo;
	private JComboBox<Integer> combo1;
	private JComboBox<Integer> combo2;
	private JComboBox<Integer> combo3;
	private JComboBox<Integer> combo4;
	
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	
	//Variables to store car details
	 int numberofCars;
	 public int getNumberofCars() {
		return numberofCars;
	}

	public void setNumberofCars(int numberofCars) {
		this.numberofCars = numberofCars;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}



	Color c;

int scar1;
public int getScar1() {
	return scar1;
}

public void setScar1(int scar1) {
	this.scar1 = scar1;
}

public int getScar2() {
	return scar2;
}

public void setScar2(int scar2) {
	this.scar2 = scar2;
}

public int getScar3() {
	return scar3;
}

public void setScar3(int scar3) {
	this.scar3 = scar3;
}

public int getScar4() {
	return scar4;
}

public void setScar4(int scar4) {
	this.scar4 = scar4;
}

public int getScar5() {
	return scar5;
}

public void setScar5(int scar5) {
	this.scar5 = scar5;
}



int scar2;
int scar3;
int scar4;
int scar5;

	
	
	
	
	
	
	
	 
Integer speedforcars[]=new Integer[39];
int isp=1;
	
	 
	 
	public void createGUI() {
		option1 = new JRadioButton("1");
		option2 = new JRadioButton("2");
		option3 = new JRadioButton("3");
		option4 = new JRadioButton("4");
		option5 = new JRadioButton("5");

		optioncolor1 = new JRadioButton("Black");
		optioncolor2 = new JRadioButton("White");
		optioncolor3 = new JRadioButton("Red");
		optioncolor4 = new JRadioButton("Orange");
		optioncolor5 = new JRadioButton("Yellow");


		startButton = new JButton("Start");
		resetButton = new JButton("Reset");
		backButton = new JButton("Back");
		// for Cars
		group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);
		group.add(option4);
		group.add(option5);

		option1.setSelected(true);
		// for color of cars
		groupforcolor = new ButtonGroup();
		groupforcolor.add(optioncolor1);
		groupforcolor.add(optioncolor2);
		groupforcolor.add(optioncolor3);
		groupforcolor.add(optioncolor4);
		groupforcolor.add(optioncolor5);

		optioncolor1.setSelected(true);
		

		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(Box.createRigidArea(new Dimension(100, 10)));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.	PAGE_AXIS));
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		//number of cars
		labelForCars = new JLabel("SELECT THE NUMBER OF CARS ");
		constraints.gridx=0;
		constraints.gridy=0;
		panel.add(labelForCars,constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(option1, constraints);
		//panel.add(combo,constraints);
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(option2, constraints);
		//panel.add(combo1);
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(option3, constraints);
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(option4, constraints);
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(option5, constraints);

		//FOR SPEED FOR EACH CAR
		labelForCarSpeed=new JLabel("SPEED FOR EACH CAR");
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.ipadx = 10;
		constraints.ipady = 12;
		constraints.anchor=GridBagConstraints.WEST;
        panel.add(labelForCarSpeed, constraints);
        
		label1=new JLabel("Speed for car1");
		constraints.gridx = 0;
		constraints.gridy = 9;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor=GridBagConstraints.WEST;
        panel.add(label1, constraints);
        
		label2=new JLabel("Speed of car2");
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor=GridBagConstraints.WEST;
        panel.add(label2, constraints);
        
		label3=new JLabel("Speed of car3");
		constraints.gridx = 0;
		constraints.gridy = 11;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor=GridBagConstraints.WEST;
        panel.add(label3, constraints);
        
		label4=new JLabel("Speed of car4");
		constraints.gridx = 0;
		constraints.gridy = 12;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor=GridBagConstraints.WEST;
        panel.add(label4, constraints);
        
		label5=new JLabel("Speed of car5");
		constraints.gridx = 0;
		constraints.gridy = 13;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor=GridBagConstraints.WEST;
        panel.add(label5, constraints);
		
		for(int i=0;i<speedforcars.length;i++)
		{
			speedforcars[i]=i;
			//isp++;
		}
		
		combo = new JComboBox<>(speedforcars);
		constraints.gridx = 5;
		constraints.gridy = 9;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor = GridBagConstraints.WEST;
		combo.setSelectedItem(0);
		panel.add(combo, constraints);
		combo1 = new JComboBox<>(speedforcars);
		constraints.gridx = 5;
		constraints.gridy = 10;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor = GridBagConstraints.WEST;
		combo1.setSelectedItem(0);
		panel.add(combo1, constraints);
		
		combo2 = new JComboBox<>(speedforcars);
		constraints.gridx = 5;
		constraints.gridy = 11;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor = GridBagConstraints.WEST;
		combo2.setSelectedItem(0);
		
		panel.add(combo2, constraints);
		combo3 = new JComboBox<>(speedforcars);
		constraints.gridx = 5;
		constraints.gridy = 12;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor = GridBagConstraints.WEST;
		combo3.setSelectedItem(0);
		panel.add(combo3, constraints);
		
		combo4 = new JComboBox<>(speedforcars);
		constraints.gridx = 5;
		constraints.gridy = 13;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.anchor = GridBagConstraints.WEST;
		combo4.setSelectedItem(0);
		panel.add(combo4, constraints);

		
		
		

		

		
		
		
		
		
	
		//COLOR FOR CARS
		labelForCarColor = new JLabel("SELECT THE COLOR OF CARS");
		constraints.gridx=0;
		constraints.gridy=15;
		
		panel.add(labelForCarColor,constraints);

		constraints.gridy = 16;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(optioncolor1, constraints);
		constraints.gridy = 17;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(optioncolor2, constraints);
		constraints.gridy = 18;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(optioncolor3, constraints);
		constraints.gridy = 19;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(optioncolor3, constraints);
		constraints.gridy = 20;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(optioncolor5, constraints);

	

		panel.add(startButton);
		panel.add(resetButton);

		panelForbuttons = new JPanel();
		panelForbuttons.add(Box.createRigidArea(new Dimension(0, 60)));

		panelForbuttons.add(Box.createHorizontalGlue());
		panelForbuttons.add(startButton);
		panelForbuttons.add(Box.createRigidArea(new Dimension(10, 10)));
		panelForbuttons.add(resetButton);
		panelForbuttons.add(Box.createRigidArea(new Dimension(10, 10)));
		panelForbuttons.add(backButton);
		panelForbuttons.add(Box.createRigidArea(new Dimension(10, 10)));

		add(panel);
		pack();
		add(panelForbuttons, BorderLayout.PAGE_END);
		//add(panelForSpeed,BorderLayout.NORTH);

		startButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);
		setSize(500, 550);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object buttonValue = e.getActionCommand();
	
		try {
			if (buttonValue.equals("Start")) {
				if (option1.isSelected()) {
					setNumberofCars(1);
					
					scar1=(int) combo.getSelectedItem();
					setScar1(scar1);
				}
				if (option2.isSelected()) {
					setNumberofCars(2);
					scar1=(int) combo.getSelectedItem();
					setScar1(scar1);
					scar2=(int) combo1.getSelectedItem();
					setScar2(scar2);
				}
				if (option3.isSelected()) {
					setNumberofCars(3);
					scar1=(int) combo.getSelectedItem();
					setScar1(scar1);
					scar2=(int) combo1.getSelectedItem();
					setScar2(scar2);
					scar3=(int) combo2.getSelectedItem();
					setScar3(scar3);
				}
				if (option4.isSelected()) {
					setNumberofCars(4);
					scar1=(int) combo.getSelectedItem();
					setScar1(scar1);
					scar2=(int) combo1.getSelectedItem();
					setScar2(scar2);
					scar3=(int) combo2.getSelectedItem();
					setScar3(scar3);
					scar4=(int) combo3.getSelectedItem();
					setScar4(scar4);
				}
				if (option5.isSelected()) {
					setNumberofCars(5);
					scar1=(int) combo.getSelectedItem();
					setScar1(scar1);
					scar2=(int) combo1.getSelectedItem();
					setScar2(scar2);
					scar3=(int) combo2.getSelectedItem();
					setScar3(scar3);
					scar4=(int) combo3.getSelectedItem();
					setScar4(scar4);
					scar5=(int) combo4.getSelectedItem();
					setScar5(scar5);
					
				}

				// FOR COLOR
				if (optioncolor1.isSelected()) {
					setC(Color.BLACK);
				}
				if (optioncolor2.isSelected()) {
					setC(Color.white);
				}
				if (optioncolor3.isSelected()) {
					setC(Color.RED);
				}
				if (optioncolor4.isSelected()) {
					setC(Color.ORANGE);
				}
				if (optioncolor5.isSelected()) {
					setC(Color.yellow);
				}
				
		PractiseTestView p1=new PractiseTestView();
		p1.CreateGUIDemoView();
		p1.totalNumberofcars=getNumberofCars();
		p1.carColor=getC();
		p1.carspeed1=getScar1();
		p1.carspeed2=getScar2();
		p1.carspeed3=getScar3();
		p1.carspeed4=getScar4();
		p1.carspeed5=getScar5();
		PractiseViewController v=new PractiseViewController(p1);
				

				
			} else if (buttonValue.equals("Reset")) {
		
				group.clearSelection();
				groupforcolor.clearSelection();
				
				
			for (int i = 0; i < speedforcars.length; i++) {
                    //here you can give your combo the number of index
						combo.setSelectedIndex(0);
						combo.addItem(speedforcars[i]);
						combo1.setSelectedIndex(0);
						combo1.addItem(speedforcars[i]);
						combo2.setSelectedIndex(0);
						combo2.addItem(speedforcars[i]);
						combo3.setSelectedIndex(0);
						combo3.addItem(speedforcars[i]);
						combo4.setSelectedIndex(0);
						combo4.addItem(speedforcars[i]);
				}
			}
		} catch (Exception v) {

		}
	}
	
	
	
	
}
