package controle;

import observer.FlagThread;
import observer.WatchPile;
import subject.Pile;

public class AfficherControl implements Runnable
{
	private WatchPile watchPile;
	private Pile pile;
	private FlagThread flagThread;
	
	public AfficherControl(Pile pile,FlagThread flagThread)
	{
		this.watchPile=new WatchPile();
		this.pile=pile;
		this.pile.addObserver(this.watchPile);
		this.flagThread=flagThread;
	}
	
	@Override
	public void run() 
	{    
		while(!flagThread.isExit());
		System.exit(0);
	}

}
