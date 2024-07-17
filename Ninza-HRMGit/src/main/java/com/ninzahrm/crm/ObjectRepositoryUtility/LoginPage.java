package com.ninzahrm.crm.ObjectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninzahrm.crm.webdriverUtility.WebDriverUtility;
	
public class LoginPage extends WebDriverUtility{ 
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameEdit;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordEdit;
	
	@FindBy(xpath="//button[.='Sign in']")
	private WebElement loginBtn;
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToapp(String URL,String username, String password) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
}
