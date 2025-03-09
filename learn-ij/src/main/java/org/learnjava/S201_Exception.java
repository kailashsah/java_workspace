package org.learnjava;

class MyException extends java.lang.Exception{
    public MyException(String message) {
        super(message);
    }
}


public class S201_Exception {
    public static void main(String [] args)
    {
        try {
            throw new MyException("My Exception");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
