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

// TODO: Auto-generated Javadoc
/**
 * \
 * This class converts the game solution to kml file.
 *
 * @author Naor
 */

public class solutionConverts {

	/**
	 * Solution to Kml
	 *
	 * @param solution object
	 */
	public void solutionTo(Solution s) {

		final Kml kml = new Kml();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		System.out.println("abcd");

		for (int i = 0; i<s.size();i++) { // for each loop over the elements in the layer
			Path p = s.getPath(i);

			for (int j = 0; j<p.size();j++) {

				System.out.println("fsdfsd"+p.getPoint(j).getLdt());
				Placemark place = new Placemark();
				if (j==0) {	 place = doc.createAndAddPlacemark().withName("pack"+i+" start location").withOpen(Boolean.TRUE);} // opens placemark
				else { place = doc.createAndAddPlacemark().withName("p"+i +" " +"F"+j).withOpen(Boolean.TRUE);} // opens placemark
				place.createAndSetTimeStamp().withWhen(p.getPoint(j).getLdt().toString());// adds time to the placemark
				place.createAndSetPoint().addToCoordinates(p.getPoint(j).toString()); // adds cordinats to the placemars
				System.out.println(i+"       "+j);
				place.createAndSetLookAt().withLongitude(p.getPoint(j).x()).withLatitude(p.getPoint(j).y()).withAltitude(0).withRange(12000000); // adds the zoom to the placemark
				Style newValue = new Style();
				place.getStyleSelector().add(newValue);



			}

		}

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

	}

	//		



}
