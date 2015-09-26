package main;

import java.util.ArrayList;
import java.util.List;

import util.IO;
import util.Point;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Point> l = new ArrayList<Point>();
		for(int i=2;i<7;i++)
			l.add(new Point(i,(int)Math.pow(-2, i)));
		
		String svg = IO.toSVGFormat(l);
		IO.writeToSVG(svg);

	}

}
