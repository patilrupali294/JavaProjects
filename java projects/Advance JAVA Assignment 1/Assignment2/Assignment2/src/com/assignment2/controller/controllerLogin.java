package com.assignment2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.assignment2.view.LoginView;

public class controllerLogin {

	private LoginView login;

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
