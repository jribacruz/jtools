package jtools.commons.exception;

/**
 * 
 * @author jcruz
 *
 */
public class InvalidProjectTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidProjectTypeException() {
		super();
	}

	public InvalidProjectTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidProjectTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidProjectTypeException(String message) {
		super(message);
	}

	public InvalidProjectTypeException(Throwable cause) {
		super(cause);
	}

}
