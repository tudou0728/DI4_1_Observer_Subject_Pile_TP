package observer;

import java.util.Observable;
import java.util.Observer;

import subject.KeyCommande;

public class FlagThread implements Observer
{
	private boolean exit=false;
	
	@Override
	public void update(Observable o, Object arg) 
	{
		if(o instanceof KeyCommande)
		{
			if(((KeyCommande) o).getCommande().equals("quit"))
			{
				setExit(true);
			}
		}
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}
}
