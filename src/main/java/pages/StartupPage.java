package pages;

import org.openqa.selenium.WebDriver;

import coreUtilities.utils.CommonEvents;

public class StartupPage {
	
	public WebDriver driver;
	public CommonEvents commonEvents;
	
	public StartupPage(WebDriver driver) {
		this.driver = driver;
		commonEvents = new CommonEvents(driver);
	}
	
//	public LoginPage navigateToLoginPage() {
//		return new LoginPage(driver);
//	}
	
	public void navigateToUrl(String url) throws Exception {
		
		commonEvents.navigateTo(url);		
	}

}
