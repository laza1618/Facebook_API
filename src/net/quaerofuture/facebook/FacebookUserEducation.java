package net.quaerofuture.facebook;

import java.util.List;

/**
 * 
 * Représentation de l'object "education" d'un utilisateur comme le présente l'API Graph Facebook
 * @author Herilaza
 *
 */
public class FacebookUserEducation {

	private FacebookNamedType school;
	
	private List<FacebookNamedType> concentration;
	
	private FacebookNamedType year;
	
	private FacebookUserClassess classes;
	
	private String type;
	
	private List<FacebookNamedType> with;

	/**
	 * 
	 */
	public FacebookUserEducation() {
		
	}

	/**
	 * l'Ecole fréquenté par l'utilisateur
	 * @return l'Ecole fréquenté par l'utilisateur
	 */
	public FacebookNamedType getSchool() {
		return school;
	}

	/**
	 * Type de formation suivi par l'utilisateur
	 * @return Type de formation suivi par l'utilisateur
	 */
	public String getType() {
		return type;
	}

	/**
	 * Les filières de formation suivis par l'utilisateur
	 * @return Les filières de formation suivis par l'utilisateu
	 */
	public List<FacebookNamedType> getConcentration() {
		return concentration;
	}

	/**
	 * La classe de l'utilisateur
	 * @return La classe de l'utilisateur
	 */
	public FacebookUserClassess getClasses() {
		return classes;
	}

	/**
	 * l'annéee d'étude
	 * @return l'annéee d'étude
	 */
	public FacebookNamedType getYear() {
		return year;
	}

	/**
	 * La liste des personnes qui étaient avec l'utilisateur dans cet école 
	 * @return La liste des personnes qui étaient avec l'utilisateur dans cet école
	 */
	public List<FacebookNamedType> getWith() {
		return with;
	}
	
	
	
}
