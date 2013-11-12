package net.quaerofuture.facebook;

/**
 * Classe mère qui inclut un champ category commune pour de nombreux objet de l'API Graph facebook
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
	 * la catégorie de l'objet
	 * @return la catégorie de l'objet
	 */
	public String getCategory() {
		return category;
	}
	
}
