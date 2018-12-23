package game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import Geom.Point3D;
import game_Solution.algorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class gameTest.
 */
class gameTest {

/**
 * Get_packman_location_by_time - i checked the right location in google earth.
 */
	@Test 
	void Get_packman_location_by_time() {
		csvToGame ctg = new csvToGame();
		algorithm al = new algorithm();
		File f = new File("game_1543693822377.csv");
		Game game = ctg.CsvToGame(f);
		al.runGame(game);
		packman p= game.getPackmanList().get(0);
		 
		Point3D point = p.getLocationByTime(0); //the point befor
		Point3D rightAns = p.path.getPathPoint(0); // the first packman point
		
		assertFalse(!point.equals(rightAns));
	}
	
	/**
	 * Gets the packman location by time 1.
	 */
	@Test 
	void Get_packman_location_by_time1() {

		csvToGame ctg = new csvToGame();
		algorithm al = new algorithm();
		File f = new File("game_1543693822377.csv");
		Game game = ctg.CsvToGame( f);
		al.runGame(game);
		packman p= game.getPackmanList().get(0);
		 
		Point3D point = p.getLocationByTime(100000); //the point befor
		Point3D rightAns = p.path.getPathPoint(p.path.pathPoints.size()-1); // the last packman point

		assertFalse(!point.equals(rightAns));
	}
	
	/**
	 * Gets the packman location by time 2.
	 */
	@Test 
	void Get_packman_location_by_time2() {

		csvToGame ctg = new csvToGame();
		algorithm al = new algorithm();
		File f = new File("game_1543693822377.csv");
		Game game = ctg.CsvToGame( f);
		al.runGame(game);
		packman p= game.getPackmanList().get(0);
		 
		Point3D point = p.getLocationByTime(124); //the point befor
		Point3D rightAns = new Point3D(35.208705, 32.102221); // the first packman point
//		System.out.println("hello");
		System.out.println(point.toString());
		assertEquals(point.x(),rightAns.x(), 0.0001);
		assertEquals(point.y(),rightAns.y(), 0.0001);

	}
	
	/**
	 * checks the size of packman list and fruit list and compare it to the CSV.
	 */
	@Test
	void CsvToGame_Test() {
		csvToGame ctg = new csvToGame();;
		File f = new File("game_1543693822377.csv");
		Game game = ctg.CsvToGame( f);
		assertEquals(17,  game.getFruitList().size());
		assertEquals(1, game.getPackmanList().size());
		}
	
	/**
	 * checks the size of packman list and fruit list and compare it to the CSV.
	 */
	@Test
	void GAME_to_Csv_Test() {
		csvToGame ctg = new csvToGame();;
		gameConverts gc = new gameConverts();
		File f = new File("game_1543693822377.csv");
		Game game = ctg.CsvToGame( f);
		File fnew = gc.gameToCsvTest(game);
		Game gamenew = ctg.CsvToGame( fnew);
		assertEquals(17,  gamenew.getFruitList().size());
		assertEquals(1, gamenew.getPackmanList().size());
		}
	
	
	

}
