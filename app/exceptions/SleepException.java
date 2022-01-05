package app.exceptions;

/**
 * Allow to generate exception SleepException
 */
public class SleepException extends Exception{
	
	/**
	 * Generate an exception SleepException from Exception
	 */
	public SleepException() {
		super();
	}
	
	/**
	 * Generate an exception SleepException from Exception with a message
	 * @param message
	 */
	public SleepException(String message) {
		super(message);
	}
}
