package com.parkit.parkingsystem.integration.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type Properties reader.
 */
public class PropertiesReader {

	/**
	 * The Db user.
	 */
	public String dbUser = "db.user";
	/**
	 * The Db password.
	 */
	public String dbPassword = "db.password";

	/**
	 * The Value.
	 */
	public String value = null;


	/**
	 * Gets property value.
	 *
	 * @param property the property
	 * @return the property value
	 */
	public String getPropertyValue(String property) {


		try (InputStream input = PropertiesReader.class.getResourceAsStream("config.properties")) {

			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
			}
			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and save it
			value = prop.getProperty(property);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/**
	 * Gets prop values.
	 *
	 * @param property the property
	 * @return the prop values
	 */
	public String getPropValues(String property) {
		Properties prop = new Properties();
		String propFileName = "config.properties";

		try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(propFileName)) {

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			// get the property value and print it out
			value = prop.getProperty(property);

		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return value;
	}

}
