package game;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

import GIS1.GIS_element;
import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.IconStyle;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;

// TODO: Auto-generated Javadoc
/**
 * This class contains some function that export game to csv file and to kml file.
 *
 * @author Naor eliav and michael garusi
 */

public class gameConverts 
{

/**
 * this function get object type of game and export it to csv file.
 *
 * @param game the game
 */
	public void gameToCsv(Game game){
		int id = (int)(Math.random()*10000);
		String fileName = "Game" +id+".csv";
		PrintWriter pw = null;
		ArrayList<fruits> FruitList = game.getFruitList();
		ArrayList<packman> packmanList = game.getPackmanList();

		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Type");
		sb.append(',');
		sb.append("id");
		sb.append(',');
		sb.append("Lat");
		sb.append(',');
		sb.append("Lon");
		sb.append(',');
		sb.append("Alt");
		sb.append(',');
		sb.append("Speed/Weight");
		sb.append(',');
		sb.append("Radius");
		sb.append(',');
		sb.append(game.getFruitList().size());
		sb.append(',');
		sb.append(game.getPackmanList().size());
		sb.append(',');
		sb.append('\n');
		int i = 0;
		for(; i<game.getFruitList().size(); i++) {
			sb.append("F");
			sb.append(',');
			sb.append(i);
			sb.append(',');
			sb.append(FruitList.get(i).getPoint().y());
			sb.append(',');
			sb.append(FruitList.get(i).getPoint().x());
			sb.append(',');
			sb.append(FruitList.get(i).getPoint().z());
			sb.append(',');
			sb.append("1");
			sb.append(',');
			sb.append("");
			sb.append(',');
			sb.append('\n');}
		for(; i<(game.getPackmanList().size()+game.getFruitList().size()); i++) {
			int j=0;
			sb.append("P");
			sb.append(',');
			sb.append(i);
			sb.append(',');
			sb.append(packmanList.get(j).getPoint().y());
			sb.append(',');
			sb.append(packmanList.get(j).getPoint().x());
			sb.append(',');
			sb.append(packmanList.get(j).getPoint().z());
			sb.append(',');
			sb.append("1");
			sb.append(',');
			sb.append("1");
			sb.append(',');
			sb.append('\n');}

		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
		System.out.println(fileName);}

	/**
	 * this function get object type of game and export it to csv file.
	 *
	 * @param game the game
	 * @return file csv
	 */
	public File gameToCsvTest(Game game){
		int id = (int)(Math.random()*10000);
		String fileName = "Game" +id+".csv";
		PrintWriter pw = null;
		ArrayList<fruits> FruitList = game.getFruitList();
		ArrayList<packman> packmanList = game.getPackmanList();

		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Type");
		sb.append(',');
		sb.append("id");
		sb.append(',');
		sb.append("Lat");
		sb.append(',');
		sb.append("Lon");
		sb.append(',');
		sb.append("Alt");
		sb.append(',');
		sb.append("Speed/Weight");
		sb.append(',');
		sb.append("Radius");
		sb.append(',');
		sb.append(game.getFruitList().size());
		sb.append(',');
		sb.append(game.getPackmanList().size());
		sb.append(',');
		sb.append('\n');
		int i = 0;
		for(; i<game.getFruitList().size(); i++) {
			sb.append("F");
			sb.append(',');
			sb.append(i);
			sb.append(',');
			sb.append(FruitList.get(i).getPoint().y());
			sb.append(',');
			sb.append(FruitList.get(i).getPoint().x());
			sb.append(',');
			sb.append(FruitList.get(i).getPoint().z());
			sb.append(',');
			sb.append("1");
			sb.append(',');
			sb.append("");
			sb.append(',');
			sb.append('\n');}
		for(; i<(game.getPackmanList().size()+game.getFruitList().size()); i++) {
			int j=0;
			sb.append("P");
			sb.append(',');
			sb.append(i);
			sb.append(',');
			sb.append(packmanList.get(j).getPoint().y());
			sb.append(',');
			sb.append(packmanList.get(j).getPoint().x());
			sb.append(',');
			sb.append(packmanList.get(j).getPoint().z());
			sb.append(',');
			sb.append("1");
			sb.append(',');
			sb.append("1");
			sb.append(',');
			sb.append('\n');}

		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
		System.out.println(fileName);
		File f = new File(fileName);
		return  f;}
	
/**
 * this function get game and export it to kml.
 *
 * @param game the game
 */
	public void gameToKml(Game game) {
		ArrayList<fruits> FruitList = game.getFruitList();
		ArrayList<packman> PackmanList = game.getPackmanList();
		final Kml kml = new Kml();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		System.out.println("abcd");

		for (int i = 0; i<game.getFruitList().size();i++) { 
			
			Placemark place = doc.createAndAddPlacemark().withName("F").withOpen(Boolean.TRUE); // opens placemark
			//			place.createAndSetTimeStamp().withWhen(my.getTime());// adds time to the placemark
		
			place.createAndSetPoint().addToCoordinates(game.getFruitList().get(i).getPoint().toString()); // adds cordinats to the placemars
//			place.createAndSetTimeStamp().withWhen(game.getFruitList().get(i).getPoint().getLdt().toString());// adds time to the placemark
			place.createAndSetLookAt().withLongitude(35.2067).withLatitude(32.1044).withAltitude(0).withRange(12000000); // adds the zoom to the placemark
			Style newValue = new Style();
//			IconStyle w = new IconStyle();
//			w.setColor("red");
//			newValue.setIconStyle(w);
			place.withName("F").withStyleUrl("packman" + "F");
			place.getStyleSelector().add(newValue);



			//			int colorValue = (int) ((my.p.z() / 10000) * 255);
			//			/*
			//			 * value <-> color conversion calculate percental value (with the max value) and use it for the hex color value 0 % => yellow 50 % =>
			//			 * orange 100 % => red
			//			 */
			//			String color = Utils.getHexColor(0, (255 - colorValue), 255, true); // KML color format: inverse order of RGB
			place.setStyleUrl("C:\\Users\\mgaru\\Desktop\\‏‏תיקיה חדשה (2)");


		}
		for (int i = 0; i<game.getPackmanList().size();i++) { 

			Placemark place = doc.createAndAddPlacemark().withName("P").withOpen(Boolean.TRUE); // opens placemark
			//			place.createAndSetTimeStamp().withWhen(my.getTime());// adds time to the placemark
			place.createAndSetPoint().addToCoordinates(game.getPackmanList().get(i).getPoint().toString()); // adds cordinats to the placemars
//			place.createAndSetTimeStamp().withWhen(game.getPackmanList().get(i).getPoint().getLdt().toString());// adds time to the placemark

			place.createAndSetLookAt().withLongitude(35.2067).withLatitude(32.1044).withAltitude(0).withRange(12000000); // adds the zoom to the placemark
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
		int id = (int) (Math.random()*1000);
		File file= new File("GAME"+id+".kml");
		System.out.println(file.getName());
		try {
			kml.marshal(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		gameConverts cr = new gameConverts();
		csvToGame cf = new csvToGame();
		File f = new File("game_1543693822377.csv");
		System.out.println(f.exists());
		ArrayList<packman> m = cf.CsvToPackmanList(f);
		ArrayList<fruits> me = cf.CsvToFruiteList(f);
		Game game = new Game(m,me);
		cr.gameToCsv(game);
		cr.gameToKml(game);
		Placemark place = new  Placemark();


	}
}