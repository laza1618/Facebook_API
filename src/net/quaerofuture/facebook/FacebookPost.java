package net.quaerofuture.facebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Représentation d'un "Post" sur un mur comme le présente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookPost extends FacebookNamedType{
	
	/**
	 * Représentation d'un objet "data" d'un objet "Post" sur un mur comme le présente l'API Graph Facebook
	 * 
	 * @author Herilaza
	 *
	 */
	public class FacebookPostData{
		
		private List<FacebookNamedType> data;
		
		/**
		 * 
		 */
		public FacebookPostData() {
			
		}

		/**
		 * La liste des données "To"
		 * @return La liste des données "To"
		 */
		public List<FacebookNamedType> getData() {
			return data;
		}		
	}
	
	private FacebookCategorizedType from;
	
	private FacebookPostData to;
	
	private String message;
	
	private String picture;
	
	private String link;
	
	private String caption;
	
	private String description;
	
	private String source;
	
	private String icon;
	
	private FacebookPostLikes likes;
	
	private FacebookPostPlace place;
	
	private String story;
	
	@JsonProperty("object_id")
	private Long objectId;
	
	private FacebookNamedType application;
	
	private List<FacebookPostAction> actions;
	
	private String type;
	
	@JsonProperty("created_time")
	private String createdTime;
	
	@JsonProperty("updated_time")
	private String updatedTime;
	
	private FacebookComment comments;
	
	@JsonProperty("is_published")
	private boolean isPublished;
	
	@JsonProperty("with_tags")
	private FacebookPostData withTags;

	/**
	 * 
	 */
	public FacebookPost() {
		
	}

	/**
	 * Informations sur l'utilisateur qui a posté le message
	 * @return Informations sur l'utilisateur qui a posté le message
	 */
	public FacebookCategorizedType getFrom() {
		return from;
	}

	/**
	 * la liste de(s) utilisateur(s) à qui sont destinés le message 
	 * @return la liste de(s) utilisateur(s) à qui sont destinés le message
	 */
	public FacebookPostData getTo() {
		return to;
	}

	/**
	 * Le message
	 * @return Le message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Le liste des actions disponibles à faire sur un post (comment,like)
	 * return Le liste des actions disponibles à faire sur un post
	 */
	public List<FacebookPostAction> getActions() {
		return actions;
	}

	/**
	 * le type du post
	 * @return le type du post
	 */
	public String getType() {
		return type;
	}

	/**
	 * la date de création du post
	 * @return la date de création du post
	 */
	public String getCreatedTime() {
		return createdTime;
	}

	/**
	 * la date de modification du post
	 * @return la date de modification du post
	 */
	public String getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * les informations concernant les commentaires du post
	 * @return les informations concernant les commentaires du post
	 */
	public FacebookComment getComments() {
		return comments;
	}

	/**
	 * Indique si la page est publiée et visible à un non-admin
	 * @return  une variable booléene indiquant si la page est publiée et visible à un non-admin
	 */
	public boolean isPublished() {
		return isPublished;
	}

	/**
	 * un lien vers l'image associé au post si elle est disponible
	 * @return un lien vers l'image associé au post
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * l'URL attaché à ce post
	 * @return l'URL attaché à ce post
	 */
	public String getLink() {
		return link;
	}

	/**
	 * La légende du Lien (link)
	 * @return La légende du Lien (link)
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * La description du lien (link)
	 * @return La description du lien
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * URL vers un film flash ou un video associé au post
	 * @return URL vers un film flash ou un video associé au post
	 */
	public String getSource() {
		return source;
	}

	/**
	 * URL vers l'icon représentant le post
	 * @return URL vers l'icon représentant le post
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * l'historique sur le post (pas nécéssairement écrite par l'utilisateur), comme l'historique d'ajout à la liste d'amis
	 * @return l'historique sur le post 
	 */
	public String getStory() {
		return story;
	}

	/**
	 * l'Id de objet Facebook pour une photo ou une video uploadé
	 * @return l'Id de objet Facebook pour une photo ou une video uploadé
	 */
	public Long getObjectId() {
		return objectId;
	}

	/**
	 * Informatons sur l'application d'où le post vient
	 * @return Informatons sur l'application d'où le post vient
	 */
	public FacebookNamedType getApplication() {
		return application;
	}

	/**
	 * Informations sur le likes d'un post
	 * @return Informations sur le likes d'un post
	 */
	public FacebookPostLikes getLikes() {
		return likes;
	}

	/**
	 * objets(page,utilisateur,..) marqués avec le post
	 * @return les objets marqués avec le post
	 */
	public FacebookPostData getWithTags() {
		return withTags;
	}

	/**
	 * informations de localisation associé à un post
	 * @return informations de localisation associé à un post
	 */
	public FacebookPostPlace getPlace() {
		return place;
	}	
	
	/**
	 * La Date de création du Post
	 * @return la date de création du Post dans un objet de type java.util.Date
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
	 * La Date de dernière modification du post
	 * @return La date de dernière modification du post dans un objet de type java.util.Date
	 */
	public Date getUpDatedTimeAsDate() {
		try {
			return new SimpleDateFormat(FacebookType.DATE_FORMAT).parse(getUpdatedTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
