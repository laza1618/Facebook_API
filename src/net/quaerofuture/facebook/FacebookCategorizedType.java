package net.quaerofuture.facebook;

/**
 * Classe m�re qui inclut un champ category commune pour de nombreux objet de l'API Graph facebook
 *  
 * @author Herilaza
 *
 */
public class FacebookCategorizedType extends FacebookNamedType {
	
	private String category;

	/**
	 * 
	 */
	public FacebookCategorizedType() {
		
	}

	/**
	 * la cat�gorie de l'objet
	 * @return la cat�gorie de l'objet
	 */
	public String getCategory() {
		return category;
	}
	
}
