package testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.StartupPage;

public class LocatorsFactory extends StartupPage {
	//please write all the locators for facebook page only 
	
	By loginButton = By.xpath("//button[@name='login']"); 
	By EmailAddsPhoneNumberTextbox = By.xpath("//input[@placeholder='Email address or phone number']"); 
	By passwordTextbox = By.xpath("//input[@placeholder='Password']"); 
	By profileIconImage = By.xpath("(//div//div//span)[14]");
	By logoutButton = By.xpath("//span[contains(text (), 'Log out')]"); 
	By forgettenPasswordLink = By.xpath("//a[.='Forgotten password?']"); 
	By createNewAccountLink = By.xpath("//a[contains(text() , 'Create new account')]"); 
	By emailTextField = By.id("email"); 
	By FacebookPageTitle = By.xpath("//title[@id='pageTitle']");
	By createNewAccount = By.xpath("//a[contains(text() , 'Create new account')]"); 
	
	By SignUpButton = By.xpath("//button[@name=\"websubmit\"]"); 
	By FirstNameTextField = By.xpath("//input[@name=\"firstname\"]"); 
	By newPassword = By.xpath("(//input[@type=\"password\"])[2]");
	By selectBirthDayMonth = By.xpath("//select[@name='birthday_month']");
	By selectBirthDayYear = By.xpath("//select[@name='birthday_year']");
	By selectMaleRadioButton = By.xpath("//label[contains(text() , 'Male')]");
	By selectFemaleRadioButton = By.xpath("//label[contains(text() , 'Female')]");
	By customRadioButton = By.xpath("//label[contains(text() , 'Custom')]");
	By selectYourPronounDropdown = By.xpath("//select[@name='preferred_pronoun']");
	By genderOptionalTextBox = By.xpath("//input[@name='custom_gender']");
	
	By notificationIcon=By.xpath("//a[@aria-label=\"Notifications, 2 unread\"]");
	By editProfileButton=By.xpath("(//span[.='Edit profile'])[1]");
	By addToStoryButton=By.xpath("//span[contains(text(),'Add to story')]");
	By ediDetailsButton=By.xpath("(//span[.='Edit details'])[2]");
	By workAndEducationIcon=By.xpath("//span[.='Work and education']");
	By companyTextField=By.xpath("//input[@aria-label=\"Company\"]");
	By currentCityTextField=By.xpath("//label[@aria-label=\"Current town/city\"]");
	By homeTownTextField=By.xpath("//label[contains(@aria-label,'Home town')]");
	By schoolTextFieldPresentInsideSecondarySchoolTextField=By.xpath("//input[@aria-label=\"School\"]");
	By LogoutButton=By.xpath("//span[.='Log out']");
	By accountIcon=By.xpath("(//div[contains(@class,\"x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z\")])[1]");
	
	

	 
	public LocatorsFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	//Expected data will be fetch from config.json file,path of the json file is:FaceBook_Automation_Dummy/src/main/resources/config.json

	public WebElement getLoginButton(WebDriver driver) {
		WebElement loginButtonWebElement = driver.findElement(loginButton);
    return loginButtonWebElement;
}
	
	
	public WebElement getEmailAddsPhoneNumberTextfield(WebDriver driver) {
		WebElement EmailAddsPhoneNumberWebElement = driver.findElement(EmailAddsPhoneNumberTextbox);
        return EmailAddsPhoneNumberWebElement;
    }
	
	public WebElement getPasswordTextfield(WebDriver driver) {
		WebElement passwordWebElement = driver.findElement(passwordTextbox);
        return passwordWebElement;
    }
	
	public WebElement getLogOutButton(WebDriver driver) {
		WebElement logoutButtonWebElement = driver.findElement(logoutButton);
        return logoutButtonWebElement;
    }
	
	public WebElement forgettenPasswordLink(WebDriver driver) {
		WebElement forgettenPasswordLinkWebElement = driver.findElement(forgettenPasswordLink);
        return forgettenPasswordLinkWebElement;
    }
	
	public WebElement createNewAccountLink(WebDriver driver) {
		WebElement createNewAccountLinkWebElement = driver.findElement(createNewAccountLink);
        return createNewAccountLinkWebElement;
    }
	
	public WebElement emailTextField(WebDriver driver) {
		WebElement emailTextFieldWebElement = driver.findElement(emailTextField);
        return emailTextFieldWebElement;
    }
	
	public WebElement getFacebookPageTitle(WebDriver driver) {
		WebElement FacebookPageTitleWebElement = driver.findElement(FacebookPageTitle);
        return FacebookPageTitleWebElement;
    }
	
	public WebElement getCreateNewAccount(WebDriver driver) {
		WebElement CreateNewAccountWebElement = driver.findElement(createNewAccount);
        return CreateNewAccountWebElement;
    }
	
	public WebElement signUpButton(WebDriver driver) {
		WebElement SignUpButtonWebElement = driver.findElement(SignUpButton);
        return SignUpButtonWebElement;
    }
	public WebElement firstNameTextField(WebDriver driver) {
		WebElement firstNameTextFieldWebElement = driver.findElement(FirstNameTextField);
        return firstNameTextFieldWebElement;
    }
	
	public WebElement newpasswordTextField(WebDriver driver) {
		WebElement newPasswordWebElement = driver.findElement(newPassword);
        return newPasswordWebElement;
    }
	
	public WebElement selectBirthDayMonth(WebDriver driver) {
		WebElement selectbirthdayMonthWebElement = driver.findElement(selectBirthDayMonth);
        return selectbirthdayMonthWebElement;
    }
	
	public WebElement selectBirthDayYear(WebDriver driver) {
		WebElement selectBirthDayYearWebElement = driver.findElement(selectBirthDayYear);
        return selectBirthDayYearWebElement;
    }
	
	public WebElement femaleRadioButton(WebDriver driver) {
		WebElement selectFemaleRadioButtonWebElement = driver.findElement(selectFemaleRadioButton);
        return selectFemaleRadioButtonWebElement;
    }
	
	public WebElement maleRadioButton(WebDriver driver) {
		WebElement selectMaleRadioButtonWebElement = driver.findElement(selectMaleRadioButton);
        return selectMaleRadioButtonWebElement;
    }
	
	public WebElement customRadioButton(WebDriver driver) {
		WebElement customRadioButtonWebElement = driver.findElement(customRadioButton);
        return customRadioButtonWebElement;
    }
	
	public WebElement selectYourPronounDropdown(WebDriver driver) {
		WebElement selectYourPronounDropdownWebElement = driver.findElement(selectYourPronounDropdown);
        return selectYourPronounDropdownWebElement;
    }
	
	public WebElement genderOptionalTextBox(WebDriver driver) {
		WebElement genderOptionalTextBoxWebElement = driver.findElement(genderOptionalTextBox);
        return genderOptionalTextBoxWebElement;
    }
	
	public WebElement notificationIconIsPresent(WebDriver driver) {
		WebElement notificationIconWebElement = driver.findElement(notificationIcon);
        return notificationIconWebElement;
    }
	public WebElement editProfileButtonIsPresent(WebDriver driver) {
		WebElement editProfileButtonWebElement = driver.findElement(editProfileButton);
        return editProfileButtonWebElement;
    }
	public WebElement addToStoryButtonIsPresent(WebDriver driver) {
		WebElement addToStoryButtonWebElement = driver.findElement(addToStoryButton);
        return addToStoryButtonWebElement;
    }
	public WebElement editDetailsFieldIsPresent(WebDriver driver) {
		WebElement ediDetailsButtonWebElement = driver.findElement(ediDetailsButton);
        return ediDetailsButtonWebElement;
    }
	public WebElement workAndEducationIconIsPresent(WebDriver driver) {
		WebElement workAndEducationIconWebElement = driver.findElement(workAndEducationIcon);
        return workAndEducationIconWebElement;
    }
	public WebElement companyTextFieldIsPresent(WebDriver driver) {
		WebElement companyTextFieldWebElement = driver.findElement(companyTextField);
        return companyTextFieldWebElement;
    }
	
	public WebElement currentCityTextFieldIsPresent(WebDriver driver) {
		WebElement currentCityTextFieldWebElement = driver.findElement(currentCityTextField);
        return currentCityTextFieldWebElement;
    }
	
	public WebElement homeTownTextFieldIsPresent(WebDriver driver) {
		WebElement homeTownTextFieldWebElement = driver.findElement(homeTownTextField);
        return homeTownTextFieldWebElement;
    }
	public WebElement schoolTextFieldPresentInsideSecondarySchoolTextFieldIsPresent(WebDriver driver) {
		WebElement schoolTextFieldPresentInsideSecondarySchoolTextFieldWebElement = driver.findElement(schoolTextFieldPresentInsideSecondarySchoolTextField);
        return schoolTextFieldPresentInsideSecondarySchoolTextFieldWebElement;
    }
	public WebElement logOutButtonIsPresent(WebDriver driver) {
		WebElement LogoutButtonWebElement = driver.findElement(LogoutButton);
    return LogoutButtonWebElement;
	}
    public WebElement accountIconIsPresent(WebDriver driver) {
		WebElement accountIconWebElement = driver.findElement(accountIcon);
    return accountIconWebElement;
}
	
}
