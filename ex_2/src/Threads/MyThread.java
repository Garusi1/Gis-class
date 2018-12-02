/*
 * 
 */
package Threads;

// TODO: Auto-generated Javadoc
/**
 * The Class MyThread.
 */
public class MyThread extends Thread {
	
	/** The name. */
	private String _name;
	
	/** The id. */
	private int _id;
	
	/** The count. */
	private static int _count =0;
	
	/**
	 * Instantiates a new my thread.
	 *
	 * @param name the name
	 */
	public MyThread(String name) {
		super(name);
		_name = name;
		_id=_count;
		_count++;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#toString()
	 */
	public String toString () {return ""+this._id+": "+this._name;}
	
	/**
	 *  this is the parallel thing.
	 */
	 public void run() {
         for(int i=0;i<100;i++) {
        	 System.out.println(i+") "+this.toString());
         }
     	System.out.println("done "+this.getName());
     }
}
