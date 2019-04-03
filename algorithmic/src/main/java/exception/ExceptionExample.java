package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample {
    public static void main(String args[]) {

        // Java code to demonstrate ArithmeticException
        try {//NOSONAR
            int a = 30, b = 0;//NOSONAR
            int c = a / b;  //NOSONAR
            System.out.println("Result = " + c);//NOSONAR
        } catch (ArithmeticException e) {//NOSONAR
            System.out.println("Can't divide a number by 0");//NOSONAR
        }//NOSONAR

        //Java code to demonstrate NullPointerException
        try {//NOSONAR
            String a = null; //NOSONAR
            System.out.println(a.charAt(0));//NOSONAR
        } catch (NullPointerException e) {//NOSONAR
            System.out.println("NullPointerException.");//NOSONAR
        }//NOSONAR

        // Java code to demonstrate StringIndexOutOfBoundsException
        try {//NOSONAR
            String a = "This is like chipping "; //NOSONAR
            char c = a.charAt(24); //NOSONAR
            System.out.println(c);//NOSONAR
        } catch (StringIndexOutOfBoundsException e) {//NOSONAR
            System.out.println("StringIndexOutOfBoundsException");//NOSONAR
        }//NOSONAR

        //Java code to demonstrate FileNotFoundException
        try {//NOSONAR
            // Following file does not exist
            File file = new File("E://file.txt");//NOSONAR

            FileReader fr = new FileReader(file);//NOSONAR
        } catch (FileNotFoundException e) {//NOSONAR
            System.out.println("File does not exist");//NOSONAR
        }//NOSONAR

        // Java code to demonstrate NumberFormatException
        try {//NOSONAR
            // "akki" is not a number
            int num = Integer.parseInt("akki");//NOSONAR

            System.out.println(num);//NOSONAR
        } catch (NumberFormatException e) {//NOSONAR
            System.out.println("Number format exception");//NOSONAR
        }//NOSONAR

        // Java  to demonstrate ArrayIndexOutOfBoundException
        try {//NOSONAR
            int a[] = new int[5];//NOSONAR
            a[6] = 9; // accessing 7th element in an array of
            // size 5
        } catch (ArrayIndexOutOfBoundsException e) {//NOSONAR
            System.out.println("Array Index is Out Of Bounds");//NOSONAR
        }//NOSONAR

        //nested exception example
        // Main try block
        try {//NOSONAR

            // initializing array
            int a[] = {1, 2, 3, 4, 5};//NOSONAR

            // trying to print element at index 5
            System.out.println(a[5]);//NOSONAR

            // try-block2 inside another try block
            try {//NOSONAR
                // performing division by zero
                int x = a[2] / 0;//NOSONAR
            } catch (ArithmeticException e2) {//NOSONAR
                System.out.println("division by zero is not possible");//NOSONAR
            }//NOSONAR
        } catch (ArrayIndexOutOfBoundsException e1) {//NOSONAR
            System.out.println("ArrayIndexOutOfBoundsException");//NOSONAR
            System.out.println("Element at such index does not exists");//NOSONAR
        }//NOSONAR

        try {//NOSONAR
            // constructor may throw FileNotFoundException
            FileReader reader = new FileReader("someFile");//NOSONAR
            int i = 0;//NOSONAR
            while (i != -1) {//NOSONAR
                //reader.read() may throw IOException
                i = reader.read();//NOSONAR
                System.out.println((char) i);//NOSONAR
            }//NOSONAR
            reader.close();//NOSONAR
            System.out.println("--- File End ---");//NOSONAR
        } catch (FileNotFoundException e) {//NOSONAR
            //do something clever with the exception
        } catch (IOException e) {//NOSONAR
            //do something clever with the exception
        }//NOSONAR

        openFile();//NOSONAR
    }

    public static void openFile() {//NOSONAR
        FileReader reader = null;//NOSONAR
        try {//NOSONAR
            reader = new FileReader("someFile");//NOSONAR
            int i = 0;//NOSONAR
            while (i != -1) {//NOSONAR
                i = reader.read();//NOSONAR
                System.out.println((char) i);//NOSONAR
            }//NOSONAR
        } catch (IOException e) {//NOSONAR
            //do something clever with the exception
        } finally {//NOSONAR
            if (reader != null) {//NOSONAR
                try {//NOSONAR
                    reader.close();//NOSONAR
                } catch (IOException e) {//NOSONAR
                    //do something clever with the exception
                }//NOSONAR
            }//NOSONAR
            System.out.println("--- File End ---");//NOSONAR
        }//NOSONAR
    }//NOSONAR
}
