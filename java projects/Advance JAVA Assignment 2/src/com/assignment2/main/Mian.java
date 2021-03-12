package com.assignment2.main;

import com.assignment2.controller.controllerLogin;
import com.assignment2.view.LoginView;

/**
 * 
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class Mian {
	/**
	 * This is the main method for the application
	 * 
	 * @param args
	 *            array of type Strings
	 */

	public static void main(String[] args) {
		LoginView view1 = new LoginView();
		controllerLogin login = new controllerLogin(view1);

	}

}
