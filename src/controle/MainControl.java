package controle;

import observer.FlagThread;
import subject.Pile;

//LI YUANYUAN
public class MainControl 
{ 	
	/**  executer */
	public static void main(String[] args) 
	{
		Pile pile=new Pile();
		FlagThread flagThread =new FlagThread();
		CommandeControl commandeControl=new CommandeControl(pile,flagThread);
		AfficherControl afficherControl=new AfficherControl(pile,flagThread);	
		new Thread(commandeControl).start(); // executer la commande
		new Thread(afficherControl).start(); //afficher le resultat
	}
	
}
