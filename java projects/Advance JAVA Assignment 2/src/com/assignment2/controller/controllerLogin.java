package com.assignment2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.assignment2.view.LoginView;

/**
 * 
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class controllerLogin {
	/**
	 * Instance variables of the class
	 * 
	 */
	private LoginView login;

	/**
	 * Constructor
	 * 
	 * @param login instance of the class LoginView
	 */
	public controllerLogin(LoginView login) {
		this.login = login;
		this.login.loginButtonListner(new listner());
	}

	class listner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object buttonValue = e.getActionCommand();
			System.out.println("Enterd");
			System.out.println(buttonValue);
			try {
				if (buttonValue.equals("Login")) {
					login.loginDetails();
				}

			} catch (Exception e1) {

			}

		}

	}
}
