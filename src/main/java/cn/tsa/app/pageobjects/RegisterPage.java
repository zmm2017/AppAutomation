package cn.tsa.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.tsa.app.constant.Constant;
import cn.tsa.app.util.ObjectMap;

public class RegisterPage {
	private WebElement element;
	private ObjectMap objectMap=new ObjectMap(Constant.propertyFilePath);
	public WebDriver driver=null;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPageTitle(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRegisterPhone(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRegisterCodeBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRegisterCodeText(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRegisterPwd(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRegisterRepwd(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRegisterNum(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getProtocolCheckBox(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getUsageProtocolLink(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getPrivacyProtocolLink(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getRegisterBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}

}
