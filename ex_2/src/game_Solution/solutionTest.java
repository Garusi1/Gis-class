package game_Solution;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import Geom.Point3D;
import game.Game;
import game.csvToGame;

// TODO: Auto-generated Javadoc
/**
 * The Class solutionTest.
 */
class solutionTest {
	
	/**
	 * algorithm test - return true if the path going throw all the fruits.
	 */


	@Test
	void test() {

		algorithm al = new algorithm();
		csvToGame cF = new csvToGame();
		solutionConverts sC = new solutionConverts();
		File f = new File("game_1543693822377.csv");
		Game game = cF.CsvToGame(f);
		Solution s = al.runGame(game);
		boolean flag = true;
		for (int i = 0; i < game.getFruitList().size();i ++) {
			if(flag == false) { assertTrue(flag); return;}
			flag=false;
			for (int j = 0; j < s.size(); j++) {
				for (int j2 = 0; j2 < s.getPath(j).size(); j2++) {

					if(s.getPath(j).getPathPoint(j2).equals(game.getFruitList().get(i).getPoint())) {
						flag = true;
					};

				}


			}

		}

		assertTrue(flag);
	}
	

}
