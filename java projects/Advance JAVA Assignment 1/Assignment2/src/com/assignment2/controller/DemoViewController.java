package com.assignment2.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.assignment2.Model.Vehicle;
import com.assignment2.view.DemoView;

public class DemoViewController {

	private DemoView theDemoView;

	public DemoViewController(DemoView theDemoView)
	{
		this.theDemoView=theDemoView;
		this.theDemoView.addCarListener(new listner());
		this.theDemoView.startCarListener(new listner());
		this.theDemoView.stopCarListener(new listner());

	}
	class listner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object buttonValue = e.getActionCommand();
			System.out.println("Enterd");
			System.out.println(buttonValue);
			try{
			if(buttonValue.equals("Add Car"))
			{
				theDemoView.addCar();
				
			}else if(buttonValue.equals("Play"))
			{
				theDemoView.movingTest();
			}else if(buttonValue.equals("Stop"))
			{
				
				theDemoView.stop();
			}
			} catch (NumberFormatException ex) {
				
			}
			
		}
		
		
		
		
		
	}
	
	
	
}
