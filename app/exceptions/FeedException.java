package app.exceptions;

/**
 * Allow to generate exception FeedException
 */
public class FeedException extends Exception{
	
	/**
	 * Generate an exception FeedException from Exception
	 */
	public FeedException() {
		super();
	}
	
	/**
	 * Generate an exception FeedException from Exception with a message
	 * @param message
	 */
	public FeedException(String message) {
		super(message);
	}
}
