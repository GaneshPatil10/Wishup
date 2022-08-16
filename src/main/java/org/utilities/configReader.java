package org.utilities;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
	public String getTestData(String Key) {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/org/config/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(Key);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}

