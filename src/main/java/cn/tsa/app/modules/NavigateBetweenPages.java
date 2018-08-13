package cn.tsa.app.modules;

import cn.tsa.app.pageobjects.LoginPage;
import cn.tsa.app.pageobjects.PrivacyProtocolPage;
import cn.tsa.app.pageobjects.RegisterPage;
import cn.tsa.app.pageobjects.UsageProtocolPage;

public class NavigateBetweenPages {
	public static LoginPage backLoginFromRegister(RegisterPage registerPage,String elementNameInPropertyFile) throws Exception {
		registerPage.getBackBtn(elementNameInPropertyFile).click();
		return new LoginPage(registerPage.driver);
	}
	
	public static RegisterPage navigateToRegisterPage(LoginPage loginPage,String elementNameInPropertyFile) throws Exception {
		loginPage.getGoToRegister(elementNameInPropertyFile).click();
		return new RegisterPage(loginPage.driver);
	}
	
	public static UsageProtocolPage goToUsageProtocolPage(RegisterPage registerPage,String elementNameInPropertyFile) throws Exception {
		registerPage.getUsageProtocolLink(elementNameInPropertyFile).click();
		return new UsageProtocolPage(registerPage.driver);
	}
	
	public static RegisterPage backRegisterFromUsageProtocol(UsageProtocolPage usageProtocolPage,String elementNameInPropertyFile) throws Exception {
		usageProtocolPage.getBackBtn(elementNameInPropertyFile).click();
		return new RegisterPage(usageProtocolPage.driver);
	}
	
	public static PrivacyProtocolPage goToPrivacyProtocolPage(RegisterPage registerPage,String elementNameInPropertyFile) throws Exception {
		registerPage.getUsageProtocolLink(elementNameInPropertyFile).click();
		return new PrivacyProtocolPage(registerPage.driver);
	}
	
	public static RegisterPage backRegisterFromPrivacyProtocol(PrivacyProtocolPage privacyProtocolPage,String elementNameInPropertyFile) throws Exception {
		privacyProtocolPage.getBackBtn(elementNameInPropertyFile).click();
		return new RegisterPage(privacyProtocolPage.driver);
	}
}
