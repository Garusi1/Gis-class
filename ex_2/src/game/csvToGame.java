package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.bind.v2.runtime.reflect.Lister.Pack;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import Geom.Point3D;
// TODO: Auto-generated Javadoc
/**
 * This class contains two methods.
 * one method that make arraylist of packman by redaing a csv file.
 * the other method make  arraylist of fruits by redaing a csv file.
 * @author Naor eliav And michael garusi
 *
 */
public class csvToGame {
	
	
	
/**
 * This is the function that make arraylist of packman by redaing a csv file.
 *
 * @param f the f
 * @return arraylist of packman
 */
	public  ArrayList<packman>  CsvToPackmanList(File f) {
		ArrayList<packman> packList = new ArrayList<packman>();

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
					if(userInfo[0].toUpperCase().equals("P")) {
						packman p = new packman(Double.parseDouble(userInfo[3]),Double.parseDouble(userInfo[2]),
						Double.parseDouble(userInfo[4]),Double.parseDouble(userInfo[5]),Double.parseDouble(userInfo[6]));
						packList.add(p);

					}

					
					
				}

			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			return packList;
		}
		else {
			return null;
		}


	}        
	
	
/**
 * This is the function that make arraylist of fruits by redaing a csv file.
 *
 * @param f the f
 * @return arraylist of fruits
 */
	public  ArrayList<fruits>  CsvToFruiteList(File f) {
		ArrayList<fruits> fruitList = new ArrayList<fruits>();

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
					if(userInfo[0].toUpperCase().equals("F")) {
						fruits fr = new fruits(Double.parseDouble(userInfo[3]),Double.parseDouble(userInfo[2]),Double.parseDouble(userInfo[4]));
						fruitList.add(fr);

					}

					
					
				}

			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			return fruitList;
		}
		else {
			return null;
		}
	}
		
		/**
		 * Csv to game.
		 *
		 * @param f the f
		 * @return the game
		 */
		public Game CsvToGame(File f) {
			Game game = new Game(CsvToPackmanList(f),CsvToFruiteList(f));
			
			return game;
			
		}
		

	  
	


/**
 * The main method.
 *
 * @param args the arguments
 */
public static void main (String [] args) {
	csvToGame cf = new csvToGame();
	
	File f = new File("game_1543684662657.csv");
	System.out.println(f.exists());
	ArrayList<packman> m = cf.CsvToPackmanList(f);
	ArrayList<fruits> me = cf.CsvToFruiteList(f);

	for (fruits fruits : me) {
		System.out.println(fruits.toString());
	}
		
	
	
}
}
