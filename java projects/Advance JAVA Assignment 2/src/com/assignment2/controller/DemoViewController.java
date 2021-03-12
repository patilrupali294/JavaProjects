package com.assignment2.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.assignment2.Model.Vehicle;
import com.assignment2.view.DemoView;

/**
 * 
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class DemoViewController {
	/**
	 * Instance variables of the class
	 * 
	 */
	private DemoView theDemoView;

	/**
	 * Constructor
	 * 
	 * @param theDemoView instance of the class DemoView
	 */
	public DemoViewController(DemoView theDemoView) {
		this.theDemoView = theDemoView;
		this.theDemoView.startCarListener(new listner());
		this.theDemoView.stopCarListener(new listner());

	}

	class listner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object buttonValue = e.getActionCommand();
			System.out.println("Enterd");
			System.out.println(buttonValue);
			try {
				if (buttonValue.equals("Play")) {
					theDemoView.movingTest();
				} else if (buttonValue.equals("Stop")) {

					theDemoView.stop();
				}
			} catch (NumberFormatException ex) {

			}

		}

	}

}
