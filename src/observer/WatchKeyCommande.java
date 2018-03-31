package observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;

import subject.KeyCommande;
import subject.Pile;

public class WatchKeyCommande implements Observer 
{
	private String name;
	private File dailyLog;
	private String logpPath;
	 
	 public void commandeObserver(String name,String path) 
	 {
		 this.name=name;
		 this.logpPath=path;
		 dailyLog=new File(logpPath);
	 }
	 
	@Override
	public void update(Observable o, Object arg) 
	{
		if(o instanceof KeyCommande)
		{
			((KeyCommande) o).afficherCommande();
			writeActionsInDoc(((KeyCommande) o).getCommande());
		}
		if(o instanceof Pile)
		{
			writeResultInLog(((Pile) o).pileToString());
		}
	}
	
	public void writeActionsInDoc(String commande)
	{
		try 
		{
			dailyLog=new File(logpPath);
			if(!dailyLog.exists())
			{
				dailyLog.createNewFile();
			}
			FileWriter fileWriter=new FileWriter(dailyLog, true);
			long timestamp=System.currentTimeMillis();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			String time = dateFormat.format(timestamp);  
			time+="\r\n"; 
			fileWriter.write(time);
			fileWriter.write("1.commande: ");
			commande+="\r\n";  
			fileWriter.write(commande);
			fileWriter.close();
			System.out.println("------commande write in the log------");
		}	
        catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void writeResultInLog(String result)
	{
		try 
		{
			dailyLog=new File(logpPath);
			if(!dailyLog.exists())
			{
				dailyLog.createNewFile();
			}
			FileWriter fileWriter=new FileWriter(dailyLog, true);
			String resultat="2.result: ";
			resultat+="\r\n";  
			resultat+=result;  
			resultat+="\r\n";  
			fileWriter.write(resultat);
			fileWriter.close();
			System.out.println("------result write in the log------");
		}	
        catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
