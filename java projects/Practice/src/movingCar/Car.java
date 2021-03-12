package movingCar;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

public class Car extends JPanel implements ActionListener
{
	Timer time = new Timer(10, this);
	double x =0, y=350, velX=2;
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 500, 100);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 400, 500, 100);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 100, 500, 300);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 230, 50, 20);
		
		g.setColor(Color.WHITE);
		g.fillRect(100, 230, 50, 20);
		
		g.setColor(Color.WHITE);
		g.fillRect(200, 230, 50, 20);
		
		g.setColor(Color.WHITE);
		g.fillRect(300, 230, 50, 20);
		
		g.setColor(Color.WHITE);
		g.fillRect(400, 230, 50, 20);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		Ellipse2D circle = new Ellipse2D.Double(x, y, 30, 30);
		g2.fill(circle);
		
		g2.setColor(Color.RED);
		Ellipse2D circle2 = new Ellipse2D.Double((x+75), y, 30, 30);
		g2.fill(circle2);
		
		g2.setColor(Color.YELLOW);
		Rectangle2D carBody = new Rectangle2D.Double((x+5), 320, 100, 30);
		g2.fill(carBody);
		
		time.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		if (x==470)
		{
			x=0;
		}
		x +=velX;
		repaint();
	}
	

	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setVisible(true);
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("BSU Car Project");
		Car draw = new Car();
		window.add(draw);
		
	}

}
