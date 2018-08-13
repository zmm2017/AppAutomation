package cn.tsa.app.pageobjects;

import org.openqa.selenium.WebElement;

import cn.tsa.app.constant.Constant;
import cn.tsa.app.util.ObjectMap;
import io.appium.java_client.android.AndroidDriver;

public class UsageProtocolPage {
	private WebElement element;
	private ObjectMap objectMap=new ObjectMap(Constant.propertyFilePath);
	public AndroidDriver driver;
	
	public UsageProtocolPage(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public  WebElement getBackBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getPageTitle(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}

}
