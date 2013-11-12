package net.quaerofuture.facebook;

import java.util.List;

/**
 * 
 * Repr�sentation de l'object "education" d'un utilisateur comme le pr�sente l'API Graph Facebook
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
	 * l'Ecole fr�quent� par l'utilisateur
	 * @return l'Ecole fr�quent� par l'utilisateur
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
	 * Les fili�res de formation suivis par l'utilisateur
	 * @return Les fili�res de formation suivis par l'utilisateu
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
	 * l'ann�ee d'�tude
	 * @return l'ann�ee d'�tude
	 */
	public FacebookNamedType getYear() {
		return year;
	}

	/**
	 * La liste des personnes qui �taient avec l'utilisateur dans cet �cole 
	 * @return La liste des personnes qui �taient avec l'utilisateur dans cet �cole
	 */
	public List<FacebookNamedType> getWith() {
		return with;
	}
	
	
	
}
