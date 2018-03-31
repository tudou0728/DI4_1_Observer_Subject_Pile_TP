package subject;

import java.util.List;

public class PileOperations 
{
	public void  pushPile(Integer num,Pile pile)
	{
		List<Integer> list=pile.getLists();
		list.add(num);
		pile.setSommet(calculerSommet(list));
		pile.setBigNoeud(retourBig(list));
		pile.setLists(list);
		
		//System.out.println("------ajouter------");
	}
	
	public void  popPile(Pile pile)
	{
		List<Integer> list=pile.getLists();
		Integer longueur=list.size();
		if(longueur==0)
		{
			System.out.println("------maintenant rien dans la pile------");
		}
		else 
		{
			list.remove(longueur-1);
			pile.setSommet(calculerSommet(list));
			pile.setBigNoeud(retourBig(list));
			pile.setLists(list);
			//pile.setSommet();
			//System.out.println("------supprimer------");
		}
		
	}
	
	public void clearPile(Pile pile)
	{
		List<Integer> list=pile.getLists();
		Integer longueur=list.size();
		if(longueur==0)
		{
			System.out.println("------maintenant rien dans la pile------");
		}
		else
		{
			list.clear();
			pile.setSommet(calculerSommet(list));
			pile.setBigNoeud(retourBig(list));
			pile.setLists(list);
			//pile.setSommet();
			//System.out.println("------supprimer tous------");
		}		
	}
	
	public int retourBig(List<Integer> lists)
	{
		int i=0;
		int som=0;
		for(i=0;i<lists.size();i++)
		{
			if(som>lists.get(i))
			{
				som=som;
			}
			else
			{
				som=lists.get(i);
			}
		}
		return som;
	}
	
	public int calculerSommet(List<Integer> lists)
	{
		int i=0;
		int som=0;
		for(i=0;i<lists.size();i++)
		{
			som=som+lists.get(i);
		}
		return som;
	}
}
