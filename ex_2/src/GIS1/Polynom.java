package myMath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

import javax.management.RuntimeErrorException;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Michael
 *
 */
public class Polynom implements Polynom_able,Iterable<Monom>{

	// ********** add your code below ***********
	private ArrayList<Monom> p = new ArrayList<Monom>();

	/**
	 *  copy constructor
	 * @param poly
	 */

	public Polynom(Polynom poly) { 
		for (int i = 0; i < poly.p.size(); i++) {
			p.add(poly.p.get(i));
		}
	}

	/** Constructs a new zero polynomial. */
	
	public Polynom() {
		// do nothing because we won't store p with zero coefficients
	}
	
	
/**
 * string to polynom constructor
 * input such as: 1. +/- (double) x/X ^ (integer>=0)
 *			 	  2. +/- (double)
 * 				  3. +/- (double) * x/X ^ (integer>=0)
 * @param poly
 */

	public Polynom(String poly)
	{
		poly = poly.replaceAll("-", "+-");

		if(poly.startsWith("+")) 
			poly=poly.substring(1);

		String [] vars = poly.split("\\+");//  split between monoms
		poly = poly.toLowerCase();  // input as X and x

		for (int i = 0; i < vars.length; i++) 
		{
			int x_pos=vars[i].indexOf('x');

			if(x_pos==-1)  
				p.add(new Monom(parseDouble(vars[i]),0));  // calls to parseduoble fuction below, returns err if input is wrong

			else
			{

				String before_x=vars[i].substring(0,x_pos);
				String after_x = vars[i].substring(x_pos+1);

				if(before_x.endsWith("*")) // if writen as 4*x or 4x
					before_x=before_x.replace("*","");

				double coe = parseDouble(before_x);

				// checks if there is a power, and if the power is an integer>0  

				if(after_x.startsWith("^"))
				{
					try {
						int power = Integer.parseInt(after_x.substring(1));
						p.add(new Monom (coe,power));
					} catch (Exception e) {
						throw new RuntimeException("Worng Input");
					}
				}

				else throw new RuntimeException("Worng Input");
			}
		}
		Sort(); // calls the sort function, sorts the polynom by the power levels

	}

/**
 * add a monom to a polynom, using the add function from monom class
 */
	
	public void add(Monom m)
	{
		for(Monom me:this.p)
		{
			if(me.get_power()==m.get_power())
			{
				me.add(m);

				return;
			}
		}
		p.add(m);
		Sort();
	}

	/**
	 * sorts the polynom by the Monoms power levels
	 */

	public void Sort()
	{
		Collections.sort(p,new Monom_Comperator()); // using collections, and monom_comperator  
	}

	/**
	 * add a polynon to a polynom
	 */

	public void add(Polynom_able p1)
	{
		Polynom p2=(Polynom)p1; // cast
		if(!p2.isZero())  // if them added polynom = 0 there is nothing to add
		{
			for(Monom m:p2.p)
			{
				add(m); // using monom add function
			}		
		}
	}

	/**
	 *  side function returns string as double or err if input is wrong 
	 * @param poly
	 * @return the string to polynon if the input is correct and error if not.
	 */

	public double parseDouble(String poly) {
		try 
		{
			return Double.parseDouble(poly);				
		} catch (Exception e) 
		{
			throw new RuntimeException("Wrong Input");
		}
	}

	
	/**
	 *  a sum of Monoms in the polynom by their value at x (the (math) function value at x)
	 */

	public double f(double x) {
		double sum=0;
		for(Monom m:this.p)
			sum+=m.f(x);

		// TODO Auto-generated method stub
		return sum;
	}

	/**
	 *  subtract p from this Polygon
	 */
	@Override
	public void substract(Polynom_able p1) 
	{
		Polynom p2=(Polynom)p1;
		if(!p2.isZero()||!isZero()) 
		{
			for(Monom m:p2.p)
			{
				add(new Monom(m.get_coefficient()*-1,m.get_power())); //using the add function *-1
			}		
		}
	}
	/**
	 * multiply this Polygon by p
	 */
	@Override
	public void multiply(Polynom_able p1) 
	{
		Polynom p2=(Polynom)p1;
		Polynom result=new Polynom();
		if(!p1.isZero()||!isZero()) 
		{
			for(Monom m:p2.p) // multiply all of p2 monoms with all of 'this' monoms 
			{
				//result=new Polynom();
				Monom copy=new Monom(m);
				for(Monom m1:p)
				{
					copy.multiply(m1);
					result.add(copy);
					copy=new Monom(m);
				}
			}
			this.p=result.p;
		}
	}

	/**
	 *  compares both polynoms tostring
	 */

	@Override
	public boolean equals(Polynom_able p1) {
		return(toString().equals(((Polynom)p1).toString()));
	}
/**
 * return true if the polynom is empty
 */
	@Override
	public boolean isZero() {
		return p.isEmpty();

	}
/**
 * polynom to string fuction, based on the monom to string function
 */
	@Override

	public String toString() 
	{
		String str = "";
		for(Monom m : this.p)
			str+='+'+m.toString();

		return str;
	}

/**
 *  with help from https://www.geeksforgeeks.org/program-for-bisection-method/
 *  finds the function root 
 */
	@Override
	public double root(double x0, double x1, double eps) {

		double zeroSolv = 0.000000001;//solve the issue of x0 or x1 input equals to zero
		if ((f(x0)+zeroSolv) * (f(x1)+zeroSolv) >= 0) // if both sides are plus there is no 0 between them 
		{ 
			return 0;
		} 

		double ans = x0; 
		while ((x1-x0) >= eps) 
		{ 
			// Find middle point 
			ans = (x0+x1)/2; 

			// Check if middle point is root 
			if (f(ans) == 0.0) 
				break; 

			// Decide the minus side to repeat the steps 
			else if (f(ans)*(f(x0)+zeroSolv) < 0) 
				x1 = ans; 
			else
				x0= ans; 
		} 
		return ans;
	}


	/**
	 * copy function
	 */
	@Override
	public Polynom_able copy() {
		Polynom_able poly = new Polynom();
		for (Monom m:this.p)
		{
			poly.add(m);

		}

		return poly;
	}


	/**
	 * returns a new Polynon of the derivative, using the monom derivative function
	 */
	@Override
	public Polynom_able derivative() {

		Polynom_able poly = new Polynom();
		for(Monom m:this.p)
			poly.add(m.derivative()); // using the monom derivative function

		return poly;
	}


	/**
	 *  calculate the area above the axis x using reimans integral and f (value at point) function
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		double sum=0;
		for (double i = x0; i < x1; i+=eps) 	// from x0 to x1 with epsilon steps
		{
			double val=f(i);					
			
			//if the value of the function >0 (by boaz definition)
			
			if(val>0)
				sum+=(val*eps);					// area by reimans integral
		} 
		return sum;
	}


	//iterator
	@Override
	public Iterator<Monom> iteretor()
	{
		return new MonomIterator();
	}
	private class MonomIterator implements Iterator<Monom>
	{
		private int position  = 0;

		@Override
		public boolean hasNext() 
		{
			return position<p.size();
		}

		@Override
		public Monom next() 
		{
			return this.hasNext()? p.get(position++):null;
		}

	}
	@Override
	public Iterator<Monom> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}


