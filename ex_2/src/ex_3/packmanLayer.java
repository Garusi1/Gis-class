package ex_3;

import java.util.ArrayList;

import game.packman;

public class packmanLayer {
	
	private ArrayList<packman> packmanList;
	
	public packmanLayer(ArrayList<packman> packmanList1) {
		packmanList = new ArrayList<packman>();
		packmanList = packmanList1;	
	}
	public packmanLayer(packman packman1) {
		packmanList = new ArrayList<packman>();
		packmanList.add(packman1);	
	}
	public packmanLayer() {
		
		// TODO Auto-generated constructor stub
	}
	public void add(packman packman1) {
		packmanList = new ArrayList<packman>();
		packmanList.add(packman1);	
	}
}
