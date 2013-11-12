package net.quaerofuture.facebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Représentation de l'object "work" d'un utilisateur comme le présente l'API Graph Facebook
 * 
 * @author Herilaza
 *
 */
public class FacebookUserWork {

		private FacebookNamedType employer;
		
		@JsonProperty("start_date")
		private String startDate;
		
		@JsonProperty("end_date")
		private String endDate;

		/**
		 * 
		 */
		public FacebookUserWork() {
			
		}

		/**
		 * l'employeur de l'utilisateur
		 * @return l'employeur de l'utilisateur
		 */
		public FacebookNamedType getEmployer() {
			return employer;
		}

		/**
		 * Date de début
		 * @return Date de début
		 */
		public String getStartDate() {
			return startDate;
		}
		
		/**
		 * Date de début
		 * @return Date de Début dans un objet de type java.util.date
		 */
		public Date getStartDateAsDate() {
			try {
				return new SimpleDateFormat(FacebookType.DATE_FORMAT).parse(getStartDate());
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

		/**
		 * Date de fin
		 * @return Date de fin
		 */
		public String getEndDate() {
			return endDate;
		}
		
		/**
		 * Date de fin
		 * @return Date de fin dans un objet de type java.util.Date
		 */
		public Date getEndDateAsDate() {
			try {
				return new SimpleDateFormat(FacebookType.DATE_FORMAT).parse(getEndDate());
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		
}
