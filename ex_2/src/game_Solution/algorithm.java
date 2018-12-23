package game_Solution;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import Coords.MyCoords;
import Geom.Point3D;
import game.Game;
import game.fruits;
import game.packman;

// TODO: Auto-generated Javadoc
/**
 * The Class algorithm.
 */
public class algorithm {

/**
 * The timeldt.
 *
 * @return solution - array lists of the packmans pathes
 */
	static LocalDateTime timeldt;
	
	
	/**
	 * Path calc.
	 *
	 * @param packList the pack list
	 * @param fruitLIst the fruit L ist
	 * @return the solution
	 */
	public Solution pathCalc(ArrayList<packman> packList, ArrayList<fruits> fruitLIst) {
		timeldt = timeldt.now(); // the start time - for the kml file
		double x = System.currentTimeMillis(); // checks the algorithm running time
		Solution solution = new Solution();
		packman p = new packman();
			
			
			for (int i = 0; i<packList.size(); i++) { //  loop the adds the same start time to all the packmans
				packList.get(i).path.pathPoints.get(0).setLdt(0, timeldt);
			}
			
			for (fruits fruits1 : fruitLIst) { // the algorithm main loop - going on all of the fruit and finds the closest packman in space and time
					p=mintimeFruitToPackList(packList, fruits1); // p is the closest packman
					buildpath(p, fruits1); // builds the path from p to the fruit
//					fruits1.setOff();

			}
		
		for (packman pack : packList) { //adds all the packman pathes to the solution
			solution.add(pack.path);			
		}

		 x = (System.currentTimeMillis()-x)/1000;
		 System.out.println("runnuing time: "+x); // prints the algorithm running time
		return solution;

	}
	
	/**
	 * the run game function.
	 *
	 * @param game the game
	 * @return solution
	 */
	
	public Solution runGame(Game game) {
		Solution s = pathCalc(game.getPackmanList(),game.getFruitList())	;
		return s;
	}
	
	/**
	 * Time fruit to pack.
	 *
	 * @param f the f
	 * @param p the p
	 * @return the time that takes the packman to arrive to the fruit,
	 *  includes the path time before the eating
	 */
	public double timeFruitToPack(fruits f, packman p) {
		MyCoords mc = new MyCoords();
		double dis = 0;
		// if - the distance is bigger than the packman radius - there is no time to add
		if(p.getRadius()>mc.distance3d(f.getPoint(),p.getPoint())) {dis=0;}
		// distance calculation - using "my coords" function
		else {dis = mc.distance3d(f.getPoint(),p.getPoint())-p.getRadius();} 
//the time that will take the packman to arrive to the fruits, includes the start time of the game and the packman radius.
		double time = (dis/p.getSpeed())+p.getTiming(); 
//		System.out.println("algo time: "+time);
		return time;
	}
	
	/**
	 * Time for pack.
	 *
	 * @param f the f
	 * @param p the p
	 * @return the time that takes the packman to arrive to the fruit
	 * - not includes the path time before the eating
	 */
	public double timeForPack(fruits f, packman p) {
		MyCoords mc = new MyCoords();
		double dis = 0;
		if(p.getRadius()>mc.distance3d(f.getPoint(),p.getPoint())) {dis=0;}
		else {dis = mc.distance3d(f.getPoint(),p.getPoint())-p.getRadius();}
//the time that will take the packman to arrive to the fruits, includes the start time of the game and the packman radius.
		double time = (dis/p.getSpeed()); 
//		System.out.println("algo time: "+time);
		return time;
	}
		
		/**
		 * Mintime fruit to pack list.
		 *
		 * @param packList the pack list
		 * @param fruit the fruit
		 * @return the best packman (from the packman list) to eat the fruit, using the timeFruitToPack function
		 */

	public packman mintimeFruitToPackList (ArrayList<packman> packList, fruits fruit){
		double minDistance = timeFruitToPack(fruit,packList.get(0));
		packman p  = packList.get(0);
		for (packman packman1 : packList) {
			if (timeFruitToPack(fruit,packman1)<minDistance) {
				minDistance=timeFruitToPack(fruit,packman1);	
				p=packman1;
			}		
		}		
System.out.println("mindis= "+minDistance);
		return p;
	}
	
	/**
	 * Buildpath.
	 *
	 * @param p the p
	 * @param f the f
	 */

	public void buildpath(packman p,fruits f) {
		MyCoords mc = new MyCoords();
		if(mc.distance3d(f.getPoint(),p.getPoint())>p.getRadius()){
			Point3D vetor2Frut = mc.vector3D(p.getPoint(), f.getPoint()); // 3D vector from the packman to the fruit
			// builds the shortest path from the packmann to the fruit
			double dis = timeFruitToPack(f, p);
			f.getPoint().setTime(timeFruitToPack(f, p)); // saves the time of the arrive inside the point
			f.getPoint().setLdt(dis,timeldt); // sets the time of eating in the fruit time
			p.path.add(f.getPoint());			//adds the fruit point to the packman path
			p.addToPackTime(timeForPack(f, p));	//adds the time of this eating to the packman
			p.path.addToTiming(timeFruitToPack(f, p)); // adds the time of this eating to the path point 
			
			p.setPoint(mc.add(p.getPoint(), vetor2Frut)); // moves the packman point to the fruit point
			
//			p.Stops++;
		
		}

	}

}
