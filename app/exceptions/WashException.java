package app.exceptions;

/**
 * Allow to generate exception WashException
 */
public class WashException extends Exception{
	
	/**
	 * Generate an exception WashException from Exception
	 */
	public WashException() {
		super();
	}
	
	/**
	 * Generate an exception WashException from Exception with a message
	 * @param message
	 */
	public WashException(String message) {
		super(message);
	}

}
