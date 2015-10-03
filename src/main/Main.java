package main;

import implementation.Exo6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import util.Building;
import util.IO;
import util.Point;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
1 10 5
5 6 8
10 8 12
2 12 7
9 4 11
11 2 14
		 */
		List<Building> lb = IO.readBuilding(new File("building.txt"));
		List<Point> res = Exo6.divide(lb, 0, lb.size()-1);
		
		System.out.println(IO.decompact(res));
		String svg = IO.toSVGFormat(IO.decompact(res));
		IO.writeToSVG(svg);

	}

}
