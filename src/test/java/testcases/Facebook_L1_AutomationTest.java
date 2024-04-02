

package testcases;

import java.util.Map;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.FaceBookPage;
import pages.StartupPage;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class Facebook_L1_AutomationTest extends AppTestBase {
	
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	FaceBookPage FaceBookPageInstance;
	LocatorsFactory LocatorsFactoryInstance = new LocatorsFactory(driver);
	
	
	@Parameters({"browser", "environment"})
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readJson(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);
		
		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl, configData.get("url")+" might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}
	
	@Test(priority = 1, groups = {"sanity"}, description="Navigate to the URL and Validate the fa LogIn Page Title")
	public void validateFacebookTitleofLoginPage() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "LoginPage_Title");
		Assert.assertEquals(FaceBookPageInstance.validateFacebookTitleOfLoginPage(), expectedData.get("loginpageTitle"));
		Assert.assertTrue(LocatorsFactoryInstance.getLoginButton(driver).isDisplayed(), "login button is not present in the current page, Please check manually");
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="verify Presence Of All Fields in The Login Page")
	public void verifyPresenceOfAllFieldsinTheLoginPage() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.verifyPresenceOfALlFields(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.getLoginButton(driver).isDisplayed(), "login button is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 3, groups = {"sanity"}, description="validate the error message, when user does not provide any credentials")
	public void validateErrorMessageWithoutProvideAnyCredentials() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "errorMessage");
		Assert.assertEquals(FaceBookPageInstance.validateErrorMessageWithoutProvideAnyCredentials(), expectedData.get("errorMessageText2"), "error message is not matching, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.emailTextField(driver).isDisplayed(), "Email Text Field is not present in the current page, Please check manually");
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}
	
	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}