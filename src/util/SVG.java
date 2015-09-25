package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/** 
 * Utilities to write a skyline into a svg file 
 */
public class SVG {
	

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

}
