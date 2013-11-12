package net.quaerofuture.facebook;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Représentation de l'objet "cover" d'une page comme le présente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookCover {
	
	@JsonProperty("cover_id")
	private String coverId;
	
	private String source;
	
	@JsonProperty("offset_y")
	private Double offsetY;

	/**
	 * 
	 */
	public FacebookCover() {
		
	}

	/**
	 * Id de la photo
	 * @return Id de la photo
	 */
	public String getCoverId() {
		return coverId;
	}

	/**
	 * URL de la photo de courverture
	 * @return URL de la photo de courverture
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Offset Y
	 * @return Offset Y
	 */
	public Double getOffsetY() {
		return offsetY;
	}

}
