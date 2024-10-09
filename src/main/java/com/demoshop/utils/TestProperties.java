package com.demoshop.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	
public static Properties getProperties() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\DemoWebShopFW\\src\\main\\resources\\Config\\config.properties");
		prop.load(fis);
		return prop;
		
	}
}
