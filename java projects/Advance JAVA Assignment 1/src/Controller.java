/**
* The Controller program implements creates the instance of car with specific arguments such as color,bounds,speed passed in the constructor
*  In this class all buttons,textfields,labels are implemented also the design of roads.
* It displays the Jtable of records and Save that table into text file. User can change the color of background. as soon as terms and conditions 
* are accepted timer for 300sec will start automatically
*
*
* @author Rupali Deoram Patil
* @version 1.10
* @since   2017-08-31 
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javax.imageio.ImageIO;
public class Controller extends JPanel implements ActionListener
{
	static int interval;
    static java.util.Timer timer;
    TextField timer1= new TextField(3);
    String secs = "300";
    int delay = 1000;
    int period = 1000;
    int score= 0;
    Image image;
    private  JList<String> colorJList;
    TextField count1 = new TextField(5);
    TextField count2 = new TextField(5);
    TextField count3= new TextField(5);
    private JTable recordTable;
    private DefaultTableModel tableModel;
    private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN,
        	      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
        	      Color.RED, Color.WHITE, Color.YELLOW};
    private static final String[] colorNames = {"Black", "Blue", "Cyan",
    		      "Gray", "Green", "Light Gray", "Magenta",
    		      "Orange", "Pink", "Red", "White", "Yellow"};;
    private int c1_clicks = 0,c2_clicks=0,c3_clicks=0;
    String msg =" This is safe driving practice simulator"; 
    private int cspeed;
    String [] columnNames = {"Car #", "No_of_breaks", "Date & Time","Score"};
    JButton break_car1,resume_Car1,about,savefile, break_car2,resume_Car2, break_car3,resume_Car3;
    CarView c1,c2,c3;
    SimpleDateFormat ft; 
    Date dNow; 
    public Controller()  
    {
            timer = new java.util.Timer();   
            interval = Integer.parseInt(secs);
            System.out.println(secs);
            timer.scheduleAtFixedRate(new TimerTask() 
            {
            	public void run() 
            	{
            		timer1.setText(Integer.toString(setInterval()));
                } 
             }, delay, period);
            
        	 ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            dNow = new Date( );
        	Object [][] rowData = {};
     		tableModel = new DefaultTableModel(rowData, columnNames);
     		recordTable = new JTable(tableModel); 
     		JScrollPane jsp = new JScrollPane(recordTable);
     		 Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
     		 Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
     		 Icon bug3 = new ImageIcon(getClass().getResource("bug3.gif"));
     		 Icon bug4 = new ImageIcon(getClass().getResource("bug4.gif"));
        	colorJList = new JList<String>(colorNames);
        	colorJList.setVisibleRowCount(5); // display five rows at once
      	      
      	      // do not allow multiple selections
        	colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      	      // add a JScrollPane containing JList to frame
      	     
        	colorJList.addListSelectionListener(
      	         new ListSelectionListener() // anonymous inner class
      	         {   
      	            // handle list selection events
      	            @Override
      	            public void valueChanged(ListSelectionEvent event)
      	            {
      	               
      	               setBackground(colors[colorJList.getSelectedIndex()]);
      	            } 
      	         } 
      	      ); 
        	 try {                
                 image = ImageIO.read(new File("school-zone-sign.jpg"));
              } catch (IOException ex) {
                   // handle exception...
              }
        	 savefile = new JButton("Save JTable into File");
        	 about = new JButton("About");
        	break_car1 = new JButton("Break Car1",bug1);
        	break_car1.setRolloverIcon(bug2);
        	break_car2= new JButton("Break Car2",bug1);
        	break_car2.setRolloverIcon(bug3);
        	break_car3 = new JButton("Break Car3",bug1);
        	break_car3.setRolloverIcon(bug4);
        	resume_Car1 = new JButton("Resume Car1");
        	resume_Car2 = new JButton("Resume Car2");
        	resume_Car3 = new JButton("Resume Car3");
        	
        	 //adding all component to the panel
        	add(new JLabel("Timer"));
            add(timer1);
        	add(new Label("Choose your Color")); 
        	add(new JScrollPane(colorJList));
        	add(break_car1);
        	add(count1);
        	add(resume_Car1);
        	add(break_car2);
        	add(count2);
        	add(resume_Car2);
        	add(break_car3);
        	add(count3);
        	add(resume_Car3);
        	add(about);
        	add(savefile);
        	add(jsp);
        	
        	// adding action listener to all buttons
        	break_car1.addActionListener(this);
        	break_car2.addActionListener(this);
        	break_car3.addActionListener(this);
        	resume_Car1.addActionListener(this);
        	resume_Car2.addActionListener(this);
        	resume_Car3.addActionListener(this);
        	about.addActionListener(this);
        	savefile.addActionListener(this);
        	// Take the instance of CarView and set the arguments
        		 Timer timer = new Timer(40, new ActionListener()
        		 {
        			 @Override
        			 public void actionPerformed(ActionEvent e)
        			 {
        				 Rectangle bounds = new Rectangle(new Point(0,200), getSize());
        				 if (c1 == null) 
        				 {
        					 c1 = new CarView(bounds,1,Color.red);
        				 }
        				 cspeed = c1.move(bounds);
	     
        				 Rectangle bounds2 = new Rectangle(new Point(100,200), getSize());
        				 if (c2 == null) 
        				 {
        					 c2 = new CarView(bounds2,3,Color.blue);
        				 }
        				 cspeed = c2.move(bounds2);
        				 
        				 Rectangle bounds3 = new Rectangle(new Point(20,200), getSize());
        				 if (c3 == null) 
        				 {
        					 c3 = new CarView(bounds3,5,Color.yellow);
        				 }
        				 cspeed = c3.move(bounds3);
        				 if(c2.getP().x+20 == c1.getP().x)
        				 {
        					 c2.getP().x -= 60;
        				 }
        				 if(c3.getP().x+15 == c1.getP().x)
        				 {
        					 c3.getP().x -= 50;
        				 }
        				 if(c1.getP().x+15 == c3.getP().x)
        				 {
        					 c1.getP().x -= 30;
        				 }
        				 if(c2.getP().x+15 == c3.getP().x)
        				 {
        					 c2.getP().x -= 30;
        				 }
        				 if(c3.getP().x+35 == c1.getP().x)
        				 {
        					 c2.getP().x -= 30;
        				 }
        				 if(c3.getP().x+35 == c2.getP().x)
        				 {
        					 c3.getP().x -= 30;
        				 }
        				 if(c3.getP().x +20 == c2.getP().x)
        				 {
    	            		c3.speed = 0;
    	            		c2.speed = 3;
        				 }
        				 if(c1.getP().x +20== c2.getP().x)
        				 {
        					 c3.speed = 0;
        					 c2.speed = 3;
        				 }
        				 if(c3.getP().x +20 == c2.getP().x)
        				 {
        					 c3.speed = 0;
        					 c2.speed = 3;
        				 }
        				 if(c1.getP().x +20 == c3.getP().x)
        				 {
        					 c1.speed = 0;
        					 c3.speed = 5;
        				 }
        				 repaint();
        			 }
        		 });
        		 timer.setRepeats(true);
        		 timer.setCoalesce(true);
        		 timer.start();
    	}
    // set timer to 300 sec
        private static final int setInterval() 
        {
            if (interval == 1)
            		timer.cancel();
            		return interval--;
        }

	     @Override
		public void actionPerformed(ActionEvent e) 
        {
        	// TODO Auto-generated method stub
        	//when clicked on break of car 1 it increase the no. of count for break
			// also put the speed on 0 and save the record in to table
			if(e.getSource()==break_car1)
			{
				cspeed = 0;
				c1.speed = 0;
				c1_clicks++;
				
				score++;
				count1.setText(Integer.toString(c1_clicks));

	        	 ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	            dNow = new Date( );
				tableModel.addRow(new Object[] {1, count1.getText(), ft.format(dNow), score});
	            recordTable = new JTable(tableModel);
	                
				
			}
			//when clicked on break of car 2 it increase the no. of count for break
			// also put the speed on 0 and save the record in to table
			if(e.getSource()==break_car2)
			{
				cspeed = 0;
				c2.speed = 0;
				c2_clicks++;
				
				score++;
				count2.setText(Integer.toString(c2_clicks));

	        	 ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	            dNow = new Date( );
				 tableModel.addRow(new Object[] {2, count2.getText(), ft.format(dNow), score});
	                recordTable = new JTable(tableModel);
	                
				
			}
			//when clicked on break of car 3 it increase the no. of count for break
			// also put the speed on 0 and save the record in to table
			if(e.getSource()==break_car3)
			{
				cspeed = 0;
				c3.speed = 0;
				c3_clicks++;
				
				score++;
				count3.setText(Integer.toString(c3_clicks));

	        	 ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	            dNow = new Date( );
				 tableModel.addRow(new Object[] {3, count3.getText(), ft.format(dNow), score});
	                recordTable = new JTable(tableModel);
	                
				
			}
			// resume button for car 1
			if(e.getSource()==resume_Car1)
			{
				c1.speed = 3;
				
			}
			// resume button for car 2
			if(e.getSource()==resume_Car2)
			{
				c2.speed = 1;
				
			}
			// resume button for car 3
			if(e.getSource()==resume_Car3)
			{
				c3.speed = 5;
				
			}
			// when clicked on savefile button it asks for file name and saves the file under that name 
			if(e.getSource()==savefile)
			{
				String str1 = JOptionPane.showInputDialog("Enter the File name to save the table data like rupali.txt: ");
				try {
					File file = new File(str1);
					if(!file.exists())
					{
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Car# No.of Breaks     Date & Time          Score\n\n");
					for(int i=0;i<recordTable.getRowCount();i++)
					{
						for(int j=0;j<recordTable.getColumnCount();j++)
						{
							bw.write(recordTable.getModel().getValueAt(i, j)+"     ");
						}
						bw.write("\n___________________________________________________\n");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog (this, "JTable Saved into "+ str1 +" File Successfully", "Safe Driving practice simulator", JOptionPane.INFORMATION_MESSAGE);	
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			// when clicked on about button it shows msg dialogue
			if(e.getSource()==about)
			{
				 JOptionPane.showMessageDialog (this, msg, "Self Driving practice simulator", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		  public void paintComponent(Graphics g) {
		        super.paintComponent(g); 
		       // draw the road design
		        g.setColor(Color.darkGray);
				g.fillRect(0, 450, 1400, 300);
				// paint lines on road, 2 pixels above and below the middle
				g.setColor(Color.white);
				for (int i = 0; i < 1400; i += 20){
					g.fillRect(i, 600 - 2, 10, 4);
				}
				//SpeedBreaker an immediate hazard
				g.setColor(Color.orange);
				g.fillRect(1000, 450, 100, 300);
				
				
				
				//draw school speed limit zone image
				g.drawImage(image, 20, 450, 100, 100, this);
				
				// draws car 1 which is red car
				 if (c1 != null) {
			            Graphics2D g2d = (Graphics2D) g.create();
			            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			            Point p = c1.getPoint();
			            g2d.translate(p.x, p.y);
			            c1.paint(g2d);
			            g2d.dispose();
			        }
				 // draws car 2 which is blue car
				 if (c2 != null) {
			            Graphics2D g2d = (Graphics2D) g.create();
			            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			            Point p = c2.getPoint();
			            g2d.translate(p.x, p.y);
			            c2.paint(g2d);
			            g2d.dispose();
			        }
				 
				 // draws car 3 which is yellow car
				 if (c3 != null) {
			            Graphics2D g2d = (Graphics2D) g.create();
			            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			            Point p = c3.getPoint();
			            g2d.translate(p.x, p.y);
			            c3.paint(g2d);
			            g2d.dispose();
			        }
				 
		  }
		  public Dimension getPreferredSize() {
		        return new Dimension(100, 100);
		    }
    }