import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ninzahrm.crm.fileUtility.*;
import com.ninzahrm.crm.ObjectRepositoryUtility.*;
import com.ninzahrm.crm.listenerbaseclass.BaseClass;
import com.ninzahrm.crm.webdriverUtility.WebDriverUtility;

public class CreatingProjectTest extends BaseClass {

	@Test(dataProvider = "getData")
	public void creatingProjectTest(String projectName, String projectManager, String projectValue)
			throws SQLException {
		HomePage hp = new HomePage(driver);
		hp.getProjectLink().click();
		Projects p = new Projects(driver);
		p.getCreateProjectBtn().click();
		CreateProjectPage cpp = new CreateProjectPage(driver);
		cpp.createProject(projectName, projectManager, projectValue);
		try {
			cpp.getaddProjectBtn().click();
		} catch (Exception e) {
		}
		ProjectSearchPage psp = new ProjectSearchPage(driver);
		try {
			psp.getprojectSearchDD().click();
			WebDriverUtility wLib = new WebDriverUtility();
			wLib.select(psp.getprojectSearchDD(), 1);
			psp.getprojectSearchValue().sendKeys(projectName);
		} catch (Exception e) {

		}
		ResultSet result = dbLib.executeConSelectQuery("select * from project");
		boolean flag=false;
		while (result.next()) {
			String actProjectName = result.getString(4);
			if (projectName.equals(actProjectName)) {
				flag = true;
				System.out.println(projectName + " is available==PASS");
			}
		}
		if (flag == false) {
			System.out.println(projectName + " isn't available==FAIL");
		}
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("Ninzahrm");

		Object[][] data = new Object[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			data[i][0] = eLib.getDataFromExcel("Ninzahrm", i + 1, 0) + jLib.getRandomNumber();
			data[i][1] = eLib.getDataFromExcel("Ninzahrm", i + 1, 1) + jLib.getRandomNumber();
			data[i][2] = eLib.getDataFromExcel("Ninzahrm", i + 1, 2);
		}
		return data;
	}
}