package ex_3;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import File_format.csvToGame;
import File_format.gameConverts;
import File_format.solutionConverts;
import algorithm.algorithm;
import game.Game;
import game.Solution;

public class mainSolution {

	public static void main(String[] args) {

		gameConverts gc = new gameConverts();
		algorithm al = new algorithm();
		csvToGame cF = new csvToGame();
solutionConverts sC = new solutionConverts();
		File f = new File("game_1543693911932.csv");
		Game game = cF.CsvToGame(f);
//		ArrayList<packman> packList =  cF.CsvToPackmanList(f);
//		System.out.println(packList.size());
		
//		packList.get(0).

//		ArrayList<fruits> fruitList = cF.CsvToFruiteList(f) ;
//		System.out.println(fruitList.size());
		
		Solution sol = new Solution();
//		Game game = new Game(packList, fruitList);
		gc.gameToCsv(game);
		sol = al.runGame(game);
		
		
		LocalDateTime ldt = LocalDateTime.now();
	System.out.println(ldt);
	long e = 20;	
	
System.out.println(ldt.plusSeconds(e));

	}

}
