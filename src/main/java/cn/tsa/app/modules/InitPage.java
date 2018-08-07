package cn.tsa.app.modules;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import cn.tsa.app.pageobjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;

public class InitPage {
	public static AndroidDriver driver=null;
	public static LoginPage execute() throws MalformedURLException, InterruptedException {
		//1.设置capabilities
		DesiredCapabilities capabilites=new DesiredCapabilities();
		capabilites.setCapability("deviceName", "vivo_v3m_a-UOHQP7QKB6WGVGGI");
		capabilites.setCapability("automationName", "Appium");
		capabilites.setCapability("platformName", "Android");
		capabilites.setCapability("platformVersion", "5.1");
		capabilites.setCapability("appPackage", "com.unitrust.tsa");
		capabilites.setCapability("appActivity", "cn.tsa.activity.SplashActivity");
		//2.实例化AndroidDriver对象
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		//3.app被启动后操作引导页
		System.out.println("app启动中，请等待5秒钟...");
		Thread.sleep(5000);
		System.out.println("启动页展示完毕，准备操作引导页");
		driver.swipe(700, 640, 100, 640, 3000);
		driver.swipe(700, 640, 100, 640, 3000);
		driver.swipe(700, 640, 100, 640, 3000);
		driver.swipe(700, 640, 100, 640, 3000);
		//4.点击体验按钮
		driver.findElement(By.id("com.unitrust.tsa:id/btn")).click();
		//5.点击立即领取红包按钮，然后打开app登录页面
		driver.findElement(By.id("com.unitrust.tsa:id/red_envlpoes_btn")).click();
		
		
		return new LoginPage(driver);
	}

}
