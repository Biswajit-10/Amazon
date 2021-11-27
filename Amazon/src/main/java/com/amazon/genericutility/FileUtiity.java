package com.amazon.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Raj
 *
 */
public class FileUtiity {
/**
 * 
 * @param key
 * @return String
 * @throws IOException
 */
public String getPropertyKeyValue(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("./common_data.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String value=pObj.getProperty(key);
		return value;
		

	}
}
