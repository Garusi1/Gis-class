package GUI;

import javax.swing.JFrame;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import Coords.MyCoords;
import Geom.Point3D;


public class Main 
{
	
	public static void main(String[] args)
	{
		Gui window = new Gui();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		map m = new map();
		
	
		Point3D p = m.Pixel2GPS(87, 158);
		System.out.println(p);
		System.out.println(m.GPS2Pixel(p));
		
		
//(87,)
//  158
//35.68481363890823,32.18376342050639,0.0


		
	}
}