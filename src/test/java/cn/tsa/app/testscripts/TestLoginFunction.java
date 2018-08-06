package cn.tsa.app.testscripts;

import org.testng.annotations.Test;

import cn.tsa.app.modules.LoginSystem;
import cn.tsa.app.pageobjects.LoginPage;
import cn.tsa.app.pageobjects.ObtainEvidence;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestLoginFunction {
	DesiredCapabilities capabilites = new DesiredCapabilities();
	AndroidDriver driver=null;
	Boolean result=null;
	LoginPage loginPage=null;

	//输入错误的用户名和密码
  @Test(priority=0)
  public void loginWithWrongPwd() throws Exception {
	  System.out.println("*************开始执行第1条用例，使用错误的密码登录***********************");
	  loginPage.getLoginPhone("com.tsa.app.loginPage.login_phone").sendKeys("18210706623");
	  loginPage.getLoginPwd("com.tsa.app.loginPage.login_pssword").sendKeys("12345678");
	  TouchAction action=new TouchAction(driver);
	  action.tap(600, 300).perform();
	  action.tap(loginPage.getLoginBtn("com.tsa.app.loginPage.login_btn")).perform();
	  
	  result=loginPage.getLoginPhone("com.tsa.app.loginPage.login_phone").isDisplayed();
	  System.out.println(result==true?"登录失败，测试通过":"登录成功，没通过测试");
	  Assert.assertTrue(result);
  }
  
  //使用未注册的账号登录
  @Test(priority=1)
  public void loginWithUnregisteredAct() throws Exception {
	  System.out.println("*************开始执行第2条用例，使用未注册的手机号登录*******************");
	  loginPage.getLoginPhone("com.tsa.app.loginPage.login_phone").clear();
	  loginPage.getLoginPhone("com.tsa.app.loginPage.login_phone").sendKeys("182 0000 0077");
	  loginPage.getLoginPwd("com.tsa.app.loginPage.login_pssword").clear();
	  loginPage.getLoginPwd("com.tsa.app.loginPage.login_pssword").sendKeys("123456");
	  TouchAction action=new TouchAction(driver);
	  action.tap(600, 300).perform();
	  action.tap(loginPage.getLoginBtn("com.tsa.app.loginPage.login_btn")).perform();
	  
	  result=loginPage.getLoginBtn("com.tsa.app.loginPage.login_btn").isDisplayed();
	  Assert.assertTrue(result);
	  System.out.println(result==true?"登录失败，测试通过":"登录成功，没通过测试");
  }
  
  @Test(priority=2)
  public void LoginWithCorrectInfo() throws Exception {
	  System.out.println("*************开始执行第3条用例，使用正确信息登录************************");
	  ObtainEvidence obtainEvidence=LoginSystem.executeLogin("18210706623", "123456", loginPage);
	  result=obtainEvidence.cameraObtainEvidence("com.tsa.app.ObtainEvidence.camera").isDisplayed();
	  System.out.println(result==true?"成功登录，通过测试":"登录失败，没通过测试");
	  Assert.assertTrue(result);
	  System.out.println("\n");
	  System.out.println("**************************所有用例执行完毕*******************************");
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() throws MalformedURLException, InterruptedException {
	  //1.设置capabilities
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
	  //6.给LoginPage对象赋值
	  loginPage=new LoginPage(this.driver);
  }

  @AfterClass
  public void afterClass() {
  }

}

