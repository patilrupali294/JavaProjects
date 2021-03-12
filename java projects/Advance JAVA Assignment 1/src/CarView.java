/**
* The CarView program draw Car running with a given speed, color and dimensions inserted 
* in controller program at the time of creating instance
* simply displays car with different color and running on given speed limit
*
* @author Rupali Deoram Patil
* @version 1.10
* @since   2017-08-31 
*/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class CarView
{
	private Point p;
    private int radius = 12;
    int speed;
    Color c;
    //Constructor where it takes the parameter
    public CarView(Rectangle bounds,int speed2,Color cs) 
    {
    	this.c=cs;
        this.speed=speed2;
        setP(new Point());
        getP().x = 0;
        getP().y = bounds.y + (bounds.height - radius) / 2;
    }
// getter method for point
    public Point getPoint() 
    {
    	return getP();
    }
    // below function moves the car on the road.
    public int move(Rectangle bounds) 
    {
    	getP().x += speed;
        if (getP().x + radius >= (bounds.x + bounds.width)) 
        {
        	speed *= -1;
            getP().x = 0;
         }
        else if (getP().x <= bounds.x) 
        {
        	speed *= -1;
            getP().x = bounds.x + speed;
        }
        getP().y = bounds.y + (bounds.height - radius) / 2;
        return speed;
    }
    
    // draw the car
    public void paint(Graphics2D g) 
    {
    	g.setColor(c);
        g.fillRect(0, 0, radius, radius);
    }
    public Point getP() 
    {
    	return p;
	}
	public void setP(Point p) 
	{
		this.p = p;
	}
}

