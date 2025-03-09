package org.learnjava.p01_lang;


import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;

class Folders {
    public String func() {
        //1.
        URL location = Folders.class.getProtectionDomain().getCodeSource().getLocation();

        //2.get class path directory
        String classPathInBuild = location.getFile();
        //output - /C:/1_data/pers/repo/java_workspace/learn-ij/build/classes/java/main/

        //3. get user directory
        String projectPath = System.getProperty("user.dir");
        //output - C:\1_data\pers\repo\java_workspace\learn-ij

        //4. get build directory
        String buildPath = projectPath + File.separator + "build";


        return buildPath;
    }

    public void splitPath() {
        //String s = "data/data/in.com.jotSmart/app_custom/page01/Note01.png";

        String s = "C:\\Program Files\\ASCI\\lib\\bin\\ActiveBatchV14\\ExecCopyFiles\\t.xt";
        //String[] strs = s.split("[,\\s\\;]");                             //not worked
        //String[] strs = s.split("["+ File.separator +File.separator+"]"); //not worked
        //String[] strs = s.split("[\\\\]");                                //not worked

        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] strs = s.split(pattern);


        System.out.println("Substrings length:" + strs.length);
        for (int i = 0; i < strs.length; i++) {
            System.out.println("Str[" + i + "]:" + strs[i]);
        }


        boolean found = Arrays.asList(strs).contains("bin");
        Set<String> toMatch = Set.of("bin", "lib");
        found = Arrays.stream(strs).anyMatch(p -> toMatch.contains(p));
        if (found)
            System.out.println("found");
    }

    public void splitPath_notWorked()
    {
        if(false)
        {
            //String sPath = "data/data/in.com.jotSmart/app_custom/page01/Note01.png";
            String sPath = "C:\\Program Files\\ASCI\\ActiveBatchV14\\ExecCopyFiles";
            //var answer = sPath.split("\"[" + File.separator + "]\"");
            var answer = sPath.split("\"" + File.separator + "\"");
            System.out.println(answer);
            int i;
        }
        if(false)
        {
            String sPath = "C:\\Program Files\\ASCI\\ActiveBatchV14\\ExecCopyFiles";
            Pattern pattern = Pattern.compile("\"[" + File.separator + "]\"");
            var ans = pattern.split(sPath);
            System.out.println(ans);
        }
    }
}

public class S51_BinFolders {
    public static void main(String[] args) {
        System.out.println("main starts");

        // print user.dir
        Folders folders = new Folders();
        System.out.println(folders.func());
        System.out.println();

        // split path
        folders.splitPath();

        System.out.println("main ends");
    }
}
