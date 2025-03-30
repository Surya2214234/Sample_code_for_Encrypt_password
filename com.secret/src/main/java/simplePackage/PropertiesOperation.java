package simplePackage;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperation {

	static Properties prop = new Properties();
	
	public static String getPropertyValuebyKey(String key) throws Exception {

		String propFilepath = "./src/main/java/testdata/Config.properties";
		FileInputStream Fis = new FileInputStream(propFilepath);
		prop.load(Fis);
		String value = prop.get(key).toString();

		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value is not specified" + key + "Classname: PropertiesOperation_File");
		}
		return value;
	}
}
