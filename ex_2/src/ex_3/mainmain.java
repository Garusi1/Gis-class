package ex_3;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import File_format.csvToGame;
import File_format.solutionConverts;
import algorithm.algorithm;
import game.Solution;
import game.fruits;
import game.packman;
import sun.nio.ch.FileKey;

public class mainmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		algorithm al = new algorithm();
		csvToGame cF = new csvToGame();
solutionConverts sC = new solutionConverts();
		File f = new File("game_1543684662657.csv");

		ArrayList<packman> packList =  cF.CsvToPackmanList(f);
		System.out.println(packList.size());
		
		LocalDateTime a = LocalDateTime.now();
//		a.
//		packList.get(0).

		ArrayList<fruits> fruitList = cF.CsvToFruiteList(f) ;
		System.out.println(fruitList.size());

		for (fruits fruits1 : fruitList) {
			System.out.println(fruits1.toString());

		}


		Solution s = new Solution();
		s=	al.pathCalc(packList,fruitList);
		int sum = 0;
		System.out.println("now ");
		for (int i = 0 ; i<s.size(); i++ ) {
			System.out.println("packman"+i);
			System.out.print(s.getPath(i).toString());
			sum+=s.getPath(i).size();
		}
		
		System.out.println(sum);
		System.out.println(s.size());
		double max = packList.get(0).getTiming();
		System.out.println(packList.get(0).getRadius());
		int i = 1;
		for (packman pack : packList) {
			if(pack.getTiming()>max)
				max=pack.getTiming();
			System.out.println("time pack "+i +" = "+pack.getTiming());
			i++;
		}
		System.out.println("time of eating: "+max);
//sC.solutionToKml(s);		


	}



}
