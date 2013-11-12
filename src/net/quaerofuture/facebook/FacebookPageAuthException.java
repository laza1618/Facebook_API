package net.quaerofuture.facebook;

/**
 * Cette classe indique que le chargement de le page d'authentification de l'application Facebook a échoué dûe à une erreur sur l'ID de l'application ou que Facebook ne reconnait pas la liste des permissions de l'application proposés
 * Si cette exception se déclenhe, il faut vérifier que l'ID de l'application Facebook est bien Valide ou que la liste des permissions proposés existent bien. 
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
