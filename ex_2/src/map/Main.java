package map;

import javax.swing.JFrame;

import Coords.MyCoords;
import Geom.Point3D;


public class Main 
{
	
	public static void main(String[] args)
	{
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	

		
	}
}