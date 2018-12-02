/*
 * 
 */
package Threads;

// TODO: Auto-generated Javadoc
/**
 * The Class TestThreads.
 */
public class TestThreads {
	
	/**
	 * The main method.
	 *
	 * @param a the arguments
	 */
	public static void main(String[] a) {
		MyThread t0 = new MyThread("aaaaaaaaaaaaaaaaaaaaaa");
		MyThread t1 = new MyThread("bbbbbbbbbbbbbbbbbbbbbb");
	//	t0.run();
	//	t1.run();
		t0.start();
		t1.start();
		System.out.println("done main");
	}
	
}
