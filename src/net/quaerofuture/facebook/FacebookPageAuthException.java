package net.quaerofuture.facebook;

/**
 * Cette classe indique que le chargement de le page d'authentification de l'application Facebook a �chou� d�e � une erreur sur l'ID de l'application ou que Facebook ne reconnait pas la liste des permissions de l'application propos�s
 * Si cette exception se d�clenhe, il faut v�rifier que l'ID de l'application Facebook est bien Valide ou que la liste des permissions propos�s existent bien. 
 * 
 * @author Herilaza
 *
 */
public class FacebookPageAuthException extends FacebookException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1246989250813143068L;

	public FacebookPageAuthException(String message) {
		super(message);
	}

	
}
