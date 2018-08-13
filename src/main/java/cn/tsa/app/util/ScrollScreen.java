package cn.tsa.app.util;

import io.appium.java_client.android.AndroidDriver;

public class ScrollScreen {
	public static void execute(AndroidDriver driver,String direction) {
		int x=driver.manage().window().getSize().width;
		int y=driver.manage().window().getSize().height;
		if(direction.equals("x")) {
			driver.swipe(x/4, y/2, 3*x/4, y/2, 2000);
		}else if(direction.equals("-x")) {
			driver.swipe(3*x/4, y/2, x/4, y/2, 2000);
		}else if(direction.equals("y")) {
			driver.swipe(3*x/4, 3*y/4, 3*x/4, y/4, 2000);
		}else {
			System.out.println("方向输入错误，x代表从左到右，-x代表从右到左，y代表从下往上。");
			ScrollScreen.execute(driver, direction);
		}
	}

}
