package net.quaerofuture.facebook;

/**
 * Cette classe est la classe mère de toute les exceptions de cette Library Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2155960940453969179L;
	
	
	public FacebookException() {
		super("erreur inconnu");
	}

	public FacebookException(String message) {
		super(message);
	}
	
	
}
