package com.assignment2.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class PractiseTestView extends JFrame implements Runnable, ActionListener {

	JButton btnStart, btnStop, speedforcar1, speedforcar2, speedforcar3, speedforcar4, speedforcar5;

	Color BallColor;
	int height, width;
	ImageObserver observer;
	JLabel label1;
	String car1 = "";
	TestTable tt = new TestTable();

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
	private JLabel scoreforpractise;

	int count = 0;
	int countCrash=0;
	int count1 = 0;
	int countCrash1=0;
	int count2 = 0;
	int countCrash2=0;
	int count3 = 0;
	int countCrash3=0;
	int count4 = 0;
	int countCrash4=0;
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
	boolean checkflag = false;
	boolean falg2 = false;
	private JLabel timervalue;

	public boolean isFalg2() {
		return falg2;
	}

	public void setFalg2(boolean falg2) {
		this.falg2 = falg2;
	}

	public boolean isCheckflag() {
		return checkflag;
	}

	public void setCheckflag(boolean checkflag) {
		this.checkflag = checkflag;
	}

	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.gray, Color.green,
			Color.LIGHT_GRAY, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

	private static final String[] colorNames = { "Black", "Blue", "Cyan", "Gray", "Green", "Light Gray", "Magenta",
			"Orange", "Pink", "Red", "White", "Yellow" };

	ArrayList<Vehicle> car = new ArrayList<Vehicle>();

	Date d = new Date();

	/**
	 * Date format in hour minutes and seconds
	 */
	DateFormat df = new SimpleDateFormat("hh:mm:ss");

	long Time1 = d.getTime();
	long Time2 = d.getTime() + (1 * 100);

	static int interval = 20;
	int delay = 1000;
	int period = 1000;

	// static Timer intial = new Timer();
	static Timer timer = new Timer();
	static Timer timer2 = new Timer();
	String secs = "300";
	boolean flaginterval = false;
	boolean flagmoveback = false;

	static Timer intial = new Timer();
	OptionPane op1 = new OptionPane();
	int carspeed1;
	int carspeed2;
	int carspeed3;
	int carspeed4;
	int carspeed5;
	int totalNumberofcars;
	Color carColor;
	int threadsleepvariable;
	int variable;
	int score = 0;
	Icon bug1;
	Icon bug2;
	Thread t2 = new Thread(this);
	Date date = new Date();

	/**
	 * Date format in hour minutes and seconds
	 */
	DateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
	/**
	 * Date format in days months and year
	 */
	DateFormat dateformat1 = new SimpleDateFormat("dd-MM-yyyy");

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getVariable() {
		return variable;
	}

	public void setVariable(int variable) {
		this.variable = variable;
	}

	public void CreateGUIDemoView() {
		controlPanel = new JPanel();
		controlPanel1 = new JPanel();
		controlPanel2 = new JPanel();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
				System.exit(0);
			}
		});
		
		
		// for text box and color list
		controlPanel1.add(Box.createRigidArea(new Dimension(0, 0)));
		controlPanel1.setLayout(new BoxLayout(controlPanel1, BoxLayout.Y_AXIS));

		// for the image with cars
		controlPanel2.add(Box.createRigidArea(new Dimension(50, 10)));
		controlPanel2.setLayout(new BoxLayout(controlPanel2, BoxLayout.Y_AXIS));

		// for buttons
		controlPanel.add(Box.createRigidArea(new Dimension(0, 60)));
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));

	bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
		 bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
		label1 = new JLabel("Choose background colour: ");
		label1.setToolTipText("This is for background color");
		labelforImage = new JLabel();
		labelforImage.setIcon(bug1);
		timervalue = new JLabel();

		colorJList = new JList<String>(colorNames);

		btnStart = new JButton("Start");
		btnStart.setVisible(true);
		btnStop = new JButton("Stop");
		btnStop.setVisible(true);
		speedforcar1 = new JButton("CAR 1");
		speedforcar1.setVisible(false);
		speedforcar2 = new JButton("CAR 2");
		speedforcar2.setVisible(false);
		speedforcar3 = new JButton("CAR 3");
		speedforcar3.setVisible(false);
		speedforcar4 = new JButton("CAR 4");
		speedforcar4.setVisible(false);
		speedforcar5 = new JButton("CAR 5");
		speedforcar5.setVisible(false);

		scoreforpractise = new JLabel();

		setColorJList(new JList<String>(colorNames));

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

		controlPanel.add(Box.createHorizontalGlue());
		controlPanel.add(btnStart);
		controlPanel.add(Box.createRigidArea(new Dimension(0, 0)));
		controlPanel.add(scoreforpractise);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(speedforcar1);

		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(speedforcar2);

		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(speedforcar3);

		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(speedforcar4);

		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		controlPanel.add(speedforcar5);

		controlPanel.add(Box.createRigidArea(new Dimension(10, 5)));
		controlPanel.add(btnStop);

		controlPanel.add(timervalue);
		controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		controlPanel.add(labelforImage);
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

		speedforcar1.addActionListener(this);
		speedforcar2.addActionListener(this);
		speedforcar3.addActionListener(this);
		speedforcar4.addActionListener(this);
		speedforcar5.addActionListener(this);

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
		// TODO Auto-generated method stub
		super.paint(g);
		// g.drawImage(myImage1, controlPanel2.getX()+20,
		// controlPanel2.getY()+40,controlPanel2);

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
			tt.createGUI();

		}
		return interval--;

	}


	public void movingTest() {

		btnStart.setVisible(false);
		addCar(totalNumberofcars, carColor, carspeed1, carspeed2, carspeed3, carspeed4, carspeed5);
		if (totalNumberofcars == 1) {
			speedforcar1.setVisible(true);
			threadsleepvariable = 100;
		} else if (totalNumberofcars == 2) {
			speedforcar1.setVisible(true);
			speedforcar2.setVisible(true);
			threadsleepvariable = 60;
		} else if (totalNumberofcars == 3) {
			speedforcar1.setVisible(true);
			speedforcar2.setVisible(true);
			speedforcar3.setVisible(true);
			threadsleepvariable = 30;

		} else if (totalNumberofcars == 4) {
			speedforcar1.setVisible(true);
			speedforcar2.setVisible(true);
			speedforcar3.setVisible(true);
			speedforcar4.setVisible(true);
			threadsleepvariable = 60;

		} else if (totalNumberofcars == 5) {
			speedforcar1.setVisible(true);
			speedforcar2.setVisible(true);
			speedforcar3.setVisible(true);
			speedforcar4.setVisible(true);
			speedforcar5.setVisible(true);
			threadsleepvariable = 60;
		}
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

			if (collide(v.getX() + v.getSpeed(), v.getY(), v) == false) {
				variable = v.getSpeed();

				v.setX(v.getX() + variable);
				variable++;
				setVariable(variable);
				// System.out.println(getVariable());
				v.setSpeed(variable);

				if (getVariable() >= 40) {
					v.setColorForTheCar(Color.PINK);
					v.setSpeed(0);
					System.out.println(v.getSpeed());

				}
				if (v.getSpeed() >= 5) {

					v.setColorForTheCar(carColor);
				}
				if (flagforcollision == true) {

					try {
						int imageCollision = imageToCollide.getX();
						System.out.println(imageCollision);

						if (((v.getX() + 100)) >= imageCollision - 10) {

							// system generated time and date when collision
							// occurred
							Date dateForTrack = new Date();
							System.out.println(dateformat1.format(d));
							System.out.println(dateformat.format(dateForTrack.getTime()));
							System.out.println("car number:"+v.getExspedd());

							setFlag(true);
							threadsleepvariable = 60;

							if (totalNumberofcars == 1) {
								tt.data[0][4] = "Car"+v.getExspedd()+"must be stopped";
								tt.data[0][5] = dateformat1.format(d);
								tt.data[0][6] = dateformat.format(dateForTrack.getTime());
								

							} else if (totalNumberofcars == 2) {
								tt.data[1][4]="Car"+v.getExspedd()+"must be stopped";
								tt.data[1][5] = dateformat1.format(d);
								tt.data[1][6] = dateformat.format(dateForTrack.getTime());
							} else if (totalNumberofcars == 3) {
								tt.data[2][4]="Car"+v.getExspedd()+"must be stopped";
								tt.data[2][5] = dateformat1.format(d);
								tt.data[2][6] = dateformat.format(dateForTrack.getTime());
							} else if (totalNumberofcars == 4) {
								tt.data[3][4]="Car"+v.getExspedd()+"must be stopped";
								tt.data[3][5] = dateformat1.format(d);
								tt.data[3][6] = dateformat.format(dateForTrack.getTime());
							} else if (totalNumberofcars == 5) {
								tt.data[4][4]="Car"+v.getExspedd()+"must be stopped";
								tt.data[4][5] = dateformat1.format(d);
								tt.data[4][6] = dateformat.format(dateForTrack.getTime());
							}
							labelforImage.setIcon(bug2);
							Thread.sleep(3000);
							labelforImage.setIcon(bug1);
							setFlag(false);
							setFalg2(true);
							/* JOptionPane.showMessageDialog(null, "TESTFAILED", "TEST RESULT",
							 JOptionPane.INFORMATION_MESSAGE);
							 running = false;

							 tt.createGUI();
*/							/*if ((v.getX() + 100) >= imageCollision + 10) {
								JOptionPane.showMessageDialog(null, "TEST FAILED", "TEST RESULT",
										JOptionPane.INFORMATION_MESSAGE);
								timer.cancel();
								tt.createGUI();
								running = false;

								//tt.createGUI();
							}*/

						}
					} catch (Exception ex) {

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

					// v.setSpeed(0);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(threadsleepvariable);
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
	
		if (interval == 15) {
			imageToCollide.move();
			flagforcollision = true;
			flaginterval = true;
			flagmoveback = true;

		}

	}

	public void moveBackObject() {
		if (interval == 5) {

			imageToCollide.moveBack();
			flagforcollision = false;
			flagmoveback = false;
		}
	}

	public void addCar(int number, Color c, int c1speed, int c2speed, int c3speed, int c4speed, int c5speed) {

		System.out.println("add car");
		// count++;

		switch (number) {

		case 1:
			vehicle1 = new Vehicle(150, 330, c, c1speed, 1);
			car.add(vehicle1);

			// System.out.println(t1.isAlive());
			// t.start();
			// repaint();
			break;
		case 2:
			vehicle1 = new Vehicle(150, 330, c, c1speed, 1);
			car.add(vehicle1);
			vehicle2 = new Vehicle(300, 330, c, c2speed, 2);
			car.add(vehicle2);
			// repaint();
			break;

		case 3:
			vehicle1 = new Vehicle(150, 330, c, c1speed, 1);
			car.add(vehicle1);
			vehicle2 = new Vehicle(300, 330, c, c2speed, 2);
			car.add(vehicle2);
			vehicle3 = new Vehicle(520, 330, c, c3speed, 3);
			car.add(vehicle3);
			 repaint();
			break;

		case 4:
			vehicle1 = new Vehicle(150, 330, c, c1speed, 1);
			car.add(vehicle1);
			vehicle2 = new Vehicle(300, 330, c, c2speed, 2);
			car.add(vehicle2);
			vehicle3 = new Vehicle(520, 330, c, c3speed, 3);
			car.add(vehicle3);
			vehicle4 = new Vehicle(500, 530, c, c4speed, 4);
			car.add(vehicle4);
			// repaint();
			break;

		case 5:
			vehicle1 = new Vehicle(150, 330, c, c1speed, 1);
			car.add(vehicle1);
			vehicle2 = new Vehicle(300, 330, c, c2speed, 2);
			car.add(vehicle2);
			vehicle3 = new Vehicle(520, 330, c, c3speed, 3);
			car.add(vehicle3);
			vehicle4 = new Vehicle(500, 530, c, c4speed, 4);
			car.add(vehicle4);
			vehicle5 = new Vehicle(700, 530, c, c5speed, 5);
			car.add(vehicle5);
			// repaint();
			break;

		}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object buttonValue = e.getActionCommand();

		// System.out.println("called");
		for (int j = 0; j < car.size(); j++) {

			try {
				if (buttonValue.equals("CAR 1")) {
					Vehicle b = car.get(0);
					System.out.println(isFlag());
					if (isFlag() == false) {
						Date ClickForCar1 = new Date();
						String date = dateformat1.format(d);
						b.setX(b.getX());
						b.setSpeed(0);
						if(j==0)
						{
						count++;
						tt.data[0][1] = count;
						tt.data[0][2] = date;
						tt.data[0][3] = dateformat.format(ClickForCar1.getTime());
						}
					} else if (isFlag() == true) {

						b.setX(200);
						b.setSpeed(0);

						if (j == 0) {
							count++;
							Date ClickForCar1 = new Date();
							String date = dateformat1.format(d);
							System.out.println("Click time" + dateformat.format(ClickForCar1.getTime()));
							tt.data[0][1] = count;
							tt.data[0][2] = date;
							tt.data[0][3] = dateformat.format(ClickForCar1.getTime());
							int f = getScore();
							f++;
							setScore(f);
							System.out.println(getScore());
							// setScore(getScore()+1);

							scoreforpractise.setText("SCORE IS:" + "\t" + (getScore()));
						}
					}

				} else if (buttonValue.equals("CAR 2")) {
					Vehicle b = car.get(0);
					Vehicle b1 = car.get(1);
					if (isFlag() == false) {
						b.setX(b.getX());
						b.setSpeed(0);
						b1.setX(b1.getX());
						b1.setSpeed(0);
						Date ClickForCar1 = new Date();
						String date = dateformat1.format(d);
						if (j == 1) {
							count1++;
							tt.data[1][1] = count1;
							tt.data[1][2] = date;
							tt.data[1][3] = dateformat.format(ClickForCar1.getTime());
						}
					} else if (isFlag() == true) {
						// count1++;
						b.setX(b.getX() - 150);
						b.setSpeed(0);
						b1.setX(b1.getX() - 100);
						b1.setSpeed(0);
						// setScore(0)
						if (j == 1) {
							count1++;
							Date ClickForCar1 = new Date();
							String date = dateformat1.format(d);
							System.out.println("Click time" + dateformat.format(ClickForCar1.getTime()));
							tt.data[1][1] = count1;
							tt.data[1][2] = date;
							tt.data[1][3] = dateformat.format(ClickForCar1.getTime());

							int f = getScore();
							f++;
							setScore(f);
							System.out.println(getScore());
							// setScore(getScore()+1);

							scoreforpractise.setText("SCORE IS:" + "\t" + (getScore()));
						}
					}

				} else if (buttonValue.equals("CAR 3")) {
					Vehicle b = car.get(0);
					Vehicle b1 = car.get(1);
					Vehicle b2 = car.get(2);
					if (isFlag() == false) {
						b.setX(b.getX());
						b.setSpeed(0);
						b1.setX(b1.getX());
						b1.setSpeed(0);
						b2.setX(b2.getX());
						b2.setSpeed(0);
						Date ClickForCar1 = new Date();
						String date = dateformat1.format(d);
						
						
						if (j == 2) {
							count2++;
							
							tt.data[2][1] = count2;
							tt.data[2][2] = date;
							tt.data[2][3] = dateformat.format(ClickForCar1.getTime());
							
							
							
							
						}
					} else if (isFlag() == true) {

						b.setX(b.getX() - 110);
						b.setSpeed(0);
						b1.setX(b1.getX() - 100);
						b1.setSpeed(0);
						b2.setX(b2.getX() - 90);
						b2.setSpeed(0);
						if (j == 2) {
							count2++;
							Date ClickForCar1 = new Date();
							String date = dateformat1.format(d);
							System.out.println("Click time" + dateformat.format(ClickForCar1.getTime()));
							tt.data[2][1] = count2;
							tt.data[2][2] = date;
							tt.data[2][3] = dateformat.format(ClickForCar1.getTime());
							
							
							
							
							int f = getScore();
							f++;
							setScore(f);
							System.out.println(getScore());
							// setScore(getScore()+1);

							scoreforpractise.setText("SCORE IS:" + "\t" + (getScore()));
						}
					}
				} else if (buttonValue.equals("CAR 4")) {

					Vehicle b3 = car.get(3);
					if (isFlag() == false) {
						b3.setX(b3.getX());
						b3.setSpeed(0);
						Date ClickForCar1 = new Date();
						String date = dateformat1.format(d);
						if (j == 3) {
							count3++;

							tt.data[3][1] = count3;
							tt.data[3][2] = date;
							tt.data[3][3] = dateformat.format(ClickForCar1.getTime());
							
						}
					} else if (isFlag() == true) {

						b3.setX(b3.getX() - 100);
						b3.setSpeed(0);
						if (j == 3) {
							count3++;
							Date ClickForCar1 = new Date();
							String date = dateformat1.format(d);
							System.out.println("Click time" + dateformat.format(ClickForCar1.getTime()));
							

							tt.data[3][1] = count3;
							tt.data[3][2] = date;
							tt.data[3][3] = dateformat.format(ClickForCar1.getTime());
							
							
							
							int f = getScore();
							f++;
							setScore(f);
							System.out.println(getScore());
							// setScore(getScore()+1);

							scoreforpractise.setText("SCORE IS:" + "\t" + (getScore()));
						}
					}
				} else if (buttonValue.equals("CAR 5")) {

					Vehicle b3 = car.get(3);
					Vehicle b4 = car.get(4);
					if (isFlag() == false) {
						b3.setX(b3.getX());
						b3.setSpeed(0);
						b4.setX(b4.getX());
						b4.setSpeed(0);
						Date ClickForCar1 = new Date();
						String date = dateformat1.format(d);
						
						
						if (j == 4) {
							count4++;
							tt.data[4][1] = count4;
							tt.data[4][2] = date;
							tt.data[4][3] = dateformat.format(ClickForCar1.getTime());
							
							
							
						}
					} else if (isFlag() == true) {
						b3.setX(b3.getX() - 110);
						b3.setSpeed(0);
						b4.setX(b4.getX() - 100);
						b4.setSpeed(0);

						if (j == 4) {
							count4++;
							Date ClickForCar1 = new Date();
							String date = dateformat1.format(d);
							System.out.println("Click time" + dateformat.format(ClickForCar1.getTime()));
							tt.data[4][1] = count4;
							tt.data[4][2] = date;
							tt.data[4][3] = dateformat.format(ClickForCar1.getTime());
							
							
							int f = getScore();
							f++;
							setScore(f);
							System.out.println(getScore());
							// setScore(getScore()+1);

							scoreforpractise.setText("SCORE IS:" + "\t" + (getScore()));
						}
					}
				}

			} catch (Exception ex) {

			}
		}
	}

}
