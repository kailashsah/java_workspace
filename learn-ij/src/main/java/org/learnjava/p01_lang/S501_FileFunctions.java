package org.learnjava.p01_lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

class FileFunctions {

    public void readFileResource() throws IOException {

        String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource("readFile.txt")).getPath();
        //output - /C:/1_data/pers/repo/java_workspace/learn-ij/build/resources/main/readFile.txt

        FileReader f = new FileReader(filePath);

        // Reading content inside a file
        BufferedReader fi = new BufferedReader(f);

        // Printing first 2 lines of file "readFile.txt"
        for (int i = 0; i < 2; i++)
            System.out.println(fi.readLine());

        // Closing all file connections
        // using close() method
        // Good practice to avoid any memory leakage
        f.close();
    }
}

public class S501_FileFunctions {
    public static void main(String[] args) throws IOException {
        FileFunctions ff = new FileFunctions();
        ff.readFileResource();
    }
}
