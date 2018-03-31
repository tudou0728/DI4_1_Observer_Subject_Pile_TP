package controle;

import java.util.Scanner;

import observer.FlagThread;
import observer.WatchKeyCommande;
import subject.KeyCommande;
import subject.Pile;
import subject.PileOperations;

public class CommandeControl implements Runnable
{
	private KeyCommande keyCommande;
	private WatchKeyCommande watchKeyCommande;
	private Pile pile;
	
	public CommandeControl(Pile pile,FlagThread flagThread)
	{
		this.keyCommande=new KeyCommande();
		this.watchKeyCommande=new WatchKeyCommande();
		this.keyCommande.addObserver(this.watchKeyCommande);
		this.keyCommande.addObserver(flagThread);
		this.pile=pile;
		pile.addObserver(watchKeyCommande);
	}
	
	@Override
	public void run() 
	{
		System.out.println("welcome username: ");
		Scanner in = new Scanner(System.in);
		String commande=in.nextLine();
		String path="D:\\eclipse_workspace\\Pile_TP\\";
		path=path+commande+".txt";
		this.watchKeyCommande.commandeObserver(commande, path);
		while(!commande.equals("quit"))
		{
			System.out.println("input commande: ");
			commande=in.nextLine();
			keyCommande.setCommande(commande);
			executeCommande(commande);
			//pile.afficherPile();
		}
		System.exit(0);
	}
	
	public void executeCommande(String commande)
	{		
		PileOperations pileOperations=new PileOperations();
		if((commande.length()>=5) && (commande.substring(0, 4).equals("push")))
		{
			StringBuffer buffer=new StringBuffer();
			int i=4;
			boolean determineCommande=true;
			while((i<commande.length()) && (determineCommande))
			{
				if(Character.isDigit(commande.charAt(i)))
				{
					buffer.append(commande.charAt(i));
				}
				else 
				{				
					determineCommande=false;
				}
				i++;
			}
			if(determineCommande==false)
			{
				System.out.println("------il faut entrer un entier,SVP------");
			}			
			else 
			{
				pileOperations.pushPile(Integer.parseInt(buffer.toString()), pile);
			}		
		}
		else if(commande.equals("pop"))
		{
			pileOperations.popPile(pile);
		}
		else if(commande.equals("clear"))
		{
			pileOperations.clearPile(pile);
		}
		else if(commande.equals("quit"))
		{
			System.out.println("------quiter de la systeme------ ");
		}		
		else
		{
			System.out.println("------wrong commande------");
		}
	}	
}
