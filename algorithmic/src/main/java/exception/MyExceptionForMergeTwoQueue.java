package exception;

public class MyExceptionForMergeTwoQueue extends Exception {
    private MyExceptionForMergeTwoQueue(String message) {
        super(message);
    }

    public MyExceptionForMergeTwoQueue(String message, Throwable cause) {
        super(message, cause);
    }

}
