package com.assignment2.Model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CollisionImage {
	Image myImage;
	int x=1250;
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

	int y=198;
	
	public CollisionImage()
	{
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
	 */
	public void paint(Graphics g) {
		
		
		g.drawImage(myImage, x, y,null);
	}

	
	public void move()
	{
		setY(getY()+134);
		myImage=myImage.getScaledInstance(100, 300, 60);
		
	}
	
	public void moveBack()
	{
		setY(getY()-134);
		myImage=myImage.getScaledInstance(100, 100, 60);
		
	}

}
