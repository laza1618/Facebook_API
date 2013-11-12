package net.quaerofuture.facebook;

import java.util.List;

/**
 * Spécifie les méthodes que doivent implémenter la classe FacebookGraber pour fonctionner
 * 
 * @author Herilaza
 *
 */
public interface IFacebookGrabber {
	
	/**
	 * Execute une requête permettant de récupérer les informations sur une page Facebook
	 * @param pageId l'Identifiant ou le nom permettant d'identifier la page
	 * @return L'éxécution retourne un objet de type FacebookPage contenant les informations sur la page demandée.
	 */
	public FacebookPage readPage(String pageId);
	
	/**
	 * Execute une requête permettant de récupérer les informations sur un utilisateur Facebook
	 * @param userId l'Identifiant ou le nom permettant d'identifer l'utilisateur
	 * @return L'éxécution retourne un objet de type FacebookUser contenant les informations sur l'utilisateur demandé.
	 */
	public FacebookUser readUser(String userId);
	
	/**
	 * Excecute une requête permettant de récuperer la liste des "post" Facebook sur un mur d'une page ou d'un utlisateur
	 * @param id l'Identifiant de l'utilisateur ou de la page Facebook
	 * @param loadallcomments  permettant de savoir si on veut ou non charger toutes les commentaires sur un post, si true, on charge toutes les commentaires, false sinon
	 * @return La liste des "post" du plus récents aux plus anciens.
	 */
	public List<FacebookPost> readWall(String id,boolean loadallcomments);
	
	/**
	 * permettant de charger toutes les commentaires d'un post donnée
	 * @param p Un objet FacebookPost représentant le post sur lequel on veut charger les commentaires
	 */
	public void loadAllComment(FacebookPost p);
}
