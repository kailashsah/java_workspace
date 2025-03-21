package org.learnjava.p01_lang;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    1. Implementation of Microsoft strftime() in Java.
*/

public class S55_DateTimeFormatterUtil {
    public static String strftime(String str) {
        // implementation equals to Microsoft strftime

        StringBuilder sb = new StringBuilder();
        boolean isPercent = false;
        boolean isRegularChar = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '%') {
                isPercent = true;
                if (isRegularChar) {
                    sb.append('\'');
                    isRegularChar = false;
                }
                i++;
                ch = str.charAt(i);
                switch (ch) {
                    case 'm':
                        sb.append("MM"); // month
                        break;
                    case 'd':
                        sb.append("dd"); // date
                        break;
                    case 'y':
                        sb.append("YYYY"); // year
                        break;
                    default:
                        break;
                }
            } else {
                if (isPercent) {
                    sb.append('\'');
                    isPercent = false;
                    isRegularChar = true;
                }
                if (str.charAt(i) == '\'') {
                    isPercent = false;
                    isRegularChar = true;
                    continue;
                }
                sb.append(str.charAt(i));

            }
        }

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(sb.toString());
        String formattedDateTime = dtf2.format(LocalDateTime.now());
        //System.out.println(dtf2.format(LocalDateTime.now()));
        return formattedDateTime;

    }

    public static int formatDateTimeSpecification(String pIn, StringBuilder pOut, int nMaxLen) {
        LocalDateTime now = LocalDateTime.now();
        nMaxLen--; // Adjust for trailing \0

        for (int i = 0; i < pIn.length() && nMaxLen > 0; i++) {
            char ch = pIn.charAt(i);

            // First, check for non-pound or double pound. Copy them and continue.
            if (ch != '#') {
                pOut.append(ch);
                nMaxLen--;
                continue;
            }

            i++;
            if (i < pIn.length() && pIn.charAt(i) == '#') {
                pOut.append('#');
                nMaxLen--;
                continue;
            }

            // This is a single-pound string. Look for the ending pound.
            int pProbe = i;
            while (pProbe < pIn.length() && pIn.charAt(pProbe) != '#') {
                pProbe++;
            }

            // Non-pound ending found, copy pound and continue.
            if (pProbe == pIn.length()) {
                pOut.append('#');
                nMaxLen -= 1;
                if (i < pIn.length()) {

                    pOut.append(pIn.charAt(i));
                    nMaxLen -= 1;
                }
                continue;
            }

            int nFmtLen = pProbe - i;
            String pFmt = pIn.substring(i, pProbe);

            // Format the date-time string
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pFmt, Locale.getDefault());
            //String formattedDate = now.format(dtf);
            //2.
            String formattedDate = strftime(pFmt);

            if (formattedDate.length() > nMaxLen) {
                return -1; // Not enough space in the output buffer
            }

            pOut.append(formattedDate);
            nMaxLen -= formattedDate.length();
            i = pProbe;
        }

        return 0;
    }

    public static void main(String[] args) {
        StringBuilder pOut = new StringBuilder();

        // POSITVE CASES
        String pIn = "#%m%d%y#.dat"; //03212025.dat
        //String pIn = "#%maaa%d%y#"; // 03aaa192025
        //String pIn = "#%m#.dat"; // 03.dat
        //String pIn = "#%m%d%y##%m%d%y#.dat"; //0320202503202025.dat

        // FAILED CASES
        //String pIn = "##%maaa%d%y#"; // #%maaa%d%y#
        //String pIn = "##%m#"; // #%m#
        //String pIn = "##%m#.dat"; // #%m#.dat



        int nMaxLen = 100;

        int result = formatDateTimeSpecification(pIn, pOut, nMaxLen);
        if (result == 0) {
            System.out.println("Formatted Date-Time: " + pOut.toString());
        } else {
            System.out.println("Error formatting date-time.");
        }
    }
}