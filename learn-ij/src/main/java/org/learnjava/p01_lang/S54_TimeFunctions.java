package org.learnjava.p01_lang;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class TimeFunctions {
    public void ZonedTime() {
        Instant now = Instant.now();

        // convert Instant to ZonedDateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(dtf.format(zonedDateTime)); //2025/03/09 12:15:49   <-- IST
    }

    public void localTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        String localTime = dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
        System.out.println(localTime); //09/03/25, 12:18 pm
    }

    public void epochToLocalDateTime() {

        //1. setup start time
        long epochSecond = Instant.now().getEpochSecond();
        //LocalDateTime dt = new LocalDateTime(Instant.ofEpochSecond(epochSecond), ZoneId.systemDefault());
        //ctor is private, so use below

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

    public void basicFunctions() {
        long currentTime = System.currentTimeMillis();
        System.out.println("Current time in milliseconds: " + currentTime);
    }
}

public class S54_TimeFunctions {
    public static void main(String[] args) {
        System.out.println("main starts");

        TimeFunctions tf = new TimeFunctions();
        //tf.ZonedTime();
        //tf.localTime();
        tf.epochToLocalDateTime();


        System.out.println("main ends");
    }
}
