/*
 * 
 */
package Threads;

import javax.naming.InitialContext;

import Geom.Point3D;
import game.packman;
import javafx.fxml.Initializable;

// TODO: Auto-generated Javadoc
/**
 * The Class MyThread.
 */
public class MyThread extends Thread {

	/** The name. */
	static Point3D p1;
	
	/** The t. */
	Thread t;

	/**
	 * Instantiates a new my thread.
	 *
	 * @param p the p
	 */
	public MyThread(Point3D p) {
		t = new Thread();
		 p1=p;
		t.start();
	}
	
	/**
	 * Instantiates a new my thread.
	 */
	public MyThread() {
		t = new Thread();
		t.start();

	}
	
	/**
	 * Sets the point.
	 *
	 * @param p the new point
	 */
	public void setPoint(Point3D p ) {
		p1=p;

	}
	
	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public Point3D getPoint() {
		return p1;}
	
	/**
	 * Draw path.
	 *
	 * @param p the p
	 * @throws InterruptedException the interrupted exception
	 */
	/* (non-Javadoc)
	 * @see java.lang.Thread#toString()
	 */
	public void drawPath( packman p) throws InterruptedException {
		for (double i = 0; i < p.getTiming();i+=0.1 ) {
			p1 = p.getLocationByTime(i);
			System.out.println(p1);
			MyThread.sleep(1);

			System.out.println("ddd");



		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(i+") "+this.toString());
		}
		System.out.println("done "+this.getName());
	}
}
