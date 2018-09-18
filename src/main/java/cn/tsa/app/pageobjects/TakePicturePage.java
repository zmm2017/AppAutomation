package cn.tsa.app.pageobjects;

import org.openqa.selenium.WebElement;

import cn.tsa.app.constant.Constant;
import cn.tsa.app.util.ObjectMap;
import io.appium.java_client.android.AndroidDriver;

public class TakePicturePage {
	private WebElement element=null;
	private ObjectMap objectMap=new ObjectMap(Constant.propertyFilePath);
	public AndroidDriver driver;
	
	public TakePicturePage(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getTakePictureBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getBackBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}

}
