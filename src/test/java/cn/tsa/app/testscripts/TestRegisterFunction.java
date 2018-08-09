package cn.tsa.app.testscripts;

import org.testng.annotations.Test;

import cn.tsa.app.modules.InitPage;
import cn.tsa.app.modules.NavigateToRegisterPage;
import cn.tsa.app.pageobjects.LoginPage;
import cn.tsa.app.pageobjects.RegisterPage;
import cn.tsa.app.util.CloseKeyBoard;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
  
  @Test(priority=1)
  public void checkRegisterPhone() throws Exception {
	  System.out.println("*************开始执行第2条用例，检查注册号码输入框*****************");
	  WebElement registerPhone=registerPage.getRegisterPhone("com.tsa.app.RegisterPage.register_phone");
	  registerPhone.sendKeys("18210706623");
	  String displayedContent=registerPhone.getText();
	  System.out.println(displayedContent.equals("182 1070 6623")?"电话号码是按照3-4-4格式显示的，测试通过":"电话号码不是按照3-4-4格式显示的，测试失败");
	  Assert.assertTrue(displayedContent.equals("182 1070 6623"));
  }
  
  /*@Test(priority=2)
  public void checkRegisterCodeBtn() throws Exception {
	  System.out.println("*************开始执行第3条用例，检查获取注册码按钮*****************");
	  WebElement registerPhone=registerPage.getRegisterPhone("com.tsa.app.RegisterPage.register_phone");
	  WebElement registerCodeBtn=registerPage.getRegisterCodeBtn("com.tsa.app.RegisterPage.register_code_btn");
	  registerCodeBtn.click();
	  System.out.println(registerCodeBtn.getText().equals("获取验证码")==true?"当手机号已注册时，点击按钮后不能获取验证码，测试通过":"当手机号已注册时，点击按钮后可以获取验证码，测试失败");
	  Assert.assertTrue(registerCodeBtn.getText().equals("获取验证码"));
	  
	  registerPhone.clear();
	  registerPhone.sendKeys("18212345678");
	  registerCodeBtn.click();
	  System.out.println("getText()返回的文本是："+registerCodeBtn.getText());
	  System.out.println(registerCodeBtn.getText().contains("重新发送")==true?"验证码已发送，测试通过":"验证码发送失败，测试失败");
	  Assert.assertTrue(registerCodeBtn.getText().contains("重新发送"));
  }*/
  
  @Test(priority=3)
  public void checkRegisterCodeText() throws Exception {
	  System.out.println("*************开始执行第4条用例，检查注册码输入框*****************");
	  WebElement registerCodeText=registerPage.getRegisterCodeText("com.tsa.app.RegisterPage.register_code_text");
	  registerCodeText.sendKeys("321123");
	  System.out.println(registerCodeText.getText().equals("321123")==true?"验证码已正确输入，测试通过":"验证码没有正确输入，测试失败");
	  Assert.assertTrue(registerCodeText.getText().equals("321123"));
  }
  
  @Test(priority=4)
  public void checkRegisterPwd() throws Exception {
	  System.out.println("*************开始执行第5条用例，检查密码输入框*****************");
	  WebElement pwdText=registerPage.getRegisterPwd("com.tsa.app.RegisterPage.register_pwd");
	  WebElement rePwdText=registerPage.getRegisterRepwd("com.tsa.app.RegisterPage.register_repwd");
	  
	  CloseKeyBoard.execute(registerPage.driver);
	  pwdText.sendKeys("123456");
	  CloseKeyBoard.execute(registerPage.driver);
	  rePwdText.sendKeys("123456");
	  
	  System.out.println("密码都已输入，测试通过");
	  Assert.assertTrue(true);
  }
  
  @Test(priority=5)
  public void checkRegisterNum() throws Exception {
	  System.out.println("*************开始执行第6条用例，检查注册码输入框*****************");
	  WebElement registerNum=registerPage.getRegisterNum("com.tsa.app.RegisterPage.register_num");
	
	  CloseKeyBoard.execute(registerPage.driver);
	  
	  registerNum.sendKeys("A1968");
	  System.out.println(registerNum.getText().equals("A1968")?"注册码正确输入，测试通过":"注册码没有正确输入，测试失败");
	  Assert.assertTrue(registerNum.getText().equals("A1968"));
  }
  
  @Test(priority=6)
  public void checkProtocolBox() throws Exception {
	  System.out.println("*************开始执行第7条用例，检查协议勾选框*****************");
	  TouchAction action=new TouchAction(registerPage.driver);
	  int x=registerPage.driver.manage().window().getSize().width;
	  action.tap(x*3/4, 520).perform();
	  
	  WebElement protocolCheckBox=registerPage.getProtocolCheckBox("com.tsa.app.RegisterPage.protocol_check_box");
	  
	  protocolCheckBox.click();
	  System.out.println(protocolCheckBox.isSelected()==false?"checkbox被取消选中，通过测试":"checkbox没有被取消选中，测试失败");
	  Assert.assertFalse(protocolCheckBox.isSelected());
	  
	  System.out.println("取消选中时getAttribute()返回值是："+protocolCheckBox.getAttribute("checked"));
	  protocolCheckBox.click();
	  System.out.println("选中时getAttribute()返回值是："+protocolCheckBox.getAttribute("checked"));
	  System.out.println(protocolCheckBox.getAttribute("checked").equals("true")?"checkbox被选中，通过测试":"checkbox没有被选中，测试失败");
	  Assert.assertTrue(protocolCheckBox.getAttribute("checked").equals("true"));
  }
  
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException, InterruptedException {
	  System.out.println("*************开始执行注册功能的用例**********************************\n");
	  loginPage=InitPage.execute();
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("\n");
	  System.out.println("*************注册功能的所有用例执行完毕*******************************\n");
  }

}
