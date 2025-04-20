package org.learnjava.p01_lang;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

class StringFunctions {
    public void basicFunctions() {
        String str = "Hello World";
        System.out.println("Length of the string: " + str.length());
        System.out.println("Character at index 1: " + str.charAt(1));
        System.out.println("Substring from index 1 to 4: " + str.substring(1, 4));
        {


        }
    }

    /*
    * find substring between delimiter (e.g, Hello). Parse the entire string.
    *
    * */
    public void findSubstrings() {
        System.out.println("findSubstrings");

        //find substring
        String str1 = "Hello World Hello War Hello";
        int index = 0;
        int prev = 0;
        while ((index = str1.indexOf("Hello", index)) != -1) {
            if (index != 0) {
                System.out.println("Found at index: " + str1.substring(prev, index));
                index += "Hello".length();
                prev = index;

            } else {
                //if first word is hello, then find the next one.
                index += "Hello".length();
                prev = index;
            }
        }
    }

    public void findSubstringsUsingSplit() {
        System.out.println("findSubstringsTwo");

        //find substring
        String str1 = "Hello World Hello War Hello";
        String[] strings = str1.split("Hello");
        //1.
        for (String s : strings) {
            System.out.println(s);
        }

        //2.
        List<?> list = Arrays.stream(strings).toList(); // <?> is any type
        list.forEach(s -> System.out.println(s));
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

    public String returnString() {
        return null;
    }

    public void messageFormat() {
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


    public static void main(String[] args) {

        System.out.println(" main starts ");

        StringFunctions sf = new StringFunctions();
        //sf.nullStringPrintsNull();
        //sf.basicFunctions();
        //sf.messageFormat();

        sf.findSubstrings();
        System.out.println();

        sf.findSubstringsUsingSplit();

    }
}
