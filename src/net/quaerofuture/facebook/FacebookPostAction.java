package net.quaerofuture.facebook;

/**
 * Cette classe repr�sente  un objet "actions" d'un "Post" sur un mur comme le pr�sente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookPostAction {
	
	private String name;
	private String link;
	
	/**
	 * 
	 */
	public FacebookPostAction() {
		
	}

	/**
	 * le nom de l'action
	 * @return le nom de l'action
	 */
	public String getName() {
		return name;
	}

	/**
	 * le lien menant vers l'action
	 * @return le lien menant vers l'action
	 */
	public String getLink() {
		return link;
	}

}
