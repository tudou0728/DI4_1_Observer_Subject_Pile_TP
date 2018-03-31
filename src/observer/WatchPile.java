package observer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;

import subject.FrameDisplay;
import subject.Pile;

public class WatchPile implements Observer
{
	private long timestamp;
	private String name;
	private FrameDisplay frameDisplay=new FrameDisplay();
	private FrameDisplay frameDisplaySom=new FrameDisplay();
	
	public void pileObserver(String name)
	{
		this.name=name;
	}
		
	@Override
	public void update(Observable o, Object arg) 
	{
		if(o instanceof Pile)
		{
			timestamp=System.currentTimeMillis();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			String time = dateFormat.format(timestamp);   
	        StringBuffer buffer=new StringBuffer();
	        buffer.append("<html><body>");
	        buffer.append(time);
	        buffer.append("<br>");
	        buffer.append("nombre: ");
	        buffer.append(((Pile) o).getNbPile());
	        buffer.append("<br>");
	        buffer.append("5 bas de la pile: ");
	        buffer.append("<br>");
	        buffer.append(((Pile) o).basDeLaPile());
	        buffer.append("</body></html>");
			frameDisplay.display(buffer.toString(),500,0,0);
			StringBuffer buffer2=new StringBuffer();
			buffer2.append("<html><body>");
	        buffer2.append(time);
	        buffer2.append("<br>");
	        buffer2.append("sommet: ");
	        if(((Pile) o).getLists()==null || ((Pile) o).getLists().size()<1)
	        {
	        	buffer2.append("rien dans la pile");
	        }
	        else 
	        {
	        	buffer2.append(((Pile) o).getLists().get(((Pile) o).getLists().size()-1));
	        	buffer2.append("<br>");
		        buffer2.append("biggest: ");
		        buffer2.append(((Pile) o).getBigNoeud());
		        buffer2.append("<br>");
		        buffer2.append("sum: ");
		        buffer2.append(((Pile) o).getSommet());
			}        
	        buffer.append("</body></html>");
			frameDisplaySom.display(buffer2.toString(),500,500,0);
		}	
	}
	
}
