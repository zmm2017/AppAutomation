package cn.tsa.app.modules;

import cn.tsa.app.pageobjects.LoginPage;
import cn.tsa.app.pageobjects.RegisterPage;

public class NavigateToRegisterPage {
	public static RegisterPage execute(LoginPage loginPage) throws Exception {
		loginPage.getGoToRegister("com.tsa.app.loginPage.goto_register").click();
		return new RegisterPage(loginPage.driver);
	}

}
