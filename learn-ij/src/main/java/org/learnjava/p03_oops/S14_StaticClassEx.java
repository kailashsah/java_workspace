package org.learnjava.p03_oops;
/*
    1. outer class can have static nested class.
    2. static nested class can access only static members of outer class.
    3. static nested class can be accessed without creating instance of outer class.

    4. Inner class - non-static nested class is also called inner class.
    5. Inner class can access both static and non-static members of outer class.
    6. Inner class can be accessed only by creating instance of outer class.
*/

class OuterClass {

    // Input string
    private static String msg = "im static class example";

    // Static nested class
    public static class NestedStaticClass {

        // Only static members of Outer class
        // is directly accessible in nested
        // static class
        public void printMessage() {

            // Try making 'message' a non-static
            // variable, there will be compiler error
            System.out.println(
                    "Message from nested static class: " + msg);
        }
    }

    // Non-static nested class - also called Inner class
    public class InnerClass {

        // Both static and non-static members
        // of Outer class are accessible in
        // this Inner class
        public void display() {

            // Print statement whenever this method is
            // called
            System.out.println(
                    "Message from non-static nested class: "
                            + msg);
        }
    }
}

public class S14_StaticClassEx {

    public void run() {
        // Creating instance of nested Static class
        // inside main() method
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();

        // Calling non-static method of nested
        // static class
        printer.printMessage();

        // Note: In order to create instance of Inner class
        //  we need an Outer class instance

        // Creating Outer class instance for creating
        // non-static nested class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        // Calling non-static method of Inner class
        inner.display();

        // We can also combine above steps in one
        // step to create instance of Inner class
        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

        // Similarly calling inner class defined method
        innerObject.display();
    }

    public static void main(String[] args) {

        new S14_StaticClassEx().run();
    }

}
