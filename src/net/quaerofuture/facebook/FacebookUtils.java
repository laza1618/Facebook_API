package net.quaerofuture.facebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe utilitaire
 * 
 * @author Herilaza
 *
 */
public class FacebookUtils {

	/**
	 * cette méthode charge un fichier properties en mémoire
	 * 
	 * @param fname chemin menant vers le fichier .properties
	 * @return un objet properties
	 */
	public static Properties Propertyload(String fname) {
		Properties prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(fname);
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
