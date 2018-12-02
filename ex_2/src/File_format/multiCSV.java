package File_format;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import GIS1.GIS_element;
import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import GIS1.MyGisProject;
import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/** Recursive listing with SimpleFileVisitor in JDK 7. */
public final class multiCSV {
	static CsvToKml c = new CsvToKml();
	public static void main(String[] args) throws IOException{
		
		MyGisProject p =multi_CVS("C:\\Users\\mgaru\\Desktop\\‏‏תיקיה חדשה");		
		System.out.println(p.size());
		}
	public static MyGisProject multi_CVS(String path ) {
	
	final File folder = new File(path);
	MyGisProject p = new MyGisProject();
	listFilesForFolder(p, folder);
	return p;
	}
		


	public static void listFilesForFolder(MyGisProject p , final File folder ) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(p, fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	            int i = fileEntry.getName().lastIndexOf('.');
				if (i > 0) {
					String extension = fileEntry.getName().substring(i+1);
				
				if(extension.equals("csv")) {
					MyGisLayer l = new MyGisLayer(fileEntry.getName().toString());
					l=c.CsvToGisLayer(fileEntry);
					c.layerToKml(l);
					p.add(l);
				}
					
				}
	            
	        }
	    }
	}



}