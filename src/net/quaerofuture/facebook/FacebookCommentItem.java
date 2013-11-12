package net.quaerofuture.facebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * cette classe représente  Représentation d'un objet "data" d'un objet "comments" d'un "Post" sur un mur comme le présente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookCommentItem extends FacebookType {
	
	private FacebookCategorizedType from; 
	
	private String message;
	
	@JsonProperty("created_time")
	private String createdTime;
	
	private int likes;

	/**
	 * 
	 */
	public FacebookCommentItem() {
		
	}

	/**
	 * Informations sur celui qui a écrit le commentaire
	 * @return Informations sur celui qui a écrit le commentaire
	 */
	public FacebookCategorizedType getFrom() {
		return from;
	}

	/**
	 * le commentaire
	 * @return le commentaire
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * la date du commentaire
	 * @return la date du commentaire
	 */
	public String getCreatedTime() {
		return createdTime;
	}
	
	/**
	 * la date du commentaire
	 * @return la date du commentaire dans un objet de type java.util.Date
	 */
	public Date getCreatedTimeAsDate() {
		try {
			return new SimpleDateFormat(FacebookType.DATE_FORMAT).parse(getCreatedTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * le nombre de likes du commentaire
	 * @return le nombre de likes du commentaire
	 */
	public int getLikes() {
		return likes;
	}
}
