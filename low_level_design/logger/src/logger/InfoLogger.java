package logger;

public class InfoLogger extends Log {

	InfoLogger(Log nextLogger) {
		super(nextLogger);
	}
	
    public void log_message(int logLevel, String message) {
    
    	if (logLevel == INFO)
    		System.out.println("INFO: " + message);
    	else
    		super.log_message(logLevel, message);
    }

}
