package org.learnjava.p03_oops;

import java.util.ArrayList;
import java.util.List;

/*
	1. static final is used to create constants.
	2. final is used to create immutable classes.
	3. final is used to prevent method overriding.
	4. final is used to prevent inheritance.
	5.
*/
public class S12_Final {

    //1. final static Integer INT1; // compile error The blank final field INT1
    //2. may not have been initialized final static Integer INT2 = new Integer(2);

    final static Integer INT2 = Integer.valueOf(2);
    static final Integer INT5 = Integer.valueOf(2); //use static,final in any order
    final Integer int3;
    //final Integer int4 = new Integer(4); //Integer(int) in Integer has been deprecated and marked for removal

    public S12_Final() {


        //1.
        int3 = 3;
        //2.
        //int3 = Integer.valueOf(3); //unnecessary boxing

        //3.
        //int3 = new Integer(3); 	//deprecated since v9. use Integer.valueOf(3) instead

        //4.
        // int3 = new Integer(3); 	// compile error //The final field int3 may already have been assigned
        System.out.println("Final class ctor ");
    }

    public static void main(String[] args) {
        // 1.
        new S12_Final();
        System.out.println();
        System.out.println();

        // 2.
        List list = null;
        new StaticFinal().methodd(list);
    }

}
/*
	1. static block
	2. instance initializer block

*/

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