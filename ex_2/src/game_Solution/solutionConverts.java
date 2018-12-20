package game_Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import GIS1.GIS_element;
import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
import game.gameConverts;

public class solutionConverts {
	
	public void solutionToKml(Solution sol) {
		final Kml kml = new Kml();
		Path p = new Path();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		System.out.println("abcd");
		
		for (int i = 0; i<sol.size();i++) { 

			Placemark place = doc.createAndAddPlacemark().withName("point").withOpen(Boolean.TRUE); // opens placemark
			//			place.createAndSetTimeStamp().withWhen(my.getTime());// adds time to the placemark
			place.createAndSetLinearRing().addToCoordinates(sol.getPath(i).getPathCoords(sol.getPath(i)));
			place.createAndSetPoint().addToCoordinates(sol.getPath(i).getPathCoords(sol.getPath(i))); // adds cordinats to the placemars
			place.createAndSetLookAt().withLongitude(35.2067).withLatitude(32.1044).withAltitude(0).withRange(12000000); // adds the zoom to the placemark
			Style newValue = new Style();
			place.getStyleSelector().add(newValue);
System.out.println("michael the king  ");


			//			int colorValue = (int) ((my.p.z() / 10000) * 255);
			//			/*
			//			 * value <-> color conversion calculate percental value (with the max value) and use it for the hex color value 0 % => yellow 50 % =>
			//			 * orange 100 % => red
			//			 */
			//			String color = Utils.getHexColor(0, (255 - colorValue), 255, true); // KML color format: inverse order of RGB

			place.setStyleUrl("C:\\Users\\mgaru\\git\\Gis-class");

		}

		System.out.println("I passed the for loop!!!");

		//marshals to console
		kml.marshal();
		//		//marshals into file
		int id = (int) (Math.random()*1000);
		File file= new File("solution"+id+".kml");
		System.out.println(file.getName());
		try {
			kml.marshal(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void solutionTo(Solution s) {
		
		final Kml kml = new Kml();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		System.out.println("abcd");

		for (int i = 0; i<s.size();i++) { // for each loop over the elements in the layer
			Path p = s.getPath(i);
			
			for (int j = 0; j<p.size();j++) {
				
				System.out.println("fsdfsd"+p.getPoint(j).getLdt());

			Placemark place = doc.createAndAddPlacemark().withName("p"+j).withOpen(Boolean.TRUE); // opens placemark
			place.createAndSetTimeStamp().withWhen(p.getPoint(j).getLdt().toString());// adds time to the placemark
			place.createAndSetPoint().addToCoordinates(p.getPoint(j).toString()); // adds cordinats to the placemars
			System.out.println(i+"       "+j);
			place.createAndSetLookAt().withLongitude(p.getPoint(j).x()).withLatitude(p.getPoint(j).y()).withAltitude(0).withRange(12000000); // adds the zoom to the placemark
			 Style newValue = new Style();
			  place.getStyleSelector().add(newValue);
//			System.out.println("michael the king "+p.getPoint(j).getLdt().toString());
//			int colorValue = (int) ((my.p.z() / 10000) * 255);
//			/*
//			 * value <-> color conversion calculate percental value (with the max value) and use it for the hex color value 0 % => yellow 50 % =>
//			 * orange 100 % => red
//			 */
//			String color = Utils.getHexColor(0, (255 - colorValue), 255, true); // KML color format: inverse order of RGB
			place.setStyleUrl("C:\\Users\\mgaru\\Desktop\\‏‏תיקיה חדשה (2)");
				

		}
			
		}
//		kml.createAndSetPlacemark().withName("London, UK").withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(-0.126236, 51.500152);
//		kml.createAndSetPlacemark().withName("japan, Tokyo").withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(-0.12656736, 53.500152);

		//marshals to console
	    kml.marshal();
//		//marshals into file
	    int d =(int) ((Math.random())*1000);
    	File file= new File("solution"+d+".kml");
    	System.out.println("solution"+d+".kml");
    	try {
			kml.marshal(file);
			System.out.println("yes!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
gameConverts gc = new gameConverts();
gc.gameToKml(s.getGame());

}
    	
//		
	


}
