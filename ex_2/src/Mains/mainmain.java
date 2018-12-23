package Mains;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import game.Game;
import game.csvToGame;
import game.fruits;
import game.packman;
import game_Solution.Solution;
import game_Solution.algorithm;
import game_Solution.solutionConverts;
import sun.nio.ch.FileKey;

// TODO: Auto-generated Javadoc
/**
 * The Class mainmain.
 */
public class mainmain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		algorithm al = new algorithm();
		csvToGame cF = new csvToGame();
solutionConverts sC = new solutionConverts();
		File f = new File("game_1543693822377.csv");

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
		
		Game game = new Game(packList, fruitList);


		Solution s = new Solution();
		s=	al.pathCalc(packList,fruitList);
		solutionConverts sc = new solutionConverts();
		s.setGame(game);
		sc.solutionTo(s);
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
		
	System.out.println(packList.get(0).getLocationByTime(10));
	
		System.out.println("time of eating: "+max);
		
		
		
//sC.solutionToKml(s);		


	}



}
