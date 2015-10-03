package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/** 
 * Utilities to write a skyline into a svg file 
 */
public class IO {
	
	/**
	 * Transform a list of specified Point to a svg formatted string.
	 * @param l The list of Point to include in the string
	 * @return a string with the svg format
	 */
	public static String toSVGFormat(List<Point> l)
	{
		String entete = "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"300\" height=\"300\" viewBox=\"-10 -150 200 150\">\n";
		String polyline_start = "<polyline points=\"";
		String polyline_end   = "\" stroke=\"blue\" stroke-width=\"1\" fill=\"none\" transform=\"scale(5,-5)\"/></svg>\n";	
		String polyline_body = "";
		
		for(Point p : l)
		{
			polyline_body+=p.toString()+" ";
		}
		
		return entete+polyline_start+polyline_body+polyline_end;
	}
	
	/**
	 * Write in the "svg.svg" file
	 * @param s The string to write in the svg file
	 * @see toSVGFormat
	 */
	public static void writeToSVG(String s)
	{

		FileWriter fw = null;
		try
		{
			fw = new FileWriter("svg.svg");
			fw.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static List<Building> readBuilding(File f)
	{
		Scanner scanner = null;
		try {
			scanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int g = -1 ,h = -1;
		List<Building> l = new ArrayList<Building>();
		while(scanner.hasNextInt())
		{
			int newInt = scanner.nextInt();
			if (g < 0)
				g = newInt;
			else if (h < 0)
				h = newInt;
			else {
				l.add(new Building(g, h, newInt));
				g = h = -1;
			}
		}
		scanner.close();
		return l;
	}
	
	public static List<Point> buildingToSkyline(List<Building> lb)
	{
		List<Point> res = new ArrayList<Point>();
		for(Building b : lb)
		{
			res.addAll(b.toSkyline());
		}
		return res;
	}
	
	public static void viewBuilding(boolean[][] tab) 
	{
		for(int i=tab.length-1;i>=0;i--)
		{
			for(int j=0;j<tab[i].length;j++)
			{
				if(tab[i][j])
					System.out.print("X");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public static List<Point> decompact(List<Point> l)
	{
		int lastY = 0;
		List<Point> res = new ArrayList<Point>();
		
		for(Point p : l)
		{
			res.add(new Point(p.x,lastY));
			res.add(p);
			lastY = p.y;
		}
		return res;
 	
	}
	

}
