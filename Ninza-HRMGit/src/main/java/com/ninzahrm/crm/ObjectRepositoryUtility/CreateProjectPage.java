package com.ninzahrm.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ninzahrm.crm.webdriverUtility.WebDriverUtility;

public class CreateProjectPage extends WebDriverUtility{

	WebDriver driver;
	public CreateProjectPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
		@FindBy(xpath = "//input[@name='projectName']")
		private WebElement projectNameEdit;
		
		@FindBy(xpath ="//input[@name='createdBy']")
		private WebElement projectManagerEdit;

		@FindBy(xpath = "//input[@value='Add Project']")
		private WebElement addProjectBtn;
		
		@FindBy(xpath = "//input[@value='Cancel']")
		private WebElement cancelBtn;
		
		@FindBy(xpath = "(//div[@class='form-group']/select[@name='status'])[last()]")
		private WebElement projectStatusDD;
		
		public WebElement getaddProjectBtn() {
			return addProjectBtn;
		}
		
		public WebElement getcancelBtn() {
			return cancelBtn;
		}
		
		public WebElement getprojectStatusDD() {
			return projectStatusDD;
		}
		
		public void createProject(String projectName) { 
			try {
			projectNameEdit.sendKeys(projectName);
			addProjectBtn.click();
			}catch(Exception e) {
				
			}
		}
		
		public void createProject(String projectName,String projectManager) {
			try {
			projectNameEdit.sendKeys(projectName);
			projectManagerEdit.sendKeys(projectManager);
			addProjectBtn.click();	
			}catch(Exception e) {
				
			}
		}
		
		public void createProject(String projectName,String projectManager,String projectValue) {
			try {
			projectNameEdit.sendKeys(projectName);
			projectManagerEdit.sendKeys(projectManager);
			Select select = new Select(projectStatusDD);
			select.selectByVisibleText(projectValue);
			addProjectBtn.click();	
			waitForElementPresent(driver, addProjectBtn);
			}catch(Exception e) {
				
			}
		}
	}
