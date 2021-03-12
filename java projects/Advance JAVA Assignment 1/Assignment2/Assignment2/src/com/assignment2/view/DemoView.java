package com.assignment2.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.assignment2.Model.CollisionImage;
import com.assignment2.Model.Vehicle;

public class DemoView extends JFrame implements Runnable {

	JButton btnStart, btnStop, btnPause, btnResume, about, saveFile, addCar;
	JTextField txtSpeed;
	Label lblSpeed;
	JTable table;
	TextField count1 = new TextField(20);
	TextField timer1 = new TextField(3);
	int x_pos; // x - Position of cars
	int y_pos; // y - Position of cars
	Color BallColor;
	int height, width;
	ImageObserver observer;
	JLabel label1;
	String car1 = "";

	public int getExspeed() {
		return exspeed;
	}

	public void setExspeed(int exspeed) {
		this.exspeed = exspeed;
	}

	int exspeed = 0;
	private JList<String> colorJList;
	Image img;
	/**
	 * An instance of type Image
	 */
	Image myImage;
	/**
	 * An instance of type Image
	 */
	Image myImage1;
	/**
	 * This is a panel to hold the buttons
	 */
	private JPanel controlPanel;
	private JPanel controlPanel1;
	private JPanel controlPanel2;
	private JLabel labelforImage;
	private JLabel timervalue;

	int count = 0;
	boolean flag = false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	boolean running = false;
	private Vehicle vehicle;
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	private Vehicle vehicle3;
	private Vehicle vehicle4;
	private Vehicle vehicle5;
	CollisionImage imageToCollide = new CollisionImage();
	boolean flagforcollision = false;
	String ColorOne;

	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.gray, Color.green,
			Color.LIGHT_GRAY, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

	private static final String[] colorNames = { "Black", "Blue", "Cyan", "Gray", "Green", "Light Gray", "Magenta",
			"Orange", "Pink", "Red", "White", "Yellow" };

	ArrayList<Vehicle> car = new ArrayList<Vehicle>();
	Thread t2 = new Thread(this);

	Date d = new Date();

	/**
	 * Date format in hour minutes and seconds
	 */
	DateFormat df = new SimpleDateFormat("hh:mm:ss");
	/**
	 * Date format in days months and year
	 */
	DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
	long Time1 = d.getTime();
	long Time2 = d.getTime() + (1 * 100);
	long Time3 = d.getTime() + (1 * 200);

	static int interval = 30;
	int delay = 1000;
	int period = 1000;

	// static Timer intial = new Timer();
	static Timer timer = new Timer();
	static Timer timer2 = new Timer();
	String secs = "300";
	boolean flaginterval = false;
	boolean flagmoveback = false;

	/*
	 * Timer t = new Timer(500, new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * t1=new Thread(vehicle1); t1.start();
	 * 
	 * 
	 * // System.out.println(t1.isAlive()); if (car.size() == 0) {
	 * 
	 * JOptionPane.showMessageDialog(null, "CARS ARE NOT ADDED", "SELECTION",
	 * JOptionPane.ERROR_MESSAGE); t.stop(); } if (vehicle1 != null) {
	 * vehicle1.move(6); } if (vehicle2 != null) { vehicle2.move(2); } if
	 * (vehicle3 != null) { vehicle3.move(8); } if (vehicle4!= null) {
	 * vehicle4.move(-6); } if (vehicle5 != null) { vehicle5.move(-2); } if
	 * (flag == true) {
	 * 
	 * System.out.println("hello"); System.out.println(t1.getState());
	 * 
	 * } test(); repaint(); } });
	 */

	public void CreateGUIDemoView() {
		controlPanel = new JPanel();
		controlPanel1 = new JPanel();
		controlPanel2 = new JPanel();

		// for text box and color list
		controlPanel1.add(Box.createRigidArea(new Dimension(0, 0)));
		controlPanel1.setLayout(new BoxLayout(controlPanel1, BoxLayout.Y_AXIS));

		// for the image with cars
		controlPanel2.add(Box.createRigidArea(new Dimension(50, 10)));
		controlPanel2.setLayout(new BoxLayout(controlPanel2, BoxLayout.Y_AXIS));

		// for buttons
		controlPanel.add(Box.createRigidArea(new Dimension(0, 60)));
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));

		Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
		Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
		label1 = new JLabel("Choose background colour: ");
		label1.setToolTipText("This is for background color");
		labelforImage = new JLabel();
		labelforImage.setIcon(bug2);
		timervalue = new JLabel();

		colorJList = new JList<String>(colorNames);

		btnStart = new JButton("Play");
		about = new JButton("About");
		about.setVisible(true);
		btnStart.setVisible(true);
		btnStop = new JButton("Stop");
		btnStop.setVisible(true);
		// btnPause = new JButton("Car 1", bug1);
		// btnPause.setVisible(true);
		// btnPause.setRolloverIcon(bug2); // set rollover image
		btnResume = new JButton("Resume");
		btnResume.setVisible(true);

		saveFile = new JButton("Save Table into file ");
		saveFile.setVisible(true);
		addCar = new JButton("Add Car");
		setColorJList(new JList<String>(colorNames));
		// setLayout(new FlowLayout());

		// label 1 is for choose color
		controlPanel1.add(label1);

		// list of colors
		getColorJList().setVisibleRowCount(5);

		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		colorJList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				controlPanel.setBackground(colors[colorJList.getSelectedIndex()]);
				controlPanel1.setBackground(colors[colorJList.getSelectedIndex()]);
			}
		}

				);

		// Showing the scrollable list of colors
		controlPanel1.add(colorJList);
		controlPanel1.add(new JScrollPane(getColorJList()));

		// Enter the spped
		// controlPanel1.add(lblSpeed);
		// controlPanel1.add(txtSpeed);

		// These are the buttons
		controlPanel.add(Box.createHorizontalGlue());
		controlPanel.add(btnStart);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(addCar);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 5)));
		controlPanel.add(btnStop);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(btnResume);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(timervalue);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		//
		try {
			myImage = ImageIO.read(new File("scl.jpg"));
			myImage = myImage.getScaledInstance(900, 200, 60);
			myImage1 = ImageIO.read(new File("school-zone-sign.jpg"));
			myImage1 = myImage1.getScaledInstance(80, 100, 60);
		} catch (IOException e) {

			e.printStackTrace();
		}

		Border blackline = BorderFactory.createStrokeBorder(new BasicStroke(4.0f));
		controlPanel2.setBorder(blackline);

		add(controlPanel1, BorderLayout.NORTH);
		add(controlPanel2, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.PAGE_END);

		setSize(1500, 800);
		setVisible(true);

	}

	public JList<String> getColorJList() {
		return colorJList;
	}

	public void setColorJList(JList<String> colorJList) {
		this.colorJList = colorJList;
	}

	public void paint(Graphics g) {

		super.paint(g);

		g.setColor(Color.darkGray);
		g.fillRect(0, 300, controlPanel2.getWidth() + 20, controlPanel2.getHeight() - 160);

		g.setColor(Color.WHITE);
		for (int i = 0; i < controlPanel2.getWidth() + 20; i += 20)

		{
			g.fillRect(i, controlPanel2.getHeight() - 80, 10, 4);
		}
		imageToCollide.paint(g);
		g.drawImage(myImage1, controlPanel2.getWidth() - 1400, controlPanel2.getHeight() - 400, null);
		for (int t = 0; t < car.size(); t++) {
			car.get(t).paint(g);
		}

	}

	private int setinterval() {

		if (interval == 0) {
			timer.cancel();
			running = false;
			JOptionPane.showMessageDialog(null, "Timer has stopped", "Timer", JOptionPane.INFORMATION_MESSAGE);

		}
		return interval--;

	}

	public void movingTest() {

		btnStart.setVisible(false);
		if (running == false) {

			t2.start();
			running = true;

			// This will display the countdown of time in the text field
			timer.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					timervalue.setText("TIMER:"+Integer.toString(setinterval()));

				}
			}, delay, period);

		}

	}

	public void move() {

		for (int i = 0; i < car.size(); i++) {

			Vehicle v = car.get(i);
			// System.out.println("collide:"+collide(v.getX()+v.getSpeed(),v.getY(),
			// v));
			if (collide(v.getX() + v.getSpeed(), v.getY(), v) == false) {
				int variable = v.getSpeed();
				int imageCollision = imageToCollide.getX();
				v.setX(v.getX() + v.getSpeed());
				variable++;
				v.setSpeed(variable);

				if (v.getSpeed() >= 40) {
					v.setColorForTheCar(Color.PINK);
					v.setSpeed(0);

				}
				if (v.getSpeed() >= 2) {

					v.setColorForTheCar(v.getColorForTheCar());
				}
				if (flagforcollision == true) {
					// System.out.println(v.getX());
					if ((v.getX()) <= imageCollision && (v.getX()) + 104 > imageCollision) {
						v.setX(v.getX() - 50);
						v.setSpeed(0);
						// running = false;

					}
				}
				if (((v.getX() + 100) > 1500)) {
					v.setX(150);
				} else if (((v.getX() < 10))) {
					v.setX(1200);
				}
				repaint();
			} else {
				try {
					JOptionPane.showMessageDialog(null, "Click on the car which has to be put in control", "COLLISION",
							JOptionPane.INFORMATION_MESSAGE);

					Thread.sleep(3000);
					v.setSpeed(0);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(60);
			} catch (Exception ex) {

			}
		}

	}

	public boolean collide(int x, int y, Vehicle v1) {
		for (int a = 0; a < car.size(); a++) {
			Vehicle actual = car.get(a);

			if (y == actual.getY()) {
				// same lane
				if (actual.equals(v1) == false) {

					if (x <= actual.getX() && x + 104 > actual.getX()) {

						return true;
					}

				}

			}

		}
		return false;
	}

	// moving the object based on a timer

	public void moveObjectForCollision() {

		if (interval == 20) {
			imageToCollide.move();
			flagforcollision = true;
			flaginterval = true;
			flagmoveback = true;

		}
	}

	public void moveBackObject() {
		if (interval == 10) {

			imageToCollide.moveBack();
			flagforcollision = false;
			flagmoveback = false;
		}
	}

	public void addCar() {

		System.out.println("add car");
		count++;
		JOptionPane.showMessageDialog(null, "Number of cars selected:" + count, "Total Cars",
				JOptionPane.INFORMATION_MESSAGE);

		switch (count) {

		case 1:
			vehicle1 = new Vehicle(150, 330, Color.BLACK, 2, 1);
			car.add(vehicle1);

			repaint();
			break;
		case 2:
			vehicle2 = new Vehicle(300, 330, Color.red, 1, 2);
			car.add(vehicle2);
			repaint();
			break;

		case 3:
			vehicle3 = new Vehicle(520, 330, Color.cyan, 4, 3);
			car.add(vehicle3);
			repaint();
			break;

		case 4:
			vehicle4 = new Vehicle(500, 530, Color.GREEN, -6, 4);
			car.add(vehicle4);
			repaint();
			break;

		case 5:
			vehicle5 = new Vehicle(700, 530, Color.GRAY, -2, 5);
			car.add(vehicle5);
			repaint();
			break;

		}

	}

	/**
	 * This is the listner class for add car
	 * 
	 * @param listenForbutton
	 *            To set the background
	 */
	public void addCarListener(ActionListener listenForbutton) {
		addCar.addActionListener(listenForbutton);
	}

	public void startCarListener(ActionListener listenForStart) {
		btnStart.addActionListener(listenForStart);
	}

	public void stop() {

		running = false;

	}

	public void stopCarListener(ActionListener listenForStop) {
		btnStop.addActionListener(listenForStop);
	}

	@Override
	public void run() {

		while (running == true) {

			move();
			Time1++;
			if (flaginterval == false) {
				moveObjectForCollision();
			}
			if (flagmoveback == true) {
				moveBackObject();
			}

		}

	}

}
