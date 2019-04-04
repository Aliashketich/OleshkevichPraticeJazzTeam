package chainOfResponsibility;

public abstract class Logger {
    int level;
    private String messageToLog = "";
    private Logger nextLogger;

    void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void nextLogger(int priority, String message) {
        if (priority <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.nextLogger(priority, message);
        }
    }

    abstract protected void write(String message);

    public String getMessageToLog() {
        return messageToLog;
    }

    public void setMessageToLog(String messageToLog) {
        this.messageToLog += messageToLog;
    }
}
