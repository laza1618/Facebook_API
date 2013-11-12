package net.quaerofuture.facebook;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Repr�sentation d'une Page comme le pr�sente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookPage extends FacebookCategorizedType{
	
	private String link;
	
	private String category;
	
	
	@JsonProperty("is_published")
	private boolean isPublished;
	
	@JsonProperty("can_post")
	private boolean canPost;
	
	private long likes;
	
	private FacebookLocation location;
	
	private String phone;
	private int checkins;
	private String picture;
    
	private FacebookCover cover;
	
	private String website;
	
	@JsonProperty("talking_about_count")
	private Long talkinAboutCount;
	
	@JsonProperty("access_token")
	private String access_token;

	/**
	 * 
	 */
	public FacebookPage() {
		
	}

	/**
	 * L'URL de la page sur Facebook
	 * @return L'URL de la page sur Facebook
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Indique si la page est publi�e et visible � un non-admin
	 * @return  une variable bool�ene indiquant si la page est publi�e et visible � un non-admin
	 */
	public boolean isPublished() {
		return isPublished;
	}

	/**
	 * Indique si l'utilisateur connect� peut publier sur la page
	 * @return un variable bool��ne indiquant si l'utilisateur connect� peut publier sur la page
	 */
	public boolean isCanPost() {
		return canPost;
	}

	/**
	 * le nombre d'utilisateur qui aime la page
	 * @return le nombre d'utilisateur qui aime la page
	 */
	public long getLikes() {
		return likes;
	}

	/**
	 * les informations de localisation de la page (adress,street,country,zip,city,latitude,longitude)
	 * @return les informations de localisation de la page
	 */
	public FacebookLocation getLocation() {
		return location;
	}

	/**
	 * Le t�l�phone de la page
	 * @return Le t�l�phone de la page
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * The total number of users who have checked in to the Page
	 * @return The total number of users who have checked in to the Page
	 */
	public int getCheckins() {
		return checkins;
	}

	/**
	 * Le lien vers la photo de profil de la page
	 * @return Le lien vers la photo de profil de la page
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * Les informations sur la photo de courverture de la page
	 * @return Les informations sur la photo de courverture de la page
	 */
	public FacebookCover getCover() {
		return cover;
	}

	/**
	 * Lien vers le site web externe de la page
	 * @return Lien vers le site web externe de la page
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * The number of people that are talking about this page (last seven days)
	 * @return The number of people that are talking about this page (last seven days)
	 */
	public Long getTalkinAboutCount() {
		return talkinAboutCount;
	}

	/**
	 * l'access_token permettant l'administration de la page (requiert la permission 'manage_pages')
	 * @return l'access_token permettant l'administration de la page
	 */
	public String getAccess_token() {
		return access_token;
	}

	/* (non-Javadoc)
	 * @see net.quaerofuture.facebook.FacebookCategorizedType#getCategory()
	 */
	public String getCategory() {
		return category;
	}

}
