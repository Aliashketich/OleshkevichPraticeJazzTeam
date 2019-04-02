package util.file;

import exception.MyException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GetStringFromFile {

    public static String readString(String path) throws MyException, IOException {

        String stringFromFile = "";

        try (Scanner scanFile = new Scanner(new File(path))) {
            while (scanFile.hasNext()) {
                stringFromFile = scanFile.nextLine();
            }
        } catch (IOException e) {
            throw e;
        }
        if (!stringFromFile.equals("")) {
            return stringFromFile;
        } else
            throw new MyException("Test string must be not empty!");

    }
}
