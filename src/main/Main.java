package main;

import implementation.Exo6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import util.Building;
import util.Point;
import util.IO;

public class Main {

	
	public static void main(String[] args) {
		
		/*
		List<Point> l = new ArrayList<Point>();
		 
		for(int i=2;i<7;i++)
			l.add(new Point(i,(int)Math.pow(-2, i)));
		
		String svg = SVG.toSVGFormat(l);
		SVG.writeToSVG(svg);
		*/
		
		List<Building> l = IO.readBuilding(new File("building.txt"));
		
		Exo6.solve(l);
		
	}

}
