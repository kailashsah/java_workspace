package org.learnjava.p01_lang;

import java.text.MessageFormat;

class StringFunctions {
    public void basicFunctions() {
        String str = "Hello World";
        System.out.println("Length of the string: " + str.length());
        System.out.println("Character at index 1: " + str.charAt(1));
        System.out.println("Substring from index 1 to 4: " + str.substring(1, 4));
    }

    public void nullStringCrashesAtEquals() {
        // null str crashes at equal
        String str = " ";
        String str1 = null;

        //if (str1.equals(str)) // crashes NPE
        if (str.equals(str1))
            System.out.println("equal");
    }

    public void nullStringPrintsNull() {
        String str = "abc";
        String str1 = null;
        str += str1;
        System.out.println(str); // prints abcnull

    }
    public  String returnString()
    {
        return null;
    }
    public void messageFormat()
    {
        String inString = returnString(); // if not assigned, MessageFormat error for null.
        String msg;
        msg = MessageFormat.format("string value {0}", inString);

        System.out.println(msg);
    }
    String removeEscapes(String textValue) {
        textValue = textValue.replaceAll("\n", "");
        textValue = textValue.replaceAll("\t", "");
        textValue = textValue.replaceAll("\\n", "");
        textValue = textValue.replaceAll("\\t", "");
        textValue = textValue.replaceAll("\r", "");
        textValue = textValue.replaceAll("\\r", "");
        textValue = textValue.replaceAll("\r\n", "");
        textValue = textValue.replaceAll("\\r\\n", "");
        return textValue;
    }
}

public class S14_StringFunctions {
    public void basicFunctions() {
        String str = "Hello World";
        System.out.println("Length of the string: " + str.length());
        System.out.println("Character at index 1: " + str.charAt(1));
        System.out.println("Substring from index 1 to 4: " + str.substring(1, 4));
    }

    public static void main(String[] args) {

        System.out.println(" main starts ");

        StringFunctions sf = new StringFunctions();
        //sf.nullStringPrintsNull();
        sf.messageFormat();

    }
}
