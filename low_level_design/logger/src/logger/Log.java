package logger;

public abstract class Log {
	
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    Log nextLogger;
    
    Log(Log logger) {
    	this.nextLogger = logger;
    }
    
    public void log_message(int logLevel, String message) {
    	
    	if (nextLogger != null)
    		nextLogger.log_message(logLevel, message);
    }

}
