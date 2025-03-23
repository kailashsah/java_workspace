package org.learnjava.p03_oops;


/*
    1. upcasting and downcasting
    2. same method could be defined again in the subclass without @Override annotation
    3. class B extends A, C -> not possible in java extending mutiple classes
*/

class A {

    public void methodA() {
        System.out.println("A");
    }
}

class B extends A {

    @Override
    public void methodA() {
        System.out.println("B");
    }
}


public class S22_Override {
    public static void main(String[] args) {
        //1.
        A a = new B();
        a.methodA();    // B

        //2.  down casting
        //B b = (B) new A(); // java.lang.ClassCastException --> A cannot be cast to class org.learnjava.p01_lang.B
        //b.methodB();
    }
}
