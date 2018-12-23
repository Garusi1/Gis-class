package GUI;

import javax.swing.JFrame;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import Coords.MyCoords;
import Geom.Point3D;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main 
{
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		Gui window = new Gui();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	map m = new map();	
	Point3D p=new Point3D(1080,319);
		Point3D z=m.Pixel2GPS(1080,319);
		//System.out.println(z);
			
	}
}