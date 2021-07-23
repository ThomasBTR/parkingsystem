package com.parkit.parkingsystem.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.out;

/**
 * The type Properties reader.
 */
public class PropertiesReader {

	/**
	 * The constant DB_USER.
	 */
	public static final String DB_USER = "db.user";
	/**
	 * The constant DB_PASSWORD.
	 */
	public static final String DB_PASSWORD = "db.password";

	/**
	 * Gets prop values.
	 *
	 * @param property the property
	 * @return the prop values
	 */
	public String getPropValues(String property) {
		Properties prop = new Properties();
		String propFileName = "src/main/resources/config.properties";

		String value;

		try (InputStream inputStream = new FileInputStream(propFileName)) {
			prop.load(inputStream);

			// get the property value and print it out
			value = prop.getProperty(property);
			return value;

		} catch (IOException ioException) {
			ioException.printStackTrace();
			return null;
		} catch (Exception e) {
			out.println("Exception: " + e);
			return null;
		}
	}
}
