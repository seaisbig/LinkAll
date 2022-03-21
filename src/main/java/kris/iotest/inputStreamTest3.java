package kris.iotest;

import kris.utils.io.outputFile.printFile;
import kris.utils.io.readFile.readFile;

public class inputStreamTest3 {
    public static void main(String[] args){
    System.out.println(readFile.getFile("F:/note/text.txt"));
    printFile.write("F:/note/text.txt","hello World");
    }
}