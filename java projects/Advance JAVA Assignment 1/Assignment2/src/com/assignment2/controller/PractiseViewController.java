package com.assignment2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.assignment2.controller.DemoViewController.listner;
import com.assignment2.view.PractiseTestView;

public class PractiseViewController {
	private PractiseTestView practisetestview;
	
	public PractiseViewController(PractiseTestView practisetestview)
	{
		this.practisetestview=practisetestview;
		this.practisetestview.startCarListener(new listner());
		this.practisetestview.stopCarListener(new listner());
		
		
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
			//	theDemoView.addCar();
				
			}else if(buttonValue.equals("Start"))
			{
				System.out.println("pracrise");
				practisetestview.movingTest();
			}else if(buttonValue.equals("Stop"))
			{
				
				practisetestview.stop();
			}
			} catch (NumberFormatException ex) {
				
			}
			
		}
}
}
