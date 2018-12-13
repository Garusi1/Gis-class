package ex_3;

import java.io.File;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import sun.nio.ch.FileKey;

public class mainmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		algorithm al = new algorithm();
		csvConverts cF = new csvConverts();
solutionConverts sC = new solutionConverts();
		File f = new File("game_1543685769754.csv");

		ArrayList<packman> packList =  cF.CsvToPackmanList(f);
		System.out.println(packList.size());

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
		
//sC.solutionToKml(s);		


	}



}
