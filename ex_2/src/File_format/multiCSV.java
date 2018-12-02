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


/**
 * @author mgaru
 * this scene a path and convert all the csv files to kml and addes them into gis project
 * 
 * 
 * **importent** - this class can get only specific csv file with the following Fields headers:
 * 1. x value - long value
 * 2. y value - lat value
 * 3. z value - alt value
 * 4. String - data
 * 5. String - description
 * 6. String - timing - for example: 2018-12-02T12:26:20.084 
 * 7.LOng - utc zone
 * 
 * 
 */

public final class multiCSV {
	static CsvToKml c = new CsvToKml();
	public static void main(String[] args) throws IOException{
		
		MyGisProject p =multi_CVS("C:\\Users\\mgaru\\Desktop\\‏‏תיקיה חדשה");		
		System.out.println(p.size());
		
		
		}
	/**
	 * this is the center function
	 * @param path
	 * @return new gis project that include all the csv files converts to gis layers
	 *
	 */
	
	public static MyGisProject multi_CVS(String path ) {
	
	final File folder = new File(path);
	MyGisProject p = new MyGisProject();
	listFilesForFolder(p, folder);
	return p;
	}
	/**
	 * this is the recursive function that run over all the files in the path calls from the center function
	 * @param MyGisProject p , final File folder
	 * @save all the the cvs file as layers inside the gis project 
	 * and as kml in the eclipse project path
	 *
	 */
	public static void listFilesForFolder(MyGisProject p , final File folder ) { // https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
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