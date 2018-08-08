package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/*
 * This class is responsible for loading properties File. In current case this is loading the error.properties
 * which contain error messages for error codes used in the project. But we can extend it to load any property file
 * required in the project.
 */
public class PropertiesUtil {

	private static Properties props;

	static {
		props = new Properties();
		try {
			PropertiesUtil util = new PropertiesUtil();
			props = util.getPropertiesFromClasspath("././com/constants/errorMessage.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Property file  not found in the classpath- " + e);
		} catch (IOException e) {
			System.out.println("Exception occuered while reading the file- " + e);
		}
	}

	// private constructor
	private PropertiesUtil() {
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static Set<Object> getkeys() {
		return props.keySet();
	}

	public static Properties getProperties() {
		return props;
	}

	/**
	 * loads properties file from classpath
	 *
	 * @param propFileName
	 * @return
	 * @throws IOException
	 */
	private Properties getPropertiesFromClasspath(String propFileName) throws IOException {
		Properties props = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream == null) {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			props.load(inputStream);
		} finally {
			inputStream.close();
		}
		return props;
	}

}