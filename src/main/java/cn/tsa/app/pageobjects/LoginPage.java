package cn.tsa.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.tsa.app.constant.Constant;
import cn.tsa.app.util.ObjectMap;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	public WebElement element=null;
	public ObjectMap objectMap=new ObjectMap(Constant.propertyFilePath);
	public AndroidDriver driver=null;
	
	public LoginPage(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getLoginPhone(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getLoginPwd(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getLoginBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRememberPwd(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getGoToRegister(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getFindPwd(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}

}
