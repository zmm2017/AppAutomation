package cn.tsa.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.tsa.app.constant.Constant;
import cn.tsa.app.util.ObjectMap;
import io.appium.java_client.android.AndroidDriver;

public class ObtainEvidence {
	private WebElement element=null;
	private ObjectMap objectMap=new ObjectMap(Constant.propertyFilePath);
	public AndroidDriver driver=null;
	
	public ObtainEvidence(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public WebElement cameraObtainEvidence(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement videoObtainEvidence(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement radioObtainEvidence(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement htmlObtainEvidence(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement timeStampVerify(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}

}
