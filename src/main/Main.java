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
		
		List<Building> lb = IO.readBuilding(new File("building.txt"));
		List<Point> res = Exo6.divide(lb, 0, lb.size()-1);
		
		System.out.println(res);
		String svg = IO.toSVGFormat(res);
		IO.writeToSVG(svg);

	}

}
