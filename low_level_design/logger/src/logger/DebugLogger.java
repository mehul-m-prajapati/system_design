package logger;

public class DebugLogger extends Log {

	DebugLogger(Log nextLogger) {
		super(nextLogger);
	}
	
    public void log_message(int logLevel, String message) {
        
    	if (logLevel == DEBUG)
    		System.out.println("DEBUG: " + message);
    	else
    		super.log_message(logLevel, message);
    }

}
