package com.ninzahrm.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Projects {
	WebDriver driver;
	public Projects(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 @FindBy(xpath = "//span[text()='Create Project']")
     private WebElement createProjectBtn;
	 
	 public WebElement getCreateProjectBtn() {
			return createProjectBtn;
		}
}
