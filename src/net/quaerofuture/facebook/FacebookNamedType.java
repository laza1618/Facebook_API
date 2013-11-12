package net.quaerofuture.facebook;

/**
 * Classe mère qui inclut un champ name commune pour de nombreux objet de l'API Graph facebook 
 * 
 * @author Herilaza
 *
 */
public class FacebookNamedType extends FacebookType {

		protected String name;

		/**
		 * 
		 */
		protected FacebookNamedType() {
			
		}

		/**
		 * Le nom de l'objet
		 * @return Le nom de l'objet
		 */
		public String getName() {
			return name;
		}		
		
}
