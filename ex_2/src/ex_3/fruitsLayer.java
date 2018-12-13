                                                                      package ex_3;

import java.util.ArrayList;

import Geom.Point3D;

public class fruitsLayer {
	
	private ArrayList<fruits> FruitList;
	private int sum  = 0;
	
	public fruitsLayer (ArrayList<fruits> FruitList1) {
		FruitList = new ArrayList<fruits>() ;
		FruitList = FruitList1;
		
		}
	public fruitsLayer () {
		FruitList = new ArrayList<fruits>();
	}
	public fruitsLayer (fruits fruits1) {
		FruitList = new ArrayList<fruits>() ;
		FruitList.add(fruits1);
		}
	public void add (fruits fruits1) {
		FruitList = new ArrayList<fruits>() ;
		FruitList.add(fruits1);
		}
	
}
