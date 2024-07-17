package com.ninzahrm.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninzahrm.crm.webdriverUtility.WebDriverUtility;
	
public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Home")
	private WebElement homeLink;
	
	@FindBy(linkText="Projects")
	private WebElement projectLink;
	
	@FindBy(linkText="Employees")
	private WebElement employeesLink;
	
	@FindBy(linkText="WorkSheet")
	private WebElement workSheetLink;
	
	@FindBy(linkText="Status")
	private WebElement statusLink;
	
	@FindBy(linkText="Settings")
	private WebElement settingsLink;
	
	@FindBy(linkText="Manage")
	private WebElement manageLink;
	
	@FindBy(linkText="About")
	private WebElement aboutLink;
	
	@FindBy(className="user-icon")
	private WebElement signOutLink;

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getProjectLink() {
		return projectLink;
	}

	public WebElement getEmployeesLink() {
		return employeesLink;
	}

	public WebElement getWorkSheetLink() {
		return workSheetLink;
	}
	
	public WebElement getStatusLink() {
		return statusLink;
	}

	public WebElement getSettingsLink() {
		return settingsLink;
	}

	public WebElement getManageLink() {
		return manageLink;
	}

	public WebElement getAboutLink() {
		return aboutLink;
	}
	
	public WebElement getsignOutLink() {
		return signOutLink;
	}
	
	public void logOut() {
		waitForElementPresent(driver, signOutLink);
		Actions action = new Actions(driver);
		action.moveToElement(signOutLink).perform();
		signOutLink.click();
	}	
}
