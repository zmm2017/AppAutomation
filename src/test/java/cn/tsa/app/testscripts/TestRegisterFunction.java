package cn.tsa.app.testscripts;

import org.testng.annotations.Test;

import cn.tsa.app.modules.InitPage;
import cn.tsa.app.modules.NavigateToRegisterPage;
import cn.tsa.app.pageobjects.LoginPage;
import cn.tsa.app.pageobjects.RegisterPage;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class TestRegisterFunction {
	public AndroidDriver driver=null;
	public static LoginPage loginPage=null;
	public static RegisterPage registerPage=null;
	public static Boolean result=null;
	
  @Test(priority=0)
  public void loadRegisterPage() throws Exception {
	  System.out.println("*************开始执行第1条用例，从登录页面跳转到注册页面*****************");
	  registerPage=NavigateToRegisterPage.execute(loginPage);
	  result=registerPage.getPageTitle("com.tsa.app.RegisterPage.page_title").isDisplayed();
	  System.out.println(result==true?"跳转成功，通过测试":"跳转失败，没有通过测试");
	  Assert.assertTrue(result);
	  
  }
  
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException, InterruptedException {
	  System.out.println("*************开始执行注册功能的用例**********************************\n");
	  loginPage=InitPage.execute();
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("\n");
	  System.out.println("*************注册功能的所有用例执行完毕*******************************");
  }

}
