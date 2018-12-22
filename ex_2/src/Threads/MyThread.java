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
	Thread t;

	/**
	 * Instantiates a new my thread.
	 *
	 * @param name the name
	 */
	public MyThread(Point3D p) {
		t = new Thread();
		 p1=p;
		t.start();
	}
	public MyThread() {
		t = new Thread();
		t.start();

	}
	public void setPoint(Point3D p ) {
		p1=p;

	}
	public Point3D getPoint() {
		return p1;}
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
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(i+") "+this.toString());
		}
		System.out.println("done "+this.getName());
	}
}
