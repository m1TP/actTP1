package implementation;

import java.util.List;

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
		boolean[][] window = initArray(50, 50);
		
		buildWindow(l,window);
		
		return IO.toSVGFormat(findSkyline(window));
	}

	/**
	 * Build the boolean table representing the building
	 * @param l The list containing the building to add to the table.
	 * @param window The table that will contain the buildings.
	 */
	private static void buildWindow(List<Building> l,boolean[][] window ) {
		for (Building b : l)
		{
			for(int i=b.g;i<=b.d;i++)
				for(int j=0;j<=b.h;j++)
					window[j][i]=true;
		}
		IO.viewBuilding(window);
	}
	
	private static boolean[][] initArray(int x, int y)
	{
		boolean[][] b = new boolean[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				b[i][j]=false;
		return b;
	}
	
	private static List<Point> findSkyline(boolean[][] window) {
		
		return null;
	}

	

}
