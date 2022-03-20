package kris.utils.io.readFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readFile {
    public static String getFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println("***read error!***--utils.io.readFile");
            return null;
        }
    }
}
