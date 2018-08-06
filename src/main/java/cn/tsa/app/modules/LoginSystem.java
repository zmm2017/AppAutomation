package cn.tsa.app.modules;

import cn.tsa.app.pageobjects.LoginPage;
import cn.tsa.app.pageobjects.ObtainEvidence;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class LoginSystem {
	public static ObtainEvidence obtainEvidence=null;
	public static ObtainEvidence executeLogin(String userName,String Pwd, LoginPage loginPage) throws Exception {
		loginPage.getLoginPhone("com.tsa.app.loginPage.login_phone").clear();
		loginPage.getLoginPhone("com.tsa.app.loginPage.login_phone").sendKeys(userName);
		loginPage.getLoginPwd("com.tsa.app.loginPage.login_pssword").clear();
		loginPage.getLoginPwd("com.tsa.app.loginPage.login_pssword").sendKeys(Pwd);
		
		TouchAction action=new TouchAction((PerformsTouchActions) loginPage.driver);
		action.tap(600, 300).perform();
		action.tap(loginPage.getLoginBtn("com.tsa.app.loginPage.login_btn")).perform();
		
		obtainEvidence=new ObtainEvidence(loginPage.driver);
		return obtainEvidence;
	}

}
