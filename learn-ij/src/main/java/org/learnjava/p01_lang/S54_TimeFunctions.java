package org.learnjava.p01_lang;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class TimeFunctions {
    public void ZonedTime() {
        //method -  system default zone

        Instant now = Instant.now();

        // convert Instant to ZonedDateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(dtf.format(zonedDateTime)); //2025/03/09 12:15:49   <-- IST
    }

    public void localTime() {
        //method - SHORT format style

        LocalDateTime dateTime = LocalDateTime.now();
        String localTime = dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
        System.out.println(localTime); //09/03/25, 12:18 pm
    }

    public void epochToLocalDateTime() {
        //method - epoch to local date time, primarily used to store time in long format

        //1. setup start time
        long epochSecond = Instant.now().getEpochSecond();
        //LocalDateTime dt = new LocalDateTime(Instant.ofEpochSecond(epochSecond), ZoneId.systemDefault());
        //ctor is private, so use below

        // create dateTime object from epoch second
        LocalDateTime dt = Instant.ofEpochSecond(epochSecond).atZone(ZoneId.systemDefault()).toLocalDateTime();
        String dateTime = dt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        System.out.println(dateTime);

        //2. setup end time
        long epochSecond2 = Instant.now().getEpochSecond() + 5;

        LocalDateTime dt2 = Instant.ofEpochSecond(epochSecond2).atZone(ZoneId.systemDefault()).toLocalDateTime();
        dateTime = dt2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        System.out.println(dateTime);

        /*
             output -  it has the gap of 5 seconds
             11-Mar-2025, 12:51:08 pm
             11-Mar-2025, 12:51:13 pm
        */

    }

    public void currentTimeMillis() {

        //retuns the difference, measured in milliseconds, between the current time and midnight, January 1, 1970 UTC.
        long currentTime = System.currentTimeMillis();
        System.out.println("Current time in milliseconds: " + currentTime);
    }

    public void datetimeFomatterPattern() {
        //method- use of ofPattern() to format date time.

        //1. %m is the windows sdk format
        String str = "%m'aaa'%d%y"; // month/date/year  11%17%2025
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(str);
        System.out.println(dtf.format(LocalDateTime.now())); //%2aaa%21%2025 // not working, expected output is different, use below format.

        //2. MM is java format
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM 'afff'");
        System.out.println(dtf1.format(LocalDateTime.now()));


    }
}

public class S54_TimeFunctions {
    public static void main(String[] args) {
        System.out.println("main starts");

        TimeFunctions tf = new TimeFunctions();
        //tf.ZonedTime();
        //tf.localTime();
        //tf.epochToLocalDateTime();
        tf.datetimeFomatterPattern();

        System.out.println("main ends");
    }
}
