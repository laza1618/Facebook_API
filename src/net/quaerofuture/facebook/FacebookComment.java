package net.quaerofuture.facebook;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Cette classe représente  un objet "comments" d'un "Post" sur un mur comme le présente l'API Graph Facebook 
 * 
 * @author Herilaza
 *
 */
public class FacebookComment extends FacebookType{
	
	@JsonProperty("data")
	private List<FacebookCommentItem> data;
	
	private int count;
	
	/**
	 * 
	 */
	public FacebookComment() {
	
	}

	/**
	 * la liste des informations dur les commentaires sur un post (l'auteur du commentaire, le commentaire, le nombre de likes)
	 * @return la liste des informations dur les commentaires sur un post
	 */
	public List<FacebookCommentItem> getData() {
		return data;
	}


	/**
	 * le nombre de commentaire
	 * @return le nombre de commentaire
	 */
	public int getCount() {
		return count;
	}

	public void setData(List<FacebookCommentItem> data) {
		this.data = data;
	}	

}
