package net.quaerofuture.facebook;

/**
 * Cette classe représente  un objet "place" d'un "Post" sur un mur comme le présente l'API Graph Facebook 
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
