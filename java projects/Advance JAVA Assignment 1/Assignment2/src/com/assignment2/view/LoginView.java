package com.assignment2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.assignment2.controller.FirstViewController;
import com.assignment2.controller.controllerLogin;

public class LoginView extends JFrame {

	private controllerLogin controlLogin;
	

	private JLabel label1;
	private JLabel label2;
	private JTextField userName;
	private JPasswordField password;
	private JPanel mainPanel;
	private JPanel panel;
	private JPanel panel2;
	private JButton button;
	private JPanel mainPanel1;

	String user[] = { "bopi", "Ajith", "Smaran" };
	String pass[] = { "111", "ddd", "kkk" };

	public LoginView() {
		createGUI();
	}

	public void createGUI() {

		mainPanel = new JPanel(new BorderLayout());
		mainPanel1 = new JPanel();
		panel = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel("User Name");
		label2 = new JLabel("Password");
		userName = new JTextField(10);
		password = new JPasswordField(10);
		button = new JButton("Login");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
				System.exit(0);
			}
		});

		panel.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		// panel.setLayout(new GridLayout(3,1));
		// panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		panel.add(label1, BorderLayout.LINE_START);
		panel.add(userName, BorderLayout.LINE_END);

		panel2.add(label2, BorderLayout.LINE_START);
		panel2.add(password, BorderLayout.LINE_END);

		mainPanel.add(panel, BorderLayout.PAGE_START);
		mainPanel.add(panel2, BorderLayout.CENTER);

		// mainPanel.add(Box.createHorizontalGlue());
		// mainPanel.add(button,BorderLayout.PAGE_END);
		mainPanel1.add(Box.createRigidArea(new Dimension(10, 0)));
		mainPanel1.add(button);
		// mainPanel.add(button,BorderLayout.PAGE_END);
		add(mainPanel, BorderLayout.NORTH);
		add(mainPanel1, BorderLayout.PAGE_END);
		setSize(500, 500);
		setVisible(true);
	}

	public void loginDetails() {
		System.out.println(userName.getText());
		System.out.println(password.getText());
		String user1 = userName.getText().trim();
		String password1 = password.getText().trim();
		for (int i = 0; i < user.length; i++) {
			if ((user1.equals(user[i])) && (password1.equals(pass[i])) && (user1 != null) && (password1 != null)) {

				check(1);
				break;

			} else {
				check(0);
				break;
			}
		}

	}

	public void check(int flag) {
		if (flag == 1) {
			JOptionPane.showMessageDialog(null, "LOGIN SUCCESS", "ABOUT ME", JOptionPane.INFORMATION_MESSAGE);

			// Call demo page
			FirstView firstView=new FirstView();
			FirstViewController firstController=new FirstViewController(firstView);

		} else {
			JOptionPane.showMessageDialog(null, "LOGIN FAILED", "ABOUT ME", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void loginButtonListner(ActionListener listnerForLogin) {
		button.addActionListener(listnerForLogin);
	}

}
