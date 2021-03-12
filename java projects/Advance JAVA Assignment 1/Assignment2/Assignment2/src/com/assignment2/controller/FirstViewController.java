package com.assignment2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.assignment2.view.FirstView;

public class FirstViewController {

	/**
	 * Instance of class FirstView
	 */
	private FirstView theView;

	/**
	 * @param theView
	 *            instance of spingView
	 */
	public FirstViewController(FirstView theView) {
		this.theView = theView;

		this.theView.bckgroundListener(new listner());
		this.theView.yesListner(new listner());
		this.theView.noListner(new listner());
		this.theView.aboutListner(new listner());
		this.theView.demoListner(new listner());

	}

	/**
	 * This is an inner class which implements ActionListner and defines the
	 * method action Performed
	 * 
	 * @author K.S.Boppaiah
	 *
	 */
	class listner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object buttonValue = e.getActionCommand();
			System.out.println("Enterd");
			System.out.println(buttonValue);
			try {

				if (buttonValue.equals("SET BACK-GROUND COLOUR")) {
					theView.setBckground();
				} else if (buttonValue.equals("YES")) {

					theView.startTheModule();

				} else if (buttonValue.equals("NO")) {
					System.exit(0);
				}else if(buttonValue.equals("About")){
					theView.aboutDialog();
				}else if(buttonValue.equals("DEMO"))
				{
					theView.demoFunction();
				}

			} catch (NumberFormatException ex) {
				System.out.println(ex);
				theView.displayErrorMessage("Somethin went wrong!");
			}

		}
	}

}
