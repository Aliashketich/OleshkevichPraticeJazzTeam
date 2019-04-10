package chainofresponsibility;

class LoggerType {
    private LoggerType() {
        throw new IllegalStateException("Utility class");
    }
    static final int INFO = 1; //NOSONAR
    static final int ERROR = 2;//NOSONAR
    static final int DEBUG = 3;//NOSONAR
}