package org.learnjava.p03_oops;

import java.util.ArrayList;
import java.util.List;

//import learn.ds.Check;

public class Final {

	// final static Integer INT1; // compile error The blank final field INT1
	// may not have been initialized final static Integer INT2 = new Integer(2);
	// // deprecated
	final static Integer INT2 = Integer.valueOf(2);
	final Integer int3;
	final Integer int4 = new Integer(4);

	public Final() {
		int3 = new Integer(3);
		// int3 = new Integer(3); // compile error //The final field int3 may
		// already have been assigned
		System.out.println("Final class ctor ");
	}

	public static void main(String[] args) {
		// 1.
		new Final();
		System.out.println();
		System.out.println();

		// 2.
		List list = null;
		new StaticFinal().methodd(list);
	}

}

class StaticFinal {
	public int x;
	public int y;

	// private static final List foo = new ArrayList<String>(); private final
	// List foo = new ArrayList<String>();
	private static final List foo;

	static {
		foo = new ArrayList<String>();
		System.out.println("static block ended  ");
	}

	{
		// instance initializer
		x = 5;
		y = 5;
		System.out.println("x instance initializer 1  ");
	}

	static {
		System.out.println("static 1 ended  ");
	}

	public StaticFinal() {

		// foo = new ArrayList<String>(); // The final field StaticFinal.foo
		// cannot be assigned bcoz its static and also final can be assigned
		// only once, which is there in static block
		foo.add("fdf");
		System.out.println("ctor ended  ");
	}

	{
		x = 5;
		System.out.println("x instance initializer  ");
	}

	public void methodd(List<String> obj) {
		// obj.add("fdfdf"); // no error foo = obj; // error on assignemnt foo =
		// new ArrayList<String>(); // if final it will give error upon
		// assignment
	}

	/*-
	  output -    
		  static block ended   
		  static 1 ended   
		  x instance initializer 1   
		  x instance initializer 
		  ctor ended
	 */
}