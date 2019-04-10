package chainofresponsibility;

class DebugLogger extends Logger{
    DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        setMessageToLog("DEBUG " + message);
    }
}
