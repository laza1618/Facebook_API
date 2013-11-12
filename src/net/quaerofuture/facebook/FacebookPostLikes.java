package net.quaerofuture.facebook;

import java.util.List;

/**
 * Cette classe représente  un objet "likes" d'un "Post" sur un mur comme le présente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookPostLikes {

	private List<FacebookNamedType> data;
	
	private int count;

	/**
	 * 
	 */
	public FacebookPostLikes() {
		
	}

	/**
	 * les informations sur les utilisateurs qui ont aimés le post
	 * @return les informations sur les utilisateurs qui ont aimés le post
	 */
	public List<FacebookNamedType> getData() {
		return data;
	}

	/**
	 * le nombre de likes du post
	 * @return le nombre de likes du post
	 */
	public int getCount() {
		return count;
	}
	
}
