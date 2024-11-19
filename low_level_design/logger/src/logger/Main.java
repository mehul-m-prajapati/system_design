package logger;

public class Main {
	
	public static void main(String args[]) {
		
		System.out.println("workig");
		
		Log logObj = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
		
		logObj.log_message(Log.DEBUG, "This is debug");
		logObj.log_message(Log.ERROR, "This is error");
		logObj.log_message(Log.INFO, "This is info");
		
	}

}
