package exception;

public class MyExceptionForGetStringFromFile extends Exception {

    public MyExceptionForGetStringFromFile(String message) {
        super(message);
    }
    public MyExceptionForGetStringFromFile(String message, Throwable cause) {
        super(message, cause);
    }
}
