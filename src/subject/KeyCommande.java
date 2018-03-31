package subject;

import java.util.Observable;

public class KeyCommande extends Observable
{
	private String commande;

	public String getCommande() {
		return commande;
	}

	public void setCommande(String commande) 
	{
		this.commande = commande;
		setChanged();
		this.notifyObservers(commande);
	}
	
	public KeyCommande()
	{
		commande="";
	}
	
	public void afficherCommande()
	{
		System.out.println("votre commande est: "+ commande);
	}
}
