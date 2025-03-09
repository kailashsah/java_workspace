package org.learnjava.p01_lang;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class TimeFunctions
{
    public void ZonedTime(){
        Instant now = Instant.now();

        // convert Instant to ZonedDateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(dtf.format(zonedDateTime)); //2025/03/09 12:15:49   <-- IST
    }

    public void localTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        String localTime = dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
        System.out.println(localTime); //09/03/25, 12:18 pm
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
        tf.ZonedTime();
        tf.localTime();

        System.out.println("main ends");
    }
}
