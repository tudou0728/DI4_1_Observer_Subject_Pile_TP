package subject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameDisplay 
{
	private JFrame frm=new JFrame("show pile!");
	
	public void display(String result,int hight,int x,int y)
	{
		frm.setSize(hight, hight);                                
	    frm.setLocation(x,y);                                  
	    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    frm.setVisible(true);           
	    JLabel label=new JLabel();    
	    JPanel panel=new JPanel(); 
	    panel.add(label);            
	    frm.getContentPane().add(panel);
	    label.setText(result);
	}    
}
