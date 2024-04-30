package pe.edu.ulasalle.utest.utils;

import java.io.IOException; 
import java.io.InputStream;
import java.util.Properties;

public class ReaderProperties {

	public String readProp(String propFile, String propiedad) {
		Properties prop = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFile);
		if (inputStream != null) {
			try {
				prop.load(inputStream);
			} catch (IOException e) {
				throw new RuntimeException("property file '" + propFile + "' no cargado");
			}
		} else {
			throw new RuntimeException("property file '" + propFile + "' no encontrado");
		}
		return prop.getProperty(propiedad);
	}
	
	public String replacePropVal(String propFile, String propiedad, String value) {
		System.out.println("not yet implemented replacePropVal");
		return null;
	}
}
