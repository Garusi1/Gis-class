package algorithm;

import java.util.ArrayList;

import Coords.MyCoords;
import Geom.Point3D;
import game.Game;
import game.Solution;
import game.fruits;
import game.packman;

public class algorithm {
/**
 * 
 * 
 * @param packList
 * @param fruitLIst
 * @return solution - array lists of the packmans pathes 
 */
	static double time=0;
	
	
	public Solution pathCalc(ArrayList<packman> packList, ArrayList<fruits> fruitLIst) {
		double x = System.currentTimeMillis();
		Solution solution = new Solution();
		packman p = new packman();
//		ArrayList<fruits> tempfrut = new ArrayList<fruits>();
		
//		while(fruitLIst.size()>0)
		{
			for (fruits fruits1 : fruitLIst) {
//				if(fruits1.getOnOff()==1) {
					p=mintimeFruitToPackList(packList, fruits1); 
					// gotothefruit
					buildpath(p, fruits1);
//					fruits1.setOff();

//				}
//				fruitLIst.remove(fruits1);
			}
		}
		for (packman pack : packList) {
			solution.add(pack.path);			
		}
		//		gis elements


		 x = (System.currentTimeMillis()-x)/1000;
		 System.out.println("runnuing time: "+x);
		return solution;

	}
	/**
	 * 
	 * @param fruit
	 * @param packman
	 * @return the time that takes the packman to arrive to the fruit
	 * 
	 */
	public double timeFruitToPack(fruits f, packman p) {
		MyCoords mc = new MyCoords();
		double dis = 0;
		if(p.getRadius()>mc.distance3d(f.getPoint(),p.getPoint())) {dis=0;}
		else {dis = mc.distance3d(f.getPoint(),p.getPoint())-p.getRadius();}
//the time that will take the packman to arrive to the fruits, includes the start time of the game and the packman radius.
		double time = (dis/p.getSpeed())+p.getTiming(); 
		System.out.println("algo time: "+time);
		return time;
	}
	
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
	 * 
	 * @param game
	 * @return solution
	 */
	
	public Solution runGame(Game game) {
		Solution s = pathCalc(game.getPackmanList(),game.getFruitList())	;
		return s;
	}


	/**
	 * 
	 * @param packList
	 * @param fruit
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
	 * 
	 * @param packman
	 * @param fruit
	 * calculates and builds a path  between a packman to a fruit
	 * moves the packman to the fruit location
	 */

	public void buildpath(packman p,fruits f) {
		MyCoords mc = new MyCoords();
		if(mc.distance3d(f.getPoint(),p.getPoint())>p.getRadius()){
			Point3D vetor2Frut = mc.vector3D(p.getPoint(), f.getPoint()); // 3D vector from the packman to the fruit
			// builds the shortest path from the packmann to the fruit
			f.getPoint().setTime(timeFruitToPack(f, p));
			p.path.add(f.getPoint());
			p.addToPackTime(timeForPack(f, p));
			p.path.addToTiming(timeFruitToPack(f, p));

			p.setPoint(mc.add(p.getPoint(), vetor2Frut)); // moves the packman point to the fruit point
			
//			p.Stops++;
		
		}

	}

}
