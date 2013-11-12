package net.quaerofuture.facebook;

import java.util.List;

/**
 * Sp�cifie les m�thodes que doivent impl�menter la classe FacebookGraber pour fonctionner
 * 
 * @author Herilaza
 *
 */
public interface IFacebookGrabber {
	
	/**
	 * Execute une requ�te permettant de r�cup�rer les informations sur une page Facebook
	 * @param pageId l'Identifiant ou le nom permettant d'identifier la page
	 * @return L'�x�cution retourne un objet de type FacebookPage contenant les informations sur la page demand�e.
	 */
	public FacebookPage readPage(String pageId);
	
	/**
	 * Execute une requ�te permettant de r�cup�rer les informations sur un utilisateur Facebook
	 * @param userId l'Identifiant ou le nom permettant d'identifer l'utilisateur
	 * @return L'�x�cution retourne un objet de type FacebookUser contenant les informations sur l'utilisateur demand�.
	 */
	public FacebookUser readUser(String userId);
	
	/**
	 * Excecute une requ�te permettant de r�cuperer la liste des "post" Facebook sur un mur d'une page ou d'un utlisateur
	 * @param id l'Identifiant de l'utilisateur ou de la page Facebook
	 * @param loadallcomments  permettant de savoir si on veut ou non charger toutes les commentaires sur un post, si true, on charge toutes les commentaires, false sinon
	 * @return La liste des "post" du plus r�cents aux plus anciens.
	 */
	public List<FacebookPost> readWall(String id,boolean loadallcomments);
	
	/**
	 * permettant de charger toutes les commentaires d'un post donn�e
	 * @param p Un objet FacebookPost repr�sentant le post sur lequel on veut charger les commentaires
	 */
	public void loadAllComment(FacebookPost p);
}
