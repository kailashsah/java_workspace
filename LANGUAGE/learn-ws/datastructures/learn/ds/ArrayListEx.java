package learn.ds;

import java.util.*;
import java.util.function.Consumer;

/*
  1. 
  2. insert, delete, search, iterate
  3. forEach - https://www.upgrad.com/tutorials/software-engineering/java-tutorial/java-arraylist-foreach/ 
  
  
*/

public class ArrayListEx {
	ArrayList<String> list = null;

	public ArrayListEx() {
		super();
		list = new ArrayList<String>();
		list.add("ravi");
		list.add("vijay");
		list.add("ajay");
		list.add("ravi");
//		list.forEach((n)-> StringUtilss.printt(n));// ok
		System.out.println("ctor ");
		Consumer<Integer> method = (n) -> { System.out.println(n); };
	}
	
	public void print(List listobj) {
		//1.
//		Iterator itr = listobj.iterator();
//		while (itr.hasNext()) {
//			System.out.print(itr.next() + ", ");
//		}
		
		//2.
//		listobj.forEach((n) -> System.out.print(n + ", "));//ok
		
		//3.
		listobj.forEach((Object n) -> StringUtilss.printt((String)n)); // giving error
//		listobj.forEach( StringUtilss::printt);
//		StringUtils.print(" ");
	}

	public void runOne() {
		// 1.
//		ArrayList<String> listt = (ArrayList) list.clone(); // swallow copy
		// 2.
		ArrayList<String> listt = new ArrayList<>();
		listt.addAll(this.list);
		
		// remove first
		listt.remove(0);

		// 4. iterate elements
		Iterator itr = listt.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
	}

	public void run() {
//		ArrayList<String> list = this.list;//reference assignment
//		ArrayList<String> list = (ArrayList) this.list.clone();

		ArrayList<String> listt = new ArrayList<>();
		listt.addAll(this.list);// deep copy
		// 1.
//		list.add(10, "xx"); // error: size if 4 so exception, IndexOutOfBoundsException(outOfBoundsMsg(index));

		// 2.
//		listt.remove(0);// removed 'ravi'

		// 3.
//		list.removeAll(list); // required to give collection in arg.

		// 4. other useful methods
		listt.size();
		boolean isExist = listt.contains("vijay");
//		list.clear(); // removes all elements
		listt.ensureCapacity(10); // increases the capacity
//		list.sort(null); // ajay, ravi, vijay, 
		listt.set(0, null);
		listt.trimToSize();

		System.out.println();
		print(listt);
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		var thisClass = new ArrayListEx();
//		thisClass.runOne();
//		thisClass.run();
//
//	}
	static class StringUtilss {
		public static void printt(String str) {
			System.out.print(str + ", ");
		}
	}
}
