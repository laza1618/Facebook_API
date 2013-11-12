package net.quaerofuture.facebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Représentation d'un profil Utilisateur comme le présente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookUser extends FacebookNamedType {
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("middle_name")
	private String middelName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	private String gender;
	
	private String locale;
	
	private List<FacebookNamedType> languages;
	
	private String link;
	
	private String username;
	
	private Double timezone;
	
	@JsonProperty("updated_time")
	private String updatedTime;
	
	private String bio;
	
	private String about;
	
	private String birthday;
	
	private List<FacebookUserEducation> education;
	
	private String email;
	
	private FacebookNamedType hometown;
	
	@JsonProperty("interested_in")
	private List<String> interstedIn;
	
	private FacebookNamedType location;
	
	private String political;
	
	@JsonProperty("favorite_athletes")
	private List<FacebookNamedType> favoriteAthletes;
	
	@JsonProperty("favorite_teams")
	private List<FacebookNamedType> favoriteTeams;
	
	private String quotes;
	
	@JsonProperty("relationship_status")
	private String relationshipStatus;
	
	private String religion;
	
	@JsonProperty("significant_other")
	private FacebookNamedType significantOther;
	
	private String website;
	
	private boolean verified;
	
	private List<FacebookUserWork> work;
	
	/**
	 * 
	 */
	public FacebookUser() {

	}

	/**
	 * Le prénom de l'utilisateur
	 * @return Le prénom de l'utilisateur
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Le deuxième prénom de l'utilisateur
	 * @return Le deuxième prénom de l'utilisateur 
	 */
	public String getMiddelName() {
		return middelName;
	}

	/**
	 * Le nom de famille de l'utilisateur
	 * @return Le nom de famille de l'utilisateur
	 */
	public String getLastName() {
		return lastName;
	}

	/** 
	 * Le sexe de l'utilisateur (Homme ou Femme)
	 * @return Le sexe de l'utilisateur 
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * The user's locale
	 * @return string containing the ISO Language Code and ISO Country Code
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Les langues de l'utilisateur
	 * @return la liste des langues de l'utilisateur
	 */
	public List<FacebookNamedType> getLanguages() {
		return languages;
	}

	/**
	 * L'URL du profil de l'utilisteur sur Facecebook
	 * @return L'URL du profil de l'utilisteur sur Facecebook
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Le Pseudo de l'utilisateur sur facebook
	 * @return Le Pseudo de l'utilisateur sur facebook
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Le Fuseau Horaire de l'utilisateur en décalage par rapport à l'UTC
	 * @return Le Fuseau Horaire de l'utilisateur en décalage par rapport à l'UTC
	 */
	public Double getTimezone() {
		return timezone;
	}

	/**
	 * La Biographie de l'utilisateur
	 * @return La Biographie de l'utilisateur
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * La Date d'anniversaire de l'utilisateur
	 * @return une chaine contenant la Date d'anniversaire de l'utilisateur
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Un contact e-mail accordé par l'utilisateur
	 * @return une chaine de caractère contenant le mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * la ville natale de l'utilsateur
	 * @return la ville natale de l'utilsateur 
	 */
	public FacebookNamedType getHometown() {
		return hometown;
	}

	/**
	 * La liste des interêts de l'utilisateur
	 * @return La liste des interêts de l'utilisateur
	 */
	public List<String> getInterstedIn() {
		return interstedIn;
	}

	/**
	 * La ville actuelle de l'utilsateur
	 * @return La ville actuelle de l'utilsateur
	 */
	public FacebookNamedType getLocation() {
		return location;
	}

	/**
	 * Opinion politique de l'utilsateur
	 * @return Opinion politique de l'utilsateur
	 */
	public String getPolitical() {
		return political;
	}

	/**
	 * La liste des athlètes préférés de l'utilsateur
	 * @return La liste des athlètes préférés de l'utilsateur
	 */
	public List<FacebookNamedType> getFavoriteAthletes() {
		return favoriteAthletes;
	}

	/**
	 * La liste des équipes préférées de l'utilsateur
	 * @return La liste des équipes préférées de l'utilsateur
	 */
	public List<FacebookNamedType> getFavoriteTeams() {
		return favoriteTeams;
	}

	/**
	 * La citation favorite de l'utilsateur
	 * @return La citation favorite de l'utilsateur 
	 */
	public String getQuotes() {
		return quotes;
	}

	/**
	 * Statut du relation de l'utilsateur (célibataire, en coupple, etc ....)
	 * @return le statu du relation de l'utilisateur
	 */
	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	/**
	 * la religion de l'utilsateur
	 * @return la religion de l'utilsateur
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * The user's significant other
	 * @return The user's significant other
	 */
	public FacebookNamedType getSignificantOther() {
		return significantOther;
	}

	/**
	 * L'URL du site web personnel de l'utilisateur
	 * @return L'URL du site web personnel de l'utilisateur
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * La Liste des études éffectués par l'utilsateur
	 * return La Liste des études éffectués par l'utilsateur
	 */
	public List<FacebookUserEducation> getEducation() {
		return education;
	}

	/**
	 * Statut de vérification du compte de l'utilisateur
	 * return Statut de vérification du compte de l'utilisateur
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * A propos de l'utilisateur
	 * @return A propos de l'utilisateur
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * La liste des emplois de l'utilisateur
	 * @return La liste des emplois de l'utilisateur
	 */
	public List<FacebookUserWork> getWork() {
		return work;
	}

	/**
	 * La date de dernière modification du profil utilisateur
	 *  @return La date de dernière modification du profil utilisateur
	 */
	public String getUpdatedTime() {
		return updatedTime;
	}
	
	/**
	 * La date de dernière modification du profil utilsateur
	 * @return La date de dernière modification du profil utilsateur dans un objet de type java.util.Date
	 */
	public Date getUpdatedTimeAsDate() {
		try {
			return new SimpleDateFormat(FacebookType.DATE_FORMAT).parse(getUpdatedTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
