package net.quaerofuture.facebook;

import java.util.List;

/**
 * Repr�sentation de l'object "classes" de l'objet "education" d'un utilisateur comme le pr�sente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookUserClassess extends FacebookNamedType{
		private List<FacebookNamedType> with;

		/**
		 * 
		 */
		public FacebookUserClassess() {
			
		}

		/**
		 * La liste des personnes qui �taient avec l'utilisateur dans cette classe.
		 * @return La liste des personnes qui �taient avec l'utilisateur dans cette classe.
		 */
		public List<FacebookNamedType> getWith() {
			return with;
		}
				
}
