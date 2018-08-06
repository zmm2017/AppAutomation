package cn.tsa.app.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties property;
	
	public ObjectMap(String propertyFilePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public By getLocator(String elementNameInPropertyFile) throws Exception {
		String locator=property.getProperty(elementNameInPropertyFile);
		String locatorType=locator.split(">")[0];
		String locatorValue=locator.split(">")[1];
		locatorValue=new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
		By by=null;
		switch(locatorType.toLowerCase()) {
		case "id":
			by=By.id(locatorValue);
			break;
		case "name":
			by=By.name(locatorValue);
			break;
		case "classname":
			by=By.className(locatorValue);
			break;
		default:
			throw new Exception("输入的locator type未在程序中被定义："+locatorType);
		}
			
		return by;
	}

}
