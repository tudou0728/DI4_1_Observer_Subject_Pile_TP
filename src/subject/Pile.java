package subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Pile extends Observable
{
	private List<Integer> lists;
	private Integer nbPile;
	private int sommet;
	private int bigNoeud;
	public int getBigNoeud() {
		return bigNoeud;
	}
	public void setBigNoeud(int big) {
		this.bigNoeud = big;
	}
	public int getSommet() {
		return sommet;
	}
	public void setSommet(int sommet) {
		this.sommet = sommet;
	}
	public List<Integer> getLists() {
		return lists;
	}
	public void setLists(List<Integer> lists) 
	{
		this.lists = lists;
		setNbPile(lists.size());
		setChanged();
		this.notifyObservers(this.lists);
	}
	public Integer getNbPile() {
		return nbPile;
	}
	public void setNbPile(Integer nbPile) {
		this.nbPile = nbPile;
	}

	public Pile()
	{
		lists=new ArrayList<Integer>();
		nbPile=0;
	}
	
	public void afficherPile()
	{
		Integer longueur=this.lists.size();
		if(longueur>=5)
		{
			System.out.println("position 0: "+lists.get(0)+"   position 1: "+lists.get(1)+"   position 2: "+lists.get(2)+"   position 3: "+lists.get(3)+"   position 4: "+lists.get(4));
		}
		else
		{
			if(longueur==0)
			{
				System.out.println("------rien dans la pile------");
			}
			else
			{
				int i=0;
				for(i=0;i<longueur;i++)
				{
					System.out.println("   position "+i+": "+lists.get(i));
				}
			}			
		}
	}
	
	public String basDeLaPile()
	{
		StringBuffer buffer=new StringBuffer();
		buffer.append("<html><body>");
		Integer longueur=this.lists.size();
		if(longueur>=5)
		{
			buffer.append(" position 0: "+lists.get(0));
			buffer.append("<br>");
			buffer.append(" position 1: "+lists.get(1));
			buffer.append("<br>");
			buffer.append(" position 2: "+lists.get(2));
			buffer.append("<br>");
			buffer.append(" position 3: "+lists.get(3));
			buffer.append("<br>");
			buffer.append(" position 4: "+lists.get(4));
			buffer.append("<br>");
		}
		else
		{
			if(longueur==0)
			{
				buffer.append("------rien dans la pile------");
			}
			else
			{
				int i=0;
				for(i=0;i<longueur;i++)
				{
					buffer.append("   position "+i+": "+lists.get(i));
					buffer.append("<br>");
				}
			}			
		}
		buffer.append("</body></html>");
		return buffer.toString();
	}
	
	public String pileToString()
	{
		StringBuilder stringBuilder =new StringBuilder();
		stringBuilder.append("la pile: ");
		stringBuilder.append("\r\n");
		stringBuilder.append("nombre de la pile: ");
		stringBuilder.append(lists.size());
		stringBuilder.append("\r\n");
		stringBuilder.append("contenu de la pile: ");
		stringBuilder.append("[ ");
		if(lists.size()==0)
		{		
			stringBuilder.append("------rien dans la pile------");
		}
		else
		{
			for(int i=0;i<lists.size();i++)
			{
				stringBuilder.append(lists.get(i));
				stringBuilder.append("  ");
			}
		}
		stringBuilder.append(" ]");
		stringBuilder.append("\r\n");
		return stringBuilder.toString();
	}
	
	
}
