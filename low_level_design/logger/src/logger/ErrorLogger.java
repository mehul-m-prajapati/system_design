package logger;

public class ErrorLogger extends Log {

	ErrorLogger(Log nextLogger) {
		super(nextLogger);
	}
	
    public void log_message(int logLevel, String message) {
        
    	if (logLevel == ERROR)
    		System.out.println("ERROR: " + message);
    	else
    		super.log_message(logLevel, message);
    }

}
