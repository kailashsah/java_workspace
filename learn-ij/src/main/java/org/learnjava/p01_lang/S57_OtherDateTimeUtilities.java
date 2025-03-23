package org.learnjava.p01_lang;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;


public class S57_OtherDateTimeUtilities {
    public void usingJodaTimeLibrary() {
        //1.Format for output
        //DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy");
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM 'abcdef' dd/yyyy"); //03 abcdef 21/2025

        //2. Failed cases.
        //DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM abcdef dd/yyyy"); //Illegal pattern component
        //Printing the date
        System.out.println(dtfOut.print(LocalDateTime.now())); // LocalDateTime from Joda
    }

    public void usingApacheLibrary() {
        Date date = new Date();


        //String pattern = "MM";
        //String pattern = "MM fdfdf"; // Illegal pattern component
        //String pattern = "MM y"; //03 2025
        String pattern = "MM yy"; //03 25

        String formattedDate = DateFormatUtils.format(date, pattern);

        System.out.println("Formatted Month: " + formattedDate);
    }


    public static void main(String[] args) {
        System.out.println("start of prg");

        new S57_OtherDateTimeUtilities().usingJodaTimeLibrary();
        new S57_OtherDateTimeUtilities().usingApacheLibrary();

        System.out.println("end of prg");
    }

}
