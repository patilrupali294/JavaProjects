package com.assignment2.main;

import com.assignment2.controller.controllerLogin;
import com.assignment2.view.LoginView;

public class Mian {

	public static void main(String[] args) {
		LoginView view1 = new LoginView();
		controllerLogin login = new controllerLogin(view1);

	}

}
