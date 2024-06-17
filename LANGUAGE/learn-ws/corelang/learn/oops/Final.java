package learn.oops;

public class Final {
	
//  final static Integer INT1;  // compile error The blank final field INT1 may not have been initialized
//  final static Integer INT2 = new Integer(2); // deprecated
	final static Integer INT2 = Integer.valueOf(2);
	final Integer int3;
	final Integer int4 = new Integer(4);

	public Final() {
		int3 = new Integer(3);
//      int3 = new Integer(3); // compile error //The final field int3 may already have been assigned
		System.out.println("Final class ctor ");
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new Final();
//	}

}
