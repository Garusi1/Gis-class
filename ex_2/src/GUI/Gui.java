package GUI;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import Geom.Point3D;
import game.Game;
import game.fruits;
import game.gameConverts;
import game.packman;
import game_Solution.Solution;
import game_Solution.algorithm;

/*
 * This class is about showing all the game in gui
 */
public class Gui extends JFrame implements MouseListener
{
	final double x_length=1114.8926260415562;
	final double y_length=327.4627423203879;
	int Width=1433;
	int Heigth=642;


	final Point3D leftUp=new Point3D(35.202316,32.105729);
	final Point3D rightDown=new Point3D(35.210720,32.102096);


	public BufferedImage myImage;
	public BufferedImage myImage2;
	public BufferedImage myImage3;
	ArrayList<packman> pack=new ArrayList<packman>();
	ArrayList<fruits> fru=new ArrayList<fruits>();
	Solution sol = new Solution();
	public static int i=0;
	public int gameflag=0;
	game.Game g=new game.Game(pack,fru);


	int x = -1;
	int y = -1;

	int width=getWidth();
	int height=getHeight();


	public Gui() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}

	private void initGUI() 
	{
		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("Add Object"); 
		Menu menu1 = new Menu("Load File"); 
		Menu menu2 = new Menu("Run Game"); 
		Menu menu3 = new Menu("Export"); 
		Menu menu4 = new Menu("Clear"); 





		MenuItem item = new MenuItem("Open Csv File");
		MenuItem item1 = new MenuItem("Add Packman");
		MenuItem item2 = new MenuItem("Add Fruit");
		MenuItem item3 = new MenuItem("Clear Game");
		MenuItem item4 = new MenuItem("Export to Csv");
		MenuItem item5 = new MenuItem("Export to Kml");
		MenuItem item6 = new MenuItem("run");
		


		item.addActionListener(  new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				gameflag=0;
				readFileDialog();


			}
		}
				);
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{

				gameflag=1;
				repaint();

			}
		}
				);

		item2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				gameflag=-1;
				repaint();

			}
		}
				);


		item3.addActionListener(  new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pack.clear();
				fru.clear();
				repaint();
				System.out.println("It was cleared");
			}
		}
				);
		item4.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				gameConverts ga=new gameConverts();
				ga.gameToCsv(g);
			}
		}
				);
		item5.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				gameConverts ga=new gameConverts();
				ga.gameToKml(g);
			}
		}
				);
		item6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameflag = 4;
				algorithm al = new algorithm();
				sol=	al.pathCalc(pack,fru);
				repaint();
				
			}
		});




		menuBar.add(menu);
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);


		menu.add(item1);
		menu.add(item2);
		menu1.add(item);
		menu2.add(item6);
		menu3.add(item4);
		menu3.add(item5);

		menu4.add(item3);


		this.setMenuBar(menuBar);

		try {
			myImage = ImageIO.read(new File("Ariel1.PNG"));}
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			myImage2=ImageIO.read(new File("Packman.JPEG"));}
		catch (Exception e) {
			e.printStackTrace();}

		try {
			myImage3 = ImageIO.read(new File("Fruit.JPEG"));}
		catch (Exception e) {
			e.printStackTrace();}

	}


	public void paint(Graphics g)
	{
		map m = new map();
		Image test=myImage.getScaledInstance(this.getWidth(), this.getHeight(), myImage.SCALE_SMOOTH);
		g.drawImage(test,10,50, this.getWidth()-20, this.getHeight()-55, null);

		if(gameflag ==4) {
			for (int i = 0; i < sol.size(); i++) {
				for (int j = 0; j < sol.getPath(i).pathPoints.size()-1; j++) {
								
				
					Point3D p =sol.getPath(i).pathPoints.get(j) ;
					Point3D p1 = sol.getPath(i).pathPoints.get(j+1);
					int x1 = (int)m.GPS2Pixel(p).x();
					int y1 = (int)m.GPS2Pixel(p).y();
					int x2 = (int)m.GPS2Pixel(p1).x();
					int y2 = (int)m.GPS2Pixel(p1).y();
					
					if(i==0) {g.setColor(Color.BLUE);}
					if(i==1) {g.setColor(Color.GREEN);}
					if(i==2) {g.setColor(Color.red);}

					g.drawLine(x1,y1,x2,y2);
				}
			}
		}

		if(gameflag==0) {
			for (int i = 0; i < pack.size(); i++) {
				Point3D w=m.GPS2Pixel(pack.get(i).getPoint());
				g.drawImage(myImage2,((int)w.x()*getWidth())/Width,((int)w.y()*getHeight())/Heigth ,null);
				
				
				
				
				

			}



			for (int i = 0; i < fru.size(); i++) {
				Point3D u=m.GPS2Pixel(fru.get(i).getPoint());
				g.drawImage(myImage3,((int)u.x()*getWidth())/Width,((int)u.y()*getHeight())/Heigth,null);
			}
		}


		if(gameflag!=0)
		{

//			for (int i = 0; i < pack.size(); i++) {
//				g.drawImage(myImage2,(int)(pack.get(i).getPoint().x()*getWidth()),(int)(pack.get(i).getPoint().y()*getHeight()) ,30,30,null);
//			}
			
			for (int i = 0; i < pack.size(); i++) {
				Point3D w=m.GPS2Pixel(pack.get(i).getPoint());
//				g.drawImage(myImage2,((int)w.x()*getWidth())/Width,((int)w.y()*getHeight())/Heigth ,null);
				g.drawImage(myImage2,((int)w.x()*getWidth()/Width),((int)w.y()*getHeight()/Heigth),null);
				

				
				
			}




			for (int i = 0; i < fru.size(); i++) {
				Point3D w=m.GPS2Pixel(fru.get(i).getPoint());
//				g.drawImage(myImage2,((int)w.x()*getWidth())/Width,((int)w.y()*getHeight())/Heigth ,null);
				g.drawImage(myImage3,((int)w.x()*getWidth()/Width),((int)w.y()*getHeight()/Heigth),null);

			}
		}


	}


	@Override
	public void mouseClicked(MouseEvent arg) {
		map m = new map();

		System.out.println("mouse Clicked");
		double xx = arg.getX();
		xx=xx/getWidth();
		double yy = arg.getY();
		yy=yy/getHeight();
		System.out.println("(" +arg.getX() + "," + arg.getY()+")");
		x = arg.getX()/getWidth();
		y = arg.getY()/getHeight();

		if(gameflag==1)
		{
			Point3D p= m.Pixel2GPS(arg.getX() ,arg.getY());
			packman z=new packman(p.x(),p.y(),0,1,1);
			pack.add(z);
			repaint();
		}else if(gameflag==-1) {

			Point3D p= m.Pixel2GPS(arg.getX() ,arg.getY());
			fruits f=new fruits(p.x(),p.y(),0);
			fru.add(f);
			repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {


	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}



	public void readFileDialog() {

		//		try read from the file

		FileDialog fd = new FileDialog(this, "Open csv file", FileDialog.LOAD);

		fd.setFile("*.csv");

		//
		fd.setDirectory("C:\\Users\\naor9\\git\\Gis-class");

		fd.setFilenameFilter(new FilenameFilter() {


			@Override

			public boolean accept(File dir, String name) {

				return name.endsWith(".csv");

			}

		});

		fd.setVisible(true);

		String folder = fd.getDirectory();

		String fileName = fd.getFile();



		try {


			FileReader fr = new FileReader(folder + fileName);


			BufferedReader br = new BufferedReader(fr);

			File f = new File(fileName);

			fru= CsvToFruiteList(f);

			pack= CsvToPackmanList( f);
			repaint();



			br.close();

			fr.close();

		} catch (IOException ex) {

			System.out.print("Error reading file " + ex);

			System.exit(2);

		}


	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ArrayList<packman>  CsvToPackmanList(File f) {
		ArrayList<packman> packList = new ArrayList<packman>();

		String extension = "";

		int i = f.getName().lastIndexOf('.');
		if (i > 0) {
			extension = f.getName().substring(i+1);
		}

		if(extension.equals("csv")) {

			String line = "";
			String cvsSplitBy = ",";


			try (BufferedReader br = new BufferedReader(new FileReader(f))) 
			{
				line = br.readLine();
				while ((line = br.readLine()) != null) 
				{
					String[] userInfo = line.split(cvsSplitBy);
					if(userInfo[0].toUpperCase().equals("P")) {
						packman p = new packman(Double.parseDouble(userInfo[3]),Double.parseDouble(userInfo[2]),
								Double.parseDouble(userInfo[4]),Double.parseDouble(userInfo[5]),Double.parseDouble(userInfo[6]));
						packList.add(p);

					}



				}

			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			return packList;
		}
		else {
			return null;
		}


	}       

	public static int getXfromLon(double latitude, double longitude) {
		// get x value
		int mapWidth =642 , mapHeight =1433 ;
		int pX = (int)((longitude+180.)*(mapWidth/360.));

		// convert from degrees to radians
		double latRad = latitude*Math.PI/180.;

		// get y value
		double mercN = Math.log(Math.tan((Math.PI/4.)+(latRad/2.)));
		int pY = (int)((mapHeight/2.)-(mapWidth*mercN/(2.*Math.PI)));
		//System.out.println("x = "+pX+", y = "+pY);
		return pX;

	}
	public static int getYfromLat(double latitude, double longitude) {
		// get x value
		int mapWidth =642 , mapHeight =1433 ;
		int pX = (int)((longitude+180.)*(mapWidth/360.));

		// convert from degrees to radians
		double latRad = latitude*Math.PI/180.;

		// get y value
		double mercN = Math.log(Math.tan((Math.PI/4.)+(latRad/2.)));
		int pY = (int)((mapHeight/2.)-(mapWidth*mercN/(2.*Math.PI)));
		//System.out.println("x = "+pX+", y = "+pY);
		return pY;




	}
	public static ArrayList<fruits>  CsvToFruiteList(File f) {
		ArrayList<fruits> fruitList = new ArrayList<fruits>();

		String extension = "";

		int i = f.getName().lastIndexOf('.');
		if (i > 0) {
			extension = f.getName().substring(i+1);
		}

		if(extension.equals("csv")) {

			String line = "";
			String cvsSplitBy = ",";


			try (BufferedReader br = new BufferedReader(new FileReader(f))) 
			{
				line = br.readLine();
				while ((line = br.readLine()) != null) 
				{
					String[] userInfo = line.split(cvsSplitBy);
					if(userInfo[0].toUpperCase().equals("F")) {
						fruits fr = new fruits(Double.parseDouble(userInfo[3]),Double.parseDouble(userInfo[2]),Double.parseDouble(userInfo[4]));
						fruitList.add(fr);

					}



				}

			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			return fruitList;
		}
		else {
			return null;
		}



	}   
	

}