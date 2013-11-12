package net.quaerofuture.facebook;

/**
 * Cette classe repr�sente  un objet "place" d'un "Post" sur un mur comme le pr�sente l'API Graph Facebook 
 * 
 * @author Herilaza
 *
 */
public class FacebookPostPlace extends FacebookNamedType {

	private FacebookLocation location;

	/**
	 * 
	 */
	public FacebookPostPlace() {
		
	}

	/**
	 * Informations sur la localisation
	 * @return Informations sur la localisation
	 */
	public FacebookLocation getLocation() {
		return location;
	}
	
	
}
