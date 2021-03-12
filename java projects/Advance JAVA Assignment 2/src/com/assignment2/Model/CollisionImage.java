package com.assignment2.Model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class CollisionImage {
	/**
	 * Instance variables of the class
	 * 
	 */
	Image myImage;
	int x = 1200;
	int y = 198;

	/**
	 * Constructor
	 */
	public CollisionImage() {
		try {
			myImage = ImageIO.read(new File("schoolgrils.jpg"));
			myImage = myImage.getScaledInstance(100, 100, 60);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method is used to call draw the car
	 * 
	 * @param g
	 *            instance of class graphics
	 */
	public void paint(Graphics g) {

		g.drawImage(myImage, x, y, null);
	}

	/**
	 * This method is used to move the object to a specific location on the
	 * JPanel
	 */

	public void move() {
		setY(getY() + 134);
		myImage = myImage.getScaledInstance(100, 300, 60);

	}

	/**
	 * This function is used to move the object Back to its orignal position
	 */

	public void moveBack() {
		setY(getY() - 134);
		myImage = myImage.getScaledInstance(100, 100, 60);

	}

	/**
	 * Getter and setter method for instance of class
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
}
