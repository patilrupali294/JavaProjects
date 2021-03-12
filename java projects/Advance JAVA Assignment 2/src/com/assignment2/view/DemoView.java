package com.assignment2.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;

import java.awt.event.ActionListener;

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

/**
 * The Demo view program implements an demo
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class DemoView extends JFrame implements Runnable {
	/**
	 * Instance variables of the class
	 * 
	 */
	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.gray, Color.green,
			Color.LIGHT_GRAY, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

	private static final String[] colorNames = { "Black", "Blue", "Cyan", "Gray", "Green", "Light Gray", "Magenta",
			"Orange", "Pink", "Red", "White", "Yellow" };

	// This variable is used to set the total timer value
	static int interval = 40;
	static Timer timer = new Timer();
	static Timer timer2 = new Timer();
	JButton btnStart, btnStop, btnPause, btnResume, about, saveFile;
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

	ImageIcon o = new ImageIcon(getClass().getResource("star.png"));
	Image scale = o.getImage();
	Image newImage = scale.getScaledInstance(70, 15, java.awt.Image.SCALE_SMOOTH);
	ImageIcon i2 = new ImageIcon(newImage);

	/**
	 * This is a panel to hold the buttons
	 */
	private JPanel controlPanel;
	private JPanel controlPanel1;
	private JPanel controlPanel2;
	private JLabel labelforImage;
	private JLabel timervalue;
	Date d1 = new Date();
	/**
	 * Date format in hour minutes and seconds
	 */
	DateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
	/**
	 * Date format in days months and year
	 */
	DateFormat dateformat1 = new SimpleDateFormat("dd-MM-yyyy");

	int count = 0;
	boolean flag = false;
	boolean running = false;
	private Vehicle vehicle;
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	private Vehicle vehicle3;
	private Vehicle vehicle4;
	private Vehicle vehicle5;
	CollisionImage imageToCollide = new CollisionImage();
	boolean flagforcollision = false;
	private TestTable tt;
	String ColorOne;
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
	int delay = 1000;
	int period = 1000;
	String secs = "300";
	boolean flaginterval = false;
	boolean flagmoveback = false;
	/**
	 * This is used to create the initial view for the demo
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
		btnResume = new JButton("Resume");
		btnResume.setVisible(true);

		saveFile = new JButton("Save Table into file ");
		saveFile.setVisible(true);

		setColorJList(new JList<String>(colorNames));
		controlPanel1.add(label1);

		// list of colors
		getColorJList().setVisibleRowCount(5);

		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		colorJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				controlPanel.setBackground(colors[colorJList.getSelectedIndex()]);
				controlPanel1.setBackground(colors[colorJList.getSelectedIndex()]);
			}
		}

				);

		// Showing the scrollable list of colors
		controlPanel1.add(colorJList);
		controlPanel1.add(new JScrollPane(getColorJList()));

	

		// These are the buttons
		controlPanel.add(Box.createHorizontalGlue());
		controlPanel.add(btnStart);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 5)));
		controlPanel.add(btnStop);
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
		vehicle1 = new Vehicle(150, 330, Color.BLACK, 2, 1);
		car.add(vehicle1);
		vehicle2 = new Vehicle(300, 330, Color.red, 1, 2);
		car.add(vehicle2);
		vehicle3 = new Vehicle(520, 330, Color.cyan, 4, 3);
		car.add(vehicle3);
		vehicle4 = new Vehicle(500, 530, Color.GREEN, 2, 4);
		car.add(vehicle4);
		vehicle5 = new Vehicle(700, 530, Color.BLUE, 1, 5);
		car.add(vehicle5);

		setSize(1500, 800);
		setResizable(false);
		setVisible(true);

	}

	public JList<String> getColorJList() {
		return colorJList;
	}

	public int getExspeed() {
		return exspeed;
	}

	public boolean isFlag() {
		return flag;
	}

	/**
	 * This method is used to move the cars, check if any cars collide If the
	 * delay between the click and the occurrence of an hazard is less than or
	 * equal to 3 seconds The user gets a score and three stars The table view
	 * is displayed
	 */
	public void move() {

		for (int i = 0; i < car.size(); i++) {

			Vehicle v = car.get(i);

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
				if (v.getSpeed() >= 5) {
					Vehicle v1 = car.get(0);
					Vehicle v2 = car.get(1);
					Vehicle v3 = car.get(2);
					Vehicle v4 = car.get(3);
					Vehicle v5 = car.get(4);
					if (v.getExspedd() == 1) {

						v.setColorForTheCar(Color.BLACK);
					} else if (v.getExspedd() == 2) {
						v.setColorForTheCar(Color.red);
					} else if (v.getExspedd() == 3) {
						v.setColorForTheCar(Color.cyan);

					} else if (v.getExspedd() == 4) {
						v.setColorForTheCar(Color.GREEN);

					} else if (v.getExspedd() == 5) {
						v.setColorForTheCar(Color.BLUE);

					}
					System.out.println(v.getColorForTheCar());

					v.setColorForTheCar(v.getColorForTheCar());
				}
				if (flagforcollision == true) {
					// System.out.println(v.getX());
					if (((v.getX() + 100)) >= imageCollision - 2) {

						Vehicle v1 = car.get(0);
						Vehicle v2 = car.get(1);
						Vehicle v3 = car.get(2);
						Vehicle v4 = car.get(3);
						Vehicle v5 = car.get(4);
						if (v.getExspedd() == 3) {
							v1.setX(v1.getX() - 20);
							v1.setSpeed(0);
							v2.setX(v2.getX() - 20);
							v2.setSpeed(0);
							v3.setX(v3.getX() - 30);
							v3.setSpeed(0);
						}

						if (v.getExspedd() == 5) {
							v4.setX(v4.getX() - 35);
							v4.setSpeed(0);
							v5.setX(v5.getX() - 40);
							v5.setSpeed(0);
						}

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
				Thread.sleep(30);
			} catch (Exception ex) {

			}
		}

	}

	/**
	 * This is used to move the object(Hazard) To a position when it hits a
	 * particular timer
	 */
	public void moveBackObject() {
		System.out.println("called");
		if (interval == 19) {
			imageToCollide.moveBack();
			flagforcollision = false;
			flagmoveback = false;
			System.out.println(flagforcollision);

		}

		if (interval == 5) {

			imageToCollide.moveBack();
			flagforcollision = false;
			flagmoveback = false;
		}

	}

	/**
	 * This is used to move the object(Hazard) back to its initial position To a
	 * position when it hits a particular timer
	 */
	public void moveObjectForCollision() {

		if (interval == 26) {
			imageToCollide.move();
			flagforcollision = true;
			flaginterval = true;
			flagmoveback = true;

		}
		if (interval == 10) {
			System.out.println("1:" + flagforcollision);
			imageToCollide.move();
			flagforcollision = true;
			flaginterval = true;
			flagmoveback = true;
			System.out.println(flagforcollision);

		}
	}

	/**
	 * This method is called when thread begins to run
	 */
	public void movingTest() {

		btnStart.setVisible(false);
		if (running == false) {

			t2.start();
			running = true;
			// This will display the countdown of time in the text field
			timer.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					timervalue.setText("TIMER:" + Integer.toString(setinterval()));

				}
			}, delay, period);

		}

	}

	/**
	 * This method is used to paint the object on the display
	 */
	public void paint(Graphics g) {

		super.paint(g);

		g.setColor(Color.GRAY);
		g.fillRect(0, 300, controlPanel2.getWidth() + 20, controlPanel2.getHeight() - 160);

		g.setColor(Color.WHITE);
		for (int i = 0; i < controlPanel2.getWidth() + 20; i += 20)

		{
			g.fillRect(i, controlPanel2.getHeight() - 100, 10, 4);
		}
		imageToCollide.paint(g);
		g.drawImage(myImage1, controlPanel2.getWidth() - 1400, controlPanel2.getHeight() - 400, null);
		for (int t = 0; t < car.size(); t++) {
			car.get(t).paint(g);
		}

	}

	/**
	 * This method is used to check if the cars collide with each other
	 * 
	 * @param x
	 *            particular cars x position plus its speed
	 * @param y
	 *            particular cars y position
	 * @param v1
	 *            The car which is to be checked if it collides with the other
	 * @return true if the cars don't collide else false
	 */
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

	/**
	 * This is called every time until the thread is stopped
	 */
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
			if (interval == 18) {
				flaginterval = false;
			}

		}

	}

	public void setColorJList(JList<String> colorJList) {
		this.colorJList = colorJList;
	}

	public void setExspeed(int exspeed) {
		this.exspeed = exspeed;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * This method checks if the timer touches 0 If it does it it displays the
	 * table view
	 * 
	 * @return interval
	 */
	private int setinterval() {

		if (interval == 0) {
			timer.cancel();
			running = false;
			tt = new TestTable();
			tt.values[0] = 2;
			tt.data[0][1] = 2;
			tt.data[0][3] = dateformat.format(d1);
			tt.data[0][2] = dateformat1.format(d1);
			tt.values[1] = 10;
			tt.data[1][1] = 10;
			tt.data[1][3] = dateformat.format(d1);
			tt.data[1][2] = dateformat1.format(d1);
			tt.values[2] = 6;
			tt.data[2][1] = 6;
			tt.data[2][3] = dateformat.format(d1);
			tt.data[2][2] = dateformat1.format(d1);
			tt.data[2][4] = "Car:" + "\t" + 3 + "must be stopped";
			tt.data[2][5] = dateformat.format(d1);
			tt.data[2][7] = dateformat1.format(d1);
			tt.data[2][7] = i2;
			tt.values[3] = 5;
			tt.data[3][1] = 5;
			tt.data[3][3] = dateformat.format(d1);
			tt.data[3][2] = dateformat1.format(d1);
			tt.values[4] = 3;
			tt.data[4][1] = 3;
			tt.data[4][3] = dateformat.format(d1);
			tt.data[4][2] = dateformat1.format(d1);
			tt.createGUI();
			JOptionPane.showMessageDialog(null, "Timer has stopped" + "\n" + "The next view is of dummy data", "Timer",
					JOptionPane.INFORMATION_MESSAGE);

		}
		return interval--;

	}

	/**
	 * Action listener for the button START
	 * 
	 * @param listenForStart
	 */
	public void startCarListener(ActionListener listenForStart) {
		btnStart.addActionListener(listenForStart);
	}

	/**
	 * This method is used to stop the thread from running
	 */
	public void stop() {

		running = false;

	}

	/**
	 * Action listener for STOP
	 * 
	 * @param listenForStop
	 */
	public void stopCarListener(ActionListener listenForStop) {
		btnStop.addActionListener(listenForStop);
	}

}
