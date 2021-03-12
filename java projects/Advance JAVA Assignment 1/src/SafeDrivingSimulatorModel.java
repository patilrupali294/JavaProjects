/**
* The SafeDrivingSimulatorModel program implements Model part of the SafeDriving simulator 
* It first asks to accept the terms and conditions and then show the former screen.
*
*
* @author Rupali Deoram Patil
* @version 1.10
* @since   2017-08-31 
*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class SafeDrivingSimulatorModel
{
	Controller c;
    Object[] options = { "Agree", "Cancel" };
    public static void main(String[] args) 
    {
        new SafeDrivingSimulatorModel();
    }
    public SafeDrivingSimulatorModel() 
    {
    	EventQueue.invokeLater(new Runnable() 
    	{
    		@Override
            public void run() 
    		{
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                	}	
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                int choice = JOptionPane.showOptionDialog(null,"Do you Agree terms and conditions? Click OK to agree", "Terms and Conditions?", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(choice == JOptionPane.NO_OPTION)
                {
                	System.exit(0);
                }
                c = new Controller();
                frame.add(c);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
           }
       });
    }
   
}