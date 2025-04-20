package org.learnjava.p01_lang;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

class FileFunctions {

    /*
    * readFileResource() - read the file stored as a resource in the classpath. read the file line by line using BufferedReader.
    *
    * */
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

    /*
    * when reading file that doesn't exists. using File class.
    * */
    public void readNonExistingFile(){
        System.out.println("\nreadNonExistingFile()");

        File file = new File("nonExistingFile.txt");
        if (!file.exists()) {
            System.out.println("File does not exist");
        } else {
            System.out.println("File exists");
        }
    }

    public void isFileExists()
    {
        System.out.println("\nisFileExists()");
        //1.
        if(Files.exists(Path.of("nonExistingFile.txt")))
        {
            System.out.println("File exists");
        }
        else
        {
            System.out.println("File does not exist");
        }

        //2.
        if(Files.exists(Paths.get("nonExistingFile.txt"))) // calls Path.of() internally 
        {
            System.out.println("File exists");
        }
        else
        {
            System.out.println("File does not exist");
        }
    }

    /*
    * Read file using FileReader and BufferedReader.
    * */
    public void demoFileReader()
    {
        System.out.println("demoFileReader()");

        String filePath = "file.txt";

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}


public class S53_FileFunctions {
    public static void main(String[] args) throws IOException {
        FileFunctions ff = new FileFunctions();
        //1.
        ff.readFileResource();
        System.out.println();

        //2.
        ff.readNonExistingFile();

        //3.
        ff.demoFileReader();

        //4.
        ff.isFileExists();
    }
}
