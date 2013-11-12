package net.quaerofuture.facebook;


/**
 * Classe de Base qui encapsule une propriété commune aux objets de l'API graphe Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookType {
	
	protected String id;
	
	protected static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

	/**
	 * 
	 */
	protected FacebookType() {
		
	}


	/**
	 * l'Id d'un objet
	 * @return l'Id d'un objet
	 */
	public String getId() {
		return id;
	}
	
	

}
