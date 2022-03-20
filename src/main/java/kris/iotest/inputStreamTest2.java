package kris.iotest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class inputStreamTest2 {
     public static void main(String[] args){
         String FileName = "F:/note/a.txt";
         String id = readUsingFiles(FileName);
         System.out.println("This is ID:\n" + id);
     }
     private static String readUsingFiles(String fileName) {
         try {
             return new String(Files.readAllBytes(Paths.get(fileName)));
         } catch (IOException e) {
             e.printStackTrace();
             return null;
         }
     }
 }
