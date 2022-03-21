package kris.utils.io.outputFile;

import java.io.FileOutputStream;

public class printFile {
    public static void write(String filepath, String s) {
        try {
            FileOutputStream fos = new FileOutputStream(filepath);
            fos.write(s.getBytes());
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
