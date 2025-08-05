package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtil {
	
	public String propUtil(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData\\Browser edge.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}

}

