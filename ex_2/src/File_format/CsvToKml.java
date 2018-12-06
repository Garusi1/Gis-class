/*
 * 
 */
package File_format;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.AltitudeMode;
import de.micromata.opengis.kml.v_2_2_0.Boundary;
import de.micromata.opengis.kml.v_2_2_0.ColorMode;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.LinearRing;
import de.micromata.opengis.kml.v_2_2_0.MultiGeometry;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Polygon;
import de.micromata.opengis.kml.v_2_2_0.Style;

import java.util.HashMap;
import java.util.List;

import com.skedgo.generator.Util;
import com.sun.deploy.uitoolkit.impl.fx.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import GIS1.GIS_element;
import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import GIS1.MyGisProject;
import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.ColorMode;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.StyleSelector;



// TODO: Auto-generated Javadoc
/**
 * The Class CsvToKml.
 *
 * @author Michael and naor
 * 
 * this class converts cvs to layers and layers to kml
 */

public class CsvToKml extends SimpleFileVisitor<Path> {
	
	/**
	 * this function convert csv to gis layer.
	 *
	 * @param f the f
	 * @return gislayer from the cvs file
	 */
	
	public static  MyGisLayer CsvToGisLayer(File f) {
      MyGisLayer L= new MyGisLayer(f.getName().substring(0, f.getName().length()-4));

		String extension = "";

		int i = f.getName().lastIndexOf('.');
		if (i > 0) {
		    extension = f.getName().substring(i+1);
		}
		
		if(extension.equals("csv")) {
		
	        String line = "";
	        String cvsSplitBy = ",";
	    

	        try (BufferedReader br = new BufferedReader(new FileReader(f))) 
	        {
	        	line = br.readLine();
	            while ((line = br.readLine()) != null) 
	            {
	                String[] userInfo = line.split(cvsSplitBy);
	                
	              Point3D p = new Point3D ((Double.parseDouble(userInfo[0])),(Double.parseDouble(userInfo[1])),(Double.parseDouble(userInfo[2])));
	              MyGisElement pp = new MyGisElement(p, userInfo[3],userInfo[4], userInfo[5], userInfo[6]);
	              L.add(pp);
	              
	         
	              ;
//	                System.out.println("X: " + userInfo[0] + " , Y: " + userInfo[1] +
//	                		" z: " + userInfo[2] + " ,timing: " + userInfo[7]+ " ,UTC zone: "
//	                				+ ""+ userInfo[8]+ " ,data: "+ userInfo[5]+ " ,description: "+ userInfo[6]);
	            }

	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	        return L;
	    }
		else {
			return null;
		}
		       

	}        
	
	/**
	 * this function convert gis layer to kml.
	 *
	 * @param layer the layer
	 * @return kml from the gis layer
	 */		
public static void layerToKml(MyGisLayer layer) {
		
		final Kml kml = new Kml();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		System.out.println("abcd");

		for (GIS_element gis_element : layer) { // for each loop over the elements in the layer
			MyGisElement my = (MyGisElement) gis_element;
			Placemark place = doc.createAndAddPlacemark().withName(my.getDes()).withOpen(Boolean.TRUE); // opens placemark
			place.createAndSetTimeStamp().withWhen(my.getTime());// adds time to the placemark
			place.createAndSetPoint().addToCoordinates(my.p.toString()); // adds cordinats to the placemars
			place.createAndSetLookAt().withLongitude(my.p.x()).withLatitude(my.p.y()).withAltitude(0).withRange(12000000); // adds the zoom to the placemark
			 Style newValue = new Style();
			  place.getStyleSelector().add(newValue);
			
//			int colorValue = (int) ((my.p.z() / 10000) * 255);
//			/*
//			 * value <-> color conversion calculate percental value (with the max value) and use it for the hex color value 0 % => yellow 50 % =>
//			 * orange 100 % => red
//			 */
//			String color = Utils.getHexColor(0, (255 - colorValue), 255, true); // KML color format: inverse order of RGB
			place.setStyleUrl("C:\\Users\\mgaru\\Desktop\\‏‏תיקיה חדשה (2)");
				

		}
//		kml.createAndSetPlacemark().withName("London, UK").withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(-0.126236, 51.500152);
//		kml.createAndSetPlacemark().withName("japan, Tokyo").withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(-0.12656736, 53.500152);

		//marshals to console
	    kml.marshal();
//		//marshals into file
	    
    	File file= new File(layer.getDes()+".kml");
    	try {
			kml.marshal(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
    	
//		
	
	

		/**
 * main.
 *
 * @param args the arguments
 * @throws FileNotFoundException the file not found exception
 */

    public static void main(String[] args) throws FileNotFoundException 
    
    {
    	File file = new File("WigleWifi_20171201110209.csv");
    	FileReader reader = new FileReader(file);
    	MyGisLayer m=new MyGisLayer(file.getName());
    	m=CsvToGisLayer( file);
    	layerToKml(m);
    	
  }

	
}