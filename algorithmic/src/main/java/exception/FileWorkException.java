package exception;

public class FileWorkException extends Exception {

    public FileWorkException(String message) {
        super(message);
    }
    public FileWorkException(String message, Throwable cause) {
        super(message, cause);
    }
}
