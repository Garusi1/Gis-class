package ex_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;

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



}
