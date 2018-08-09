package cn.tsa.app.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class CloseKeyBoard {
	public static void execute(AndroidDriver driver) {
		TouchAction action=new TouchAction(driver);
		int x=driver.manage().window().getSize().width;
		
		action.tap(x*3/4, 340).perform();
	}

}
