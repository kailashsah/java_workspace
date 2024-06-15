package learn.ds;
import java.util.*;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("ravi");
		list.add("vijay");
		list.add("ajay");
		list.add("ravi");
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
	}

}
	