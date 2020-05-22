package TestCases;

import org.testng.annotations.Test;

import Pages.RegisterExcelUsers;
import Pages.RegisterUser;
import Utilities.ExcelUtils;
import Utilities.TestBase;

public class RegisterUserFromExcelData extends TestBase {
	@Test
	public static void Execute() throws Exception {
		String path = System.getProperty("user.dir")+TestBase.prop.getProperty("Path_TestData");
		String sheetname = TestBase.prop.getProperty("File_TestData");

		// This is to get the values from Excel sheet, passing parameters (Row num &amp;
		// Col num)to getCellData method
		ExcelUtils excel = new ExcelUtils(path, sheetname);
		String remail = excel.getCellData(2, 0);

		String rpassword = excel.getCellData(2, 1);
		System.out.println("Email Address is" + remail);
		System.out.println("password is" + rpassword);

		RegisterUser rs = new RegisterUser(driver);
		rs.skipsign();
		RegisterExcelUsers reu = new RegisterExcelUsers(driver);
		reu.navigateToPracticeSite();
		Thread.sleep(5000);
		reu.chartEmail().sendKeys(remail);
		Thread.sleep(5000);
		reu.chartPassword().sendKeys(rpassword);
		Thread.sleep(5000);
		reu.register().click();
		Thread.sleep(5000);

	}
}
