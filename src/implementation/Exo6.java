package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import util.Building;
import util.Point;
import util.IO;

public class Exo6 {
	
	/**
	 * Resolution 
	 * @param l 
	 * @return
	 */
	public static String solve(List<Building> l)
	{
		
		return null;
	}
	
	public static List<Point> divide(List<Building> lb, int g, int d)
	{
		if (g==d)
		{
			return lb.get(g).toSkyline();
		}
		
		int milieu = (g+d)/2;
		
		List<Point> l1 = divide(lb,g,milieu);
		List<Point> l2 = divide(lb,milieu+1,d);
				
		return fusion(l1,l2);
	}
	
	public static List<Point> fusion(List<Point> l1, List<Point> l2)
	{
		//we keep the height of the last element inserted of each list
		int heightList1 = 0;
		int heightList2 = 0;
	
		int axis_tmp    = -1;
		
		int indice_l1   = 0;
		int indice_l2   = 0;
		
		//
		List<Point> res  = new ArrayList<Point>(l1.size()+l2.size());
		
		
		while(indice_l1<l1.size() && indice_l2<l2.size())
		{
			if (l1.get(indice_l1).x<l2.get(indice_l2).x)
			{
				axis_tmp = l1.get(indice_l1).x;
				heightList1 = l1.get(indice_l1).y;
				indice_l1++;
			}
			else if (l1.get(indice_l1).x>=l2.get(indice_l2).x)
			{
				axis_tmp = l2.get(indice_l2).x;
				heightList2 = l2.get(indice_l2).y;
				indice_l2++;
			}
			
			
			Point newPoint = new Point(axis_tmp,Math.max(heightList1,heightList2));
			res.add(newPoint);
		}
		
		//on ajoute ce quil reste ds les liste
		for(int i = indice_l1;i<l1.size();i++)
			res.add(l1.get(i));
		for(int i = indice_l2;i<l2.size();i++)
			res.add(l2.get(i));
		
		return reduce(res);
		
	}
	
	/**
	 * Remove duplicate i the skyline list
	 * @param l The list to be reduced
	 * @return A skyline with no rdundant information
	 */
	public static List<Point> reduce(List<Point> l)
	{
		for(int i=0;i<l.size()-2;i++)
		{
			if(l.get(i).x==l.get(i+1).x)
				l.remove(i);
		}
		
		for(int i=0;i<l.size()-2;i++)
		{
			if(l.get(i).y==l.get(i+1).y)
				l.remove(i+1);
		}
		return l;
	}
	

}
