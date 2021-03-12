package com.assignment2.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.openmbean.InvalidOpenTypeException;
import javax.swing.Timer;

public class Vehicle implements Runnable{
	
String car1="";

	
	
/*
 * X co-ordiante for the car 
 */
int x;
public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}
/*
 * Y co-ordiante for the car 
 */
int y;
public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}
/*
 * speed of the car 
 */
int speed=1;
public int getSpeed() {
	return speed;
}

public void setSpeed(int speed) {
	this.speed = speed;
}
/*
 *  
 */
int width;
public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}
int height;
int exspedd;
public int getExspedd() {
	return exspedd;
}

public void setExspedd(int exspedd) {
	this.exspedd = exspedd;
}
Color colorForTheCar;

public Color getColorForTheCar() {
	return colorForTheCar;
}

public void setColorForTheCar(Color colorForTheCar) {
	this.colorForTheCar = colorForTheCar;
}

public Vehicle(int x,int y, Color c,int s,int exs)
{
	this.x=x;
	this.y=y;
	this.colorForTheCar=c;
	this.speed=s;
	this.exspedd=exs;
	
}
	
public void paint(Graphics g)
{
	car1="CAR:"+getExspedd()+"\t"+"speed is :"+getSpeed();
	g.setColor(colorForTheCar);
	g.fillRect(x, y, 100, 120);
//	Graphics2D g2 = (Graphics2D) g;
	g.drawString(car1, x-10, y-10);
}

public void move()
{
	System.out.println("called");
	if(((x+100)>=1500)){
		x=150;
	}else if(((x<=10)))
	{
		x=1200;
	}
	//x=x+speedx;
	
}

public void stoppingCars()
{

		x=getX();
	
	
}
@Override
public void run() {
////	for(int i=x;i<=speed;i++)
////	{
//		if(speed<=40)
//		{
//			x=x+speed;
//		}
//	//}
System.out.println("h");
stoppingCars();
}


}
