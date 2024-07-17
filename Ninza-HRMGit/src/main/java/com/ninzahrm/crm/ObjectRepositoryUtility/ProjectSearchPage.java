package com.ninzahrm.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninzahrm.crm.webdriverUtility.WebDriverUtility;

public class ProjectSearchPage extends WebDriverUtility{
	WebDriver driver;
	public ProjectSearchPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "(//div[@class='col-sm-6'])[last()-1]")
	private WebElement projectSearchDD;
	
	@FindBy(xpath = "(//div[@class='col-sm-6'])[last()]")
	private WebElement projectSearchValue;
	
	public WebElement getprojectSearchDD() {
		return projectSearchDD;
	}
	
	public WebElement getprojectSearchValue() {
		return projectSearchValue;
	}
}
