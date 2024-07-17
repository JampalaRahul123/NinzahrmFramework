package com.ninzahrm.crm.listenerbaseclass;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ninzahrm.crm.databaseUtility.DataBaseUtility;
import com.ninzahrm.crm.fileUtility.ExcelUtility;
import com.ninzahrm.crm.fileUtility.FileUtility;
import com.ninzahrm.crm.ObjectRepositoryUtility.HomePage;
import com.ninzahrm.crm.ObjectRepositoryUtility.LoginPage;
import com.ninzahrm.crm.webdriverUtility.JavaUtility;

public class BaseClass {
	/*Create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver = null;
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("====connect to DB, Report Config===");
		dbLib.getDbconnection();
			}
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("===launch browser===");
		String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("=login=");
		LoginPage lp = new LoginPage(driver);
		String URL = System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username",fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",fLib.getDataFromPropertiesFile("password"));
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("=logout=");
		HomePage hp = new HomePage(driver);
		try {
		hp.logOut();
		}catch(Exception e) {
			
		}
	}

	@AfterClass
	public void configAC() {
		System.out.println("===close the browser===");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===close Db, Report backup===");
		dbLib.closeDbConnection();
	}
}
