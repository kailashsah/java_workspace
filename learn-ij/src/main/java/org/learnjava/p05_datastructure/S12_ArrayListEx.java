package org.learnjava.p05_datastructure;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Consumer;

/*
  1. 
  2. insert, delete, search, iterate
  3. forEach - https://www.upgrad.com/tutorials/software-engineering/java-tutorial/java-arraylist-foreach/ 
  
  
*/

public class S12_ArrayListEx {
    ArrayList<String> arrList = null;

    public S12_ArrayListEx() {
        super();
        arrList = new ArrayList<String>();
        arrList.add("ravi");
        arrList.add("vijay");
        arrList.add("ajay");
        arrList.add("ravi");
        arrList.forEach((n) -> StringUtilss.printt(n));// ok

        Consumer<Integer> method = (n) -> {
            System.out.println(n);
        };
    }


    public void print(List listobj) {
        //1.
        System.out.println("using iterator");
        Iterator itr = listobj.iterator();
        while (itr.hasNext()) {
        	System.out.print(itr.next() + ", ");
        }
        System.out.println("\n");

        //2.
        System.out.println("using System.out.print");
        listobj.forEach((n) -> System.out.print(n + ", "));//ok
        System.out.println("\n");
        //
        //3.
        System.out.println("using printt");
        listobj.forEach((Object n) -> StringUtilss.printt((String) n));
        System.out.println("\n");
        //listobj.forEach( StringUtilss::printt); //Object is not convertible to String

    }

    public void runOne() {
        // 1.
        //ArrayList<String> listt = (ArrayList) list.clone(); // swallow copy
        // 2.
        ArrayList<String> listt = new ArrayList<>();
        listt.addAll(this.arrList);

        // remove first
        listt.remove(0);

        // 4. iterate elements
        Iterator itr = listt.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
    }

    public void run() {
        //ArrayList<String> list = this.list;//reference assignment
        //ArrayList<String> list = (ArrayList) this.list.clone();

        ArrayList<String> listt = new ArrayList<>();
        listt.addAll(this.arrList);// deep copy
        // 1.
        //list.add(10, "xx"); // error: size if 4 so exception, IndexOutOfBoundsException(outOfBoundsMsg(index));

        // 2.
        //listt.remove(0);// removed 'ravi'

        // 3.
        //list.removeAll(list); // required to give collection in arg.

        // 4. other useful methods
        listt.size();
        boolean isExist = listt.contains("vijay");
        //list.clear(); // removes all elements
        listt.ensureCapacity(10); // increases the capacity
        //list.sort(null); // ajay, ravi, vijay,
        listt.set(0, null);
        listt.trimToSize();

        System.out.println();
        print(listt);
    }

    public void runThree()
    {
        //to check whether collection can able to iterate in for each loop
        Collection<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");

        for (String str : collection) {
            System.out.println(str);
        }
    }

    public void checknullList() {
        ArrayList<String> listLocal = null;
        for (String str : listLocal) //java.util.ArrayList.iterator() --> NullPointerException
        {
            if (str == null) {
                System.out.println("null found");
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        var thisClass = new S12_ArrayListEx();
        //1.
        //thisClass.runOne();
        //2.
        //thisClass.run();
        //3.
        //thisClass.checknullList(); // NPE test
        //4.
        //System.out.println();
        //thisClass.runThree();

    }

    static class StringUtilss {
        public static void printt(String str) {
            System.out.print(str + ", ");
        }
    }
}
