package net.quaerofuture.facebook;

/**
 * Cette classe repr�sente un objet "location" donn�e en r�sultat de certaines requ�tes comme le pr�sente l'API Graph facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookLocation {

		private String street;
		private String city;
		private String country;
		private String zip;
		private Double longitude;
		private Double latitude;
		
		/**
		 * 
		 */
		public FacebookLocation() {
			
		}
		/**
		 * la rue
		 * @return la rue
		 */
		public String getStreet() {
			return street;
		}
		/**
		 * la ville
		 * @return la ville
		 */
		public String getCity() {
			return city;
		}
		/**
		 * le pays
		 * @return le pays
		 */
		public String getCountry() {
			return country;
		}
		/**
		 * le code postal
		 * @return le code postal
		 */
		public String getZip() {
			return zip;
		}
		/**
		 * la longitude
		 * return la longitude
		 */
		public Double getLongitude() {
			return longitude;
		}
		/**
		 * la latitude
		 * @return la latitude
		 */
		public Double getLatitude() {
			return latitude;
		}
		
		
}
