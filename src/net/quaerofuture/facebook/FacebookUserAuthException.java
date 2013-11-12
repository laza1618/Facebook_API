package net.quaerofuture.facebook;


/**
 * Cette classe indique que l'authentification � l'Application Facebook a �chou� d�e � une �rreur sur le login ou le mot de passe de l'utilisateur
 * Si cette exception de produit, il faut v�rifier le login et le mot de passe de l'utilisateur sur Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookUserAuthException extends FacebookException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5500150035841356095L;

	public FacebookUserAuthException(String message) {
		super(message);
	}
	
	

}
