package chainofresponsibility;

public class ErrorLogger extends Logger {
    ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        setMessageToLog("ERROR " + message);
    }
}