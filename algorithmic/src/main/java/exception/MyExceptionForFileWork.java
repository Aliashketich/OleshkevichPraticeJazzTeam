package exception;

public class MyExceptionForFileWork extends Exception {

    public MyExceptionForFileWork(String message) {
        super(message);
    }

    public MyExceptionForFileWork(String message, Throwable cause) {
        super(message, cause);
    }
}
