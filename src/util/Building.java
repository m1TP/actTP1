package util;

import java.util.ArrayList;
import java.util.List;

public class Building {
	/**
	 * 
	 * We describe rectangular shape representing building
	 * with:
	 * -g is the leftmost coordinate on the x-axis
	 * -h is the upperbound of the shape, on the y-axis
	 * -d is the rightmost coordinate on the x-axis
	 * 
	 * With those 3 number, we can construct a rectangular box with 
	 * the four corner of coordinate (g,0) (g,h) (d,h) (d,0) 
	 * 
	 */
	public int g,h,d;
	
	public Building(int g,int h, int d)
	{
		this.g = g;
		this.h = h;
		this.d = d;
	}
	
	public List<Point> toSkyline()
	{
		List<Point> res = new ArrayList<Point>();
		res.add(new Point(g,h));
		res.add(new Point(d,0));
		return res;
	}
	
	
	
}
