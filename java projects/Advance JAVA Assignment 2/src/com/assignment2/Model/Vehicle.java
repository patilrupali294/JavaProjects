package com.assignment2.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.management.openmbean.InvalidOpenTypeException;
import javax.swing.Timer;

/**
 * 
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class Vehicle implements Runnable {
	String car1 = "";
	Image carImage;

	/**
	 * X co-ordiante for the car
	 */
	int x;
	/**
	 * Y co-ordiante for the car
	 */
	int y;
	/**
	 * speed of the car
	 */
	int speed = 1;
	int width;
	int height;
	int exspedd;
	Color colorForTheCar;

	/**
	 * Constructor for the class
	 * 
	 * @param x
	 *            intial starting position of the car
	 * @param y
	 *            intial starting position of the car
	 * @param c
	 *            initial colour for the car
	 * @param s
	 *            initial speed for the car
	 * @param exs
	 *            number of the car
	 */
	public Vehicle(int x, int y, Color c, int s, int exs) {
		this.x = x;
		this.y = y;
		this.colorForTheCar = c;
		this.speed = s;
		this.exspedd = exs;
		try {
			carImage = ImageIO.read(new File("car4.png"));
			carImage = carImage.getScaledInstance(100, 100, 3);

		} catch (Exception ex) {

		}

	}

	/**
	 * This method is used to paint the car
	 * 
	 * @param g
	 */

	public void paint(Graphics g) {
		car1 = "CAR:" + getExspedd() + "\t" + "speed is :" + getSpeed();
		g.setColor(colorForTheCar);
		g.drawString(car1, x - 10, y - 10);
		g.drawImage(carImage, x, y, null);
	}

	/**
	 * This method is used to move the car back and forth When it hits the edges
	 * of the frame
	 */
	public void move() {
		System.out.println("called");
		if (((x + 100) >= 1500)) {
			x = 150;
		} else if (((x <= 10))) {
			x = 1200;
		}


	}

	/**
	 * This method is used to stop the cars
	 */
	public void stoppingCars() {
		x = getX();
	}

	@Override
	public void run() {
		System.out.println("h");
		stoppingCars();
	}

	/**
	 * Getter and setter methods
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getExspedd() {
		return exspedd;
	}

	public void setExspedd(int exspedd) {
		this.exspedd = exspedd;
	}

	public Color getColorForTheCar() {
		return colorForTheCar;
	}

	public void setColorForTheCar(Color colorForTheCar) {
		this.colorForTheCar = colorForTheCar;
	}

}
